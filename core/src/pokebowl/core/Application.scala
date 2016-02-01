package pokebowl.core

import com.badlogic.gdx.{Screen, Gdx, Game}
import pokebowl.screen.{IntroScreen, PlayScreen}

class Application extends Game {

  val width = 638
  val height = 580
  val screens: Array[Screen] = Array(new IntroScreen(width, height, this),
                                     new PlayScreen(width, height, this))
  var playerPanthers = true

  /**
    * Called when Application is first created.
    */
  override def create(): Unit = {
    Gdx.input.setCursorCatched(false)

    setScreen(screens(0))
  }

  def startGamePlay(playPanthers: Boolean): Unit = {
    playerPanthers = playPanthers
    setScreen(screens(1))
  }

  override def dispose(): Unit = {
    screens.foreach(_.dispose())
    super.dispose()
  }
}
