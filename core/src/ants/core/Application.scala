package ants.core

import com.badlogic.gdx.{Screen, Gdx, Game}
import ants.screen.IntroScreen

class Application extends Game {

  val width = 638
  val height = 580
  val screens: Array[Screen] = Array(new IntroScreen(width, height))

  /**
    * Called when Application is first created.
    */
  override def create(): Unit = {
    Gdx.input.setCursorCatched(false)

    setScreen(screens(0))
  }

  override def dispose(): Unit = {
    screens.foreach(_.dispose())
    super.dispose()
  }
}
