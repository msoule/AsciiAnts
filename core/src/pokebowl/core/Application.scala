package pokebowl.core

import com.badlogic.gdx.{Gdx, Game}
import screen.PlayScreen

class Application extends Game {

  val width = 800
  val height = 480

  /**
    * Called when Application is first created.
    */
  override def create(): Unit = {
    Gdx.input.setCursorCatched(false)

    setScreen(new PlayScreen(width, height))
  }
}
