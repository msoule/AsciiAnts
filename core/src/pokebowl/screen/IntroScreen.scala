package pokebowl.screen

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.graphics.{Color, GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.{Gdx, InputAdapter, Screen}

import pokebowl.core.Application
import pokebowl.game.GameState

import scala.util.Random

/**
  * The main play screen of the game.
  *
  * @author Mark Soule on 1/26/16.
  */
class IntroScreen(width: Float, height: Float, game: Application, background: Color=Color.WHITE) extends InputAdapter with Screen {

  var batch: SpriteBatch = _
  var shapeRenderer: ShapeRenderer = _
  var camera: OrthographicCamera = _
  var pokemonFont: FreeTypeFontGenerator = _
  var smallFontSize: FreeTypeFontParameter = _
  var largeFontSize: FreeTypeFontParameter = _

  var textToDraw: Seq[String] = Seq()
  var choose: Boolean = false
  var cursorPosition = 1

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

    if(!choose)
      drawTitleScreen()
    else
      drawSelectTeam()
  }

  private def drawTitleScreen(): Unit = {
    val startXY = (width/2 - 100, height - 100)
    val tutXY = (100, 40)

    val titleFont = pokemonFont.generateFont(largeFontSize)
    val menuFont = pokemonFont.generateFont(smallFontSize)
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    titleFont.draw(batch, s"Pokebowl", startXY._1, startXY._2)
    menuFont.draw(batch, s"Superbowl version", startXY._1 - 10, startXY._2 - 50)
    menuFont.draw(batch, s"Arrow keys to select, 'Z' to confirm", tutXY._1, tutXY._2)
    batch.end()

    if (Gdx.input.isKeyJustPressed(Keys.Z)) choose = true

  }

  private def drawSelectTeam(): Unit = {
    val menuPosition1 = (50, height/2)
    val menuPosition2 = (width.asInstanceOf[Int] - 230, height/2)

    val menuFont = pokemonFont.generateFont(smallFontSize)
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    menuFont.draw(batch, s"Carolina Panthers", menuPosition1._1, menuPosition1._2)
    menuFont.draw(batch, s"Denver Broncos", menuPosition2._1, menuPosition2._2)
    batch.end()

    // draw cursor
    val cursorWidthPadding = 5
    val cursorHeightPadding = 6
    val cursorWidth = 12
    val cursorHalfHeight = 8
    val cursorDrawPosition = cursorPosition match {
      case 1 => menuPosition1
      case _ => menuPosition2
    }

    shapeRenderer.begin(ShapeType.Filled)
    shapeRenderer.setColor(0, 0, 0, 0)
    shapeRenderer.triangle(
      cursorDrawPosition._1 - cursorWidthPadding, cursorDrawPosition._2 - cursorHeightPadding,
      cursorDrawPosition._1 - cursorWidthPadding - cursorWidth, cursorDrawPosition._2 + cursorHalfHeight - cursorHeightPadding,
      cursorDrawPosition._1 - cursorWidthPadding - cursorWidth, cursorDrawPosition._2 - cursorHalfHeight - cursorHeightPadding
    )
    shapeRenderer.end()

    if (Gdx.input.isKeyPressed(Keys.RIGHT) && cursorPosition == 1) cursorPosition = 2
    if (Gdx.input.isKeyPressed(Keys.LEFT) && cursorPosition == 2) cursorPosition = 1

    if (Gdx.input.isKeyJustPressed(Keys.Z)) {
      if(cursorPosition == 1)
        game.startGamePlay(true)
      else
        game.startGamePlay(false)
    }
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

    // init fonts
    pokemonFont = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Pokemon GB.ttf"))
    largeFontSize = new FreeTypeFontParameter()
    largeFontSize.size = 24
    largeFontSize.color = Color.BLACK

    smallFontSize = new FreeTypeFontParameter()
    smallFontSize.size = 12
    smallFontSize.color = Color.BLACK
  }

  override def resume(): Unit = {

  }
}
