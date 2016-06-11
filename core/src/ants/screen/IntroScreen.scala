package ants.screen

import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.{Gdx, InputAdapter, Screen}

/**
  * @author Mark Soule on 6/10/16.
  */
class IntroScreen(width: Int, height: Int) extends InputAdapter with Screen {

  var camera: OrthographicCamera = _

  override def resize(width: Int, height: Int): Unit = {

  }

  override def hide(): Unit = {

  }

  override def dispose(): Unit = {

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
  }


  /**
    * Initializes the screen at creation.
    */
  override def show(): Unit = {
    // create the camera and the SpriteBatch
    camera = new OrthographicCamera()
    camera.setToOrtho(false, width, height)
  }

  override def resume(): Unit = {

  }
}
