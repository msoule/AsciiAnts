package pokebowl.core

import com.badlogic.gdx.{Gdx, Game}

class Application extends Game {
  override def create(): Unit = {
    Gdx.input.setCursorCatched(false)
  }
}
