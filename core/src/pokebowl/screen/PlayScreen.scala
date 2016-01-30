package pokebowl.screen

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.graphics.{Color, GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.math.{Rectangle, Vector3}
import com.badlogic.gdx.{Game, Gdx, InputAdapter, Screen}
import pokebowl.controller.PlayMode
import pokebowl.controller.PlayMode.PlayMode
import pokebowl.core.Application
import pokebowl.game.GameState
import pokebowl.model.{PlayCalculator, DenverBroncos, Team, CarolinaPanthers}

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
  var box: Rectangle = _
  var testSprite: Texture = _
  var pokemonFont: FreeTypeFontGenerator = _
  var smallFontSize: FreeTypeFontParameter = _
  var cursorPosition = 2
  var playSelect: Option[Int] = _
  var textToDraw: Seq[String] = Seq()
  var drawText: Boolean = false
  var gameState: GameState = _

  var playerTeam: Team = _
  var npcTeam: Team = _

  override def resize(width: Int, height: Int): Unit = {

  }

  override def hide(): Unit = {

  }

  override def dispose(): Unit = {
    pokemonFont.dispose()
    shapeRenderer.dispose()
    batch.dispose()
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

    drawScoreBoard()

    if(drawText)
      controlTextBox(delta)
    else
      gameState.playMode match {
        case PlayMode.KickOff => kickOffEvent()
        case PlayMode.ExtraPoint => extraPointEvent()
        case PlayMode.SelectPlay => controlMenu(delta)
      }
  }

  private def kickOffEvent() = {
    textToDraw = textToDraw ++ PlayCalculator.kickOffResults(gameState)
    drawText = true
  }

  private def extraPointEvent() = {
    textToDraw = textToDraw ++ PlayCalculator.extraPointResults(gameState)
    drawText = true
  }

  private def npcMove(playIndex: Int): Seq[String] = {
    Seq(s"${npcTeam.name} do a ${npcTeam.plays(playIndex).getDisplayText()}")
  }

  private def playerMove(index: Int): Seq[String] = {
    Seq(s"${playerTeam.name} do a ${playerTeam.plays(index).getDisplayText()}")
  }

  private def triggerTextBox(cursor: Int) = {
    // player's choice
    val playerChoice = cursor - 1
    // npc's choice
    val npcChoice = new Random().nextInt(4)

    var offenceChoice = playerChoice
    var defenceChoice = npcChoice
    if(playerTeam != gameState.possession) {
      offenceChoice = npcChoice
      defenceChoice = playerChoice
      textToDraw = textToDraw ++ npcMove(npcChoice)
      textToDraw = textToDraw ++ playerMove(playerChoice)
    } else {
      offenceChoice = playerChoice
      defenceChoice = npcChoice
      textToDraw = textToDraw ++ playerMove(playerChoice)
      textToDraw = textToDraw ++ npcMove(npcChoice)
    }

    // Calculate results of play and advance the game state.
    textToDraw = textToDraw ++ PlayCalculator.playEndResults(offenceChoice, defenceChoice, gameState)
    drawText = true
  }

  private def controlMenu(delta: Float): Unit = {
    // tell the SpriteBatch to render in the
    // coordinate system specified by the camera.
    //    batch.setProjectionMatrix(camera.combined)
    //    batch.begin()
    //    batch.draw(testSprite, box.x, box.y)
    //    batch.end()
    drawMenu()

    // process user input
    //    if(Gdx.input.isTouched()) {
    //      val touchPos: Vector3 = new Vector3()
    //      touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0)
    //      camera.unproject(touchPos)
    //      box.x = touchPos.x - 64 / 2
    //    }

    // Check for user input and move the box as specified.
    //if(Gdx.input.isKeyPressed(Keys.LEFT)) box.x -= 200 * Gdx.graphics.getDeltaTime
    //if(Gdx.input.isKeyPressed(Keys.RIGHT)) box.x += 200 * Gdx.graphics.getDeltaTime
    //if(Gdx.input.isKeyPressed(Keys.DOWN)) box.y -= 200 * Gdx.graphics.getDeltaTime
    //if(Gdx.input.isKeyPressed(Keys.UP)) box.y += 200 * Gdx.graphics.getDeltaTime

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

    // Make sure the sprite stays within the screen bounds
    //if(box.x < 0) box.x = 0
    //if(box.x > width - 64) box.x = width - 64
    //if(box.y < 0) box.y = 0
    //if(box.y > height - 64) box.y = height - 64
  }

  private def controlTextBox(delta: Float) = {
    drawTextBox()

    if (Gdx.input.isKeyJustPressed(Keys.Z)) {
      textToDraw = textToDraw.tail
      drawText = textToDraw.nonEmpty
    }
  }

  private def drawMenu(): Unit = {
    val buffer = 40
    val menuBoxWidth = 160
    val menuBoxHeight = 90

    // draw menu box
    shapeRenderer.setProjectionMatrix(camera.combined)
    shapeRenderer.begin(ShapeType.Line)
    shapeRenderer.setColor(0, 0, 0, 0)
    // bottom left
    shapeRenderer.rect(buffer, buffer, menuBoxWidth, menuBoxHeight)
    // top left
    shapeRenderer.rect(buffer, buffer + menuBoxHeight, menuBoxWidth, menuBoxHeight)
    // top right
    shapeRenderer.rect(buffer + menuBoxWidth, buffer + menuBoxHeight, menuBoxWidth, menuBoxHeight)
    // bottom right
    shapeRenderer.rect(buffer + menuBoxWidth, buffer, menuBoxWidth, menuBoxHeight)
    shapeRenderer.end()

    // draw menu text
    val menuFont = pokemonFont.generateFont(smallFontSize)
    val menuPadding = 40
    val playMenuPosition1 = (buffer + menuPadding, buffer + menuBoxHeight/2)
    val playMenuPosition2 = (buffer + menuPadding, buffer + menuBoxHeight + menuBoxHeight/2)
    val playMenuPosition3 = (buffer + menuPadding + menuBoxWidth, buffer + menuBoxHeight + menuBoxHeight/2)
    val playMenuPosition4 = (buffer + menuPadding + menuBoxWidth, buffer + menuBoxHeight/2)
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    menuFont.draw(batch, playerTeam.plays(0).getDisplayText(), playMenuPosition1._1, playMenuPosition1._2)
    menuFont.draw(batch, playerTeam.plays(1).getDisplayText(), playMenuPosition2._1, playMenuPosition2._2)
    menuFont.draw(batch, playerTeam.plays(2).getDisplayText(), playMenuPosition3._1, playMenuPosition3._2)
    menuFont.draw(batch, playerTeam.plays(3).getDisplayText(), playMenuPosition4._1, playMenuPosition4._2)
    batch.end()

    // draw cursor
    val cursorWidthPadding = 5
    val cursorHeightPadding = smallFontSize.size / 2
    val cursorWidth = 8
    val cursorHalfHeight = 6
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
    val startXY = (100, height / 2)
    val textBoxWidth = 700
    val textBoxHeight = 100
    shapeRenderer.setProjectionMatrix(camera.combined)
    shapeRenderer.begin(ShapeType.Line)
    shapeRenderer.setColor(0, 0, 0, 0)
    shapeRenderer.rect(startXY._1, startXY._2, textBoxWidth, textBoxHeight)
    shapeRenderer.end()

    val menuFont = pokemonFont.generateFont(smallFontSize)
    val textBuffer = 10
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    menuFont.draw(batch, textToDraw.head, startXY._1 + textBuffer, startXY._2 + textBoxHeight / 2)
    batch.end()
  }

  private def drawScoreBoard(): Unit = {
    val startXY = (100, height - 10)

    val menuFont = pokemonFont.generateFont(smallFontSize)
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    menuFont.draw(batch, s"${gameState.awayScore} vs ${gameState.homeScore} Q${gameState.currentQuarter} D${gameState.down}", startXY._1, startXY._2)
    menuFont.draw(batch, s"${gameState.lineOfScrimmage} yard line", startXY._1, startXY._2 - smallFontSize.size)
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

    testSprite = new Texture(Gdx.files.internal("sprites/bucket.png"));

    // create a Rectangle to logically represent the bucket
    box = new Rectangle()
    box.x = width / 2 - 64 / 2 // center the bucket horizontally
    box.y = 20; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
    box.width = 64
    box.height = 64

    // init fonts
    pokemonFont = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Pokemon GB.ttf"))
    smallFontSize = new FreeTypeFontParameter()
    smallFontSize.size = 12
    smallFontSize.color = Color.BLACK

    // init selector
    playSelect = None

    // init player
    playerTeam = CarolinaPanthers.team
    npcTeam = DenverBroncos.team

    gameState = new GameState(playerTeam, npcTeam)
    gameState.playMode = PlayMode.KickOff
  }

  override def resume(): Unit = {

  }
}
