package pokebowl.core

import com.badlogic.gdx.{Screen, Gdx, Game}
import pokebowl.screen.{IntroScreen, PlayScreen}

class Application extends Game {

  val width = 800
  val height = 480
  val screens: Array[Screen] = Array(new IntroScreen(width, height, this),
                                     new PlayScreen(width, height, this))
  var playerHome = true

  /**
    * Called when Application is first created.
    */
  override def create(): Unit = {
    Gdx.input.setCursorCatched(false)

    setScreen(screens(0))
  }

  def startGamePlay(playerIsHomeTeam: Boolean): Unit = {
    playerHome = playerIsHomeTeam
    setScreen(screens(1))
  }

  override def dispose(): Unit = {
    screens.foreach(_.dispose())
    super.dispose()
  }
}
