package screen

import com.badlogic.gdx.graphics.{OrthographicCamera, Color}
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.{Screen, InputAdapter}

/**
  * Created by msoule on 1/26/16.
  */
class GameScreen(background: Color=Color.WHITE) extends InputAdapter with Screen {

  override def resize(width: Int, height: Int): Unit = ???

  override def hide(): Unit = ???

  override def dispose(): Unit = ???

  override def pause(): Unit = ???

  override def render(delta: Float): Unit = {

  }

  override def show(): Unit = ???

  override def resume(): Unit = ???
}
