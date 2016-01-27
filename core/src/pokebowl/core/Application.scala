package pokebowl.core

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.{Texture, OrthographicCamera, GL20}
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.{Gdx, Game}

class Application extends Game {

  var batch: SpriteBatch = _
  var camera: OrthographicCamera = _
  var box: Rectangle = _
  var testSprite: Texture = _

  /**
    * Called when Application is first created.
    */
  override def create(): Unit = {
    Gdx.input.setCursorCatched(false)

    //setScreen(PlayScreen)

    // create the camera and the SpriteBatch
    camera = new OrthographicCamera()
    camera.setToOrtho(false, 800, 480)
    batch = new SpriteBatch()

    testSprite = new Texture(Gdx.files.internal("sprites/bucket.png"));

    // create a Rectangle to logically represent the bucket
    box = new Rectangle()
    box.x = 800 / 2 - 64 / 2 // center the bucket horizontally
    box.y = 20; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
    box.width = 64
    box.height = 64
  }

  /**
    * Called on each frame to render graphics.
    */
  override def render(): Unit = {
    // clear the screen with a dark blue color. The
    // arguments to glClearColor are the red, green
    // blue and alpha component in the range [0,1]
    // of the color to be used to clear the screen.
    Gdx.gl.glClearColor(1f, 1f, 1f, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    // tell the camera to update its matrices.
    camera.update()

    // tell the SpriteBatch to render in the
    // coordinate system specified by the camera.
    batch.setProjectionMatrix(camera.combined)

    batch.begin()
    batch.draw(testSprite, box.x, box.y)
    batch.end()
  }
}
