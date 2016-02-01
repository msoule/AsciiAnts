package pokebowl.screen

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.graphics.{Color, GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.{Gdx, InputAdapter, Screen}
import pokebowl.controller.PlayMode
import pokebowl.core.Application
import pokebowl.game.{ScoreBoard, PlayCalculator, GameState}
import pokebowl.model.team.{Team, DenverBroncos, CarolinaPanthers}

import scala.util.Random

/**
  * The main play screen of the game.
  *
  * @author Mark Soule on 1/26/16.
  */
class PlayScreen(width: Float, height: Float, game: Application, background: Color=Color.WHITE) extends InputAdapter with Screen {

  var batch: SpriteBatch = _
  var shapeRenderer: ShapeRenderer = _
  var camera: OrthographicCamera = _
  var battleScreen: Texture = _
  var pokemonFont: FreeTypeFontGenerator = _
  var smallFontSize: FreeTypeFontParameter = _
  var cursorPosition = 2
  var playSelect: Option[Int] = _
  var textToDraw: Seq[String] = Seq()
  var drawText: Boolean = false
  var gameState: GameState = _
  var scoreBoard: ScoreBoard = _

  var playerTeam: Team = _
  var npcTeam: Team = _

  override def resize(width: Int, height: Int): Unit = {

  }

  override def hide(): Unit = {

  }

  override def dispose(): Unit = {
    if(pokemonFont != null) pokemonFont.dispose()
    if(shapeRenderer != null) shapeRenderer.dispose()
    if(batch != null) batch.dispose()
    if(playerTeam != null && playerTeam.sprite != null) playerTeam.sprite.dispose()
    if(playerTeam != null && playerTeam.spriteFlip != null) playerTeam.spriteFlip.dispose()
    if(npcTeam != null && npcTeam.sprite != null) npcTeam.sprite.dispose()
    if(npcTeam != null && npcTeam.spriteFlip != null) npcTeam.spriteFlip.dispose()
    if(battleScreen != null) battleScreen.dispose()
  }

  override def pause(): Unit = {

  }

  /**
    * Draw new screen and process user input.
    * @param delta Time in seconds since last render.
    */
  override def render(delta: Float): Unit = {
    // clear the screen with a dark blue color. The
    // arguments to glClearColor are the red, green
    // blue and alpha component in the range [0,1]
    // of the color to be used to clear the screen.
    Gdx.gl.glClearColor(1f, 1f, 1f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    // tell the camera to update its matrices.
    camera.update()
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    batch.draw(battleScreen, 0, 0)
    batch.draw(playerTeam.sprite, 40, 220)
    batch.draw(npcTeam.spriteFlip, width - 250, height - 200)
    batch.end()

    if(drawText)
      controlTextBox(delta)
    else
      gameState.playMode match {
        case PlayMode.KickOff => kickOffEvent()
        case PlayMode.ExtraPoint => extraPointEvent()
        case PlayMode.SelectPlay => controlMenu(delta)
        case PlayMode.EndGame => Gdx.app.exit()
      }

    drawScoreBoard()
  }

  private def kickOffEvent() = {
    textToDraw = textToDraw ++ PlayCalculator.kickOffResults(gameState)
    drawText = true
  }

  private def extraPointEvent() = {
    textToDraw = textToDraw ++ PlayCalculator.extraPointResults(gameState)
    drawText = true
  }

  private def triggerTextBox(cursor: Int) = {
    // player's choice
    val playerChoice = cursor - 1
    // npc's choice... stupid ai
    var npcChoice = 1
    // go for field goal
    if(gameState.down == 4 && gameState.lineOfScrimmage > 60) {
      npcChoice = 3
    }
    // go for punt
    else if(gameState.down == 4) {
      npcChoice = 2
    }

    var offenceChoice = playerChoice
    var defenceChoice = npcChoice
    if(playerTeam != gameState.possession) {
      offenceChoice = npcChoice
      defenceChoice = playerChoice
    } else {
      offenceChoice = playerChoice
      defenceChoice = npcChoice
    }

    // Calculate results of play and advance the game state.
    textToDraw = textToDraw ++ PlayCalculator.playEndResults(offenceChoice, defenceChoice, gameState)
    drawText = true
  }

  private def controlMenu(delta: Float): Unit = {
    drawMenu()

    // Check for user input and move the cursor as specified.
    if (Gdx.input.isKeyPressed(Keys.RIGHT) && cursorPosition == 1) cursorPosition = 4
    if (Gdx.input.isKeyPressed(Keys.RIGHT) && cursorPosition == 2) cursorPosition = 3
    if (Gdx.input.isKeyPressed(Keys.LEFT) && cursorPosition == 3) cursorPosition = 2
    if (Gdx.input.isKeyPressed(Keys.LEFT) && cursorPosition == 4) cursorPosition = 1
    if (Gdx.input.isKeyPressed(Keys.DOWN) && cursorPosition == 2) cursorPosition = 1
    if (Gdx.input.isKeyPressed(Keys.DOWN) && cursorPosition == 3) cursorPosition = 4
    if (Gdx.input.isKeyPressed(Keys.UP) && cursorPosition == 1) cursorPosition = 2
    if (Gdx.input.isKeyPressed(Keys.UP) && cursorPosition == 4) cursorPosition = 3

    if (Gdx.input.isKeyJustPressed(Keys.Z)) triggerTextBox(cursorPosition)
  }

  private def controlTextBox(delta: Float) = {
    drawTextBox()

    if (Gdx.input.isKeyJustPressed(Keys.Z)) {
      textToDraw = textToDraw.tail
      drawText = textToDraw.nonEmpty
      if(!drawText) {
        updateScoreBoard()
      }
    }
  }

  private def drawMenu(): Unit = {
    val boxStart = (30, 35)
    val menuBoxWidth = 573
    val menuBoxHeight = 128

    // draw menu text
    val menuFont = pokemonFont.generateFont(smallFontSize)
    val menuPadding = 30
    val playMenuPosition1 = (boxStart._1 + menuPadding, boxStart._2 + menuBoxHeight/4 + 5)
    val playMenuPosition2 = (boxStart._1 + menuPadding, boxStart._2 + 3*menuBoxHeight/4 + 5)
    val playMenuPosition3 = (boxStart._1 + menuPadding + menuBoxWidth / 2, boxStart._2 + 3*menuBoxHeight/4 + 5)
    val playMenuPosition4 = (boxStart._1 + menuPadding + menuBoxWidth / 2, boxStart._2 + menuBoxHeight/4 + 5)
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    menuFont.draw(batch, playerTeam.plays(0).getName, playMenuPosition1._1, playMenuPosition1._2)
    menuFont.draw(batch, playerTeam.plays(1).getName, playMenuPosition2._1, playMenuPosition2._2)
    menuFont.draw(batch, playerTeam.plays(2).getName, playMenuPosition3._1, playMenuPosition3._2)
    menuFont.draw(batch, playerTeam.plays(3).getName, playMenuPosition4._1, playMenuPosition4._2)
    batch.end()

    // draw cursor
    val cursorWidthPadding = 5
    val cursorHeightPadding = 7
    val cursorWidth = 14
    val cursorHalfHeight = 9
    val cursorDrawPosition = cursorPosition match {
      case 1 => playMenuPosition1
      case 2 => playMenuPosition2
      case 3 => playMenuPosition3
      case 4 => playMenuPosition4
      // default
      case _ => playMenuPosition2
    }

    shapeRenderer.begin(ShapeType.Filled)
    shapeRenderer.setColor(0, 0, 0, 0)
    shapeRenderer.triangle(cursorDrawPosition._1 - cursorWidthPadding, cursorDrawPosition._2 - cursorHeightPadding, cursorDrawPosition._1 - cursorWidthPadding - cursorWidth, cursorDrawPosition._2 + cursorHalfHeight - cursorHeightPadding, cursorDrawPosition._1 - cursorWidthPadding - cursorWidth, cursorDrawPosition._2 - cursorHalfHeight - cursorHeightPadding)
    shapeRenderer.end()
  }

  private def drawTextBox(): Unit = {
    val startXY = (30, 35)
    val textBoxHeight = 128

    val menuFont = pokemonFont.generateFont(smallFontSize)
    val textBuffer = 30
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    menuFont.draw(batch, textToDraw.head, startXY._1 + textBuffer, startXY._2 + textBoxHeight / 2 + smallFontSize.size)
    batch.end()
  }

  private def updateScoreBoard() = {
    scoreBoard.update(
      gameState.homeScore,
      gameState.awayScore,
      gameState.down,
      gameState.firstDownMarker - gameState.lineOfScrimmage,
      gameState.lineOfScrimmage,
      gameState.currentQuarter,
      gameState.playCount
    )
  }

  private def drawScoreBoard(): Unit = {
    val startXY = (75, height - 50)

    val menuFont = pokemonFont.generateFont(smallFontSize)
    val yardsToFirst = if(scoreBoard.lineOfScrimmage >= (gameState.MAX_YARDS - gameState.FIRST_DOWN_YARDS)) "goal" else scoreBoard.yardsToFirst.toString
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    menuFont.draw(batch, s"${scoreBoard.awayScore} to ${scoreBoard.homeScore} Q${scoreBoard.quarter} P${scoreBoard.clock}", startXY._1, startXY._2)
    menuFont.draw(batch, s"${scoreBoard.down} and $yardsToFirst at ${gameState.getFieldPositionText}", startXY._1, startXY._2 - smallFontSize.size)
    if(playerTeam == gameState.possession)
      menuFont.draw(batch, "OFFENSE", width - 300, 260)
    else {
      menuFont.draw(batch, "DEFENSE", width - 300, 260)
    }

    batch.end()
  }

  /**
    * Initializes the screen at creation.
    */
  override def show(): Unit = {
    // create the camera and the SpriteBatch
    camera = new OrthographicCamera()
    camera.setToOrtho(false, width, height)
    batch = new SpriteBatch()
    shapeRenderer = new ShapeRenderer()

    battleScreen = new Texture(Gdx.files.internal("menu/battlescreen.png"))

    // init fonts
    pokemonFont = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Pokemon GB.ttf"))
    smallFontSize = new FreeTypeFontParameter()
    smallFontSize.size = 18
    smallFontSize.color = Color.BLACK

    // init selector
    playSelect = None

    // init player
    playerTeam = CarolinaPanthers.team
    npcTeam = DenverBroncos.team

    if(game.playerPanthers) {
      playerTeam = CarolinaPanthers.team
      npcTeam = DenverBroncos.team
    } else {
      playerTeam = DenverBroncos.team
      npcTeam = CarolinaPanthers.team
    }

    textToDraw = textToDraw :+ s"Flipping coin"
    if(GameState.rand.nextBoolean()) {
      gameState = new GameState(playerTeam, npcTeam)
      textToDraw = textToDraw :+ s"${npcTeam.location} will receive first"
    }
    else {
      gameState = new GameState(npcTeam, playerTeam)
      textToDraw = textToDraw :+ s"${playerTeam.location} will receive first"
    }

    drawText = true
    gameState.playMode = PlayMode.KickOff
    scoreBoard = new ScoreBoard
  }

  override def resume(): Unit = {

  }
}
