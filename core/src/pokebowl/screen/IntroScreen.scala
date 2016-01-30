package pokebowl.screen

import com.badlogic.gdx.Input.Keys
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.graphics.{Color, GL20, OrthographicCamera, Texture}
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.{Game, Gdx, InputAdapter, Screen}
import pokebowl.controller.PlayMode
import pokebowl.core.Application
import pokebowl.game.GameState
import pokebowl.model.{CarolinaPanthers, DenverBroncos, PlayCalculator, Team}

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

  var textToDraw: Seq[String] = Seq()
  var drawText: Boolean = false

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

    drawTitleScreen()

    val playerHome = new Random().nextBoolean()
    if (Gdx.input.isKeyJustPressed(Keys.Z)) game.startGamePlay(playerHome)
  }

  private def drawTitleScreen(): Unit = {
    val startXY = (width/2, height/2)

    val menuFont = pokemonFont.generateFont(smallFontSize)
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
    menuFont.draw(batch, s"Pokebowl", startXY._1, startXY._2)
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

    // init fonts
    pokemonFont = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Pokemon GB.ttf"))
    smallFontSize = new FreeTypeFontParameter()
    smallFontSize.size = 20
    smallFontSize.color = Color.BLACK
  }

  override def resume(): Unit = {

  }
}
