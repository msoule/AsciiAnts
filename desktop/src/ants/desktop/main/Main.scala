package ants.desktop.main

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}
import ants.core.Application

object Main extends App {
  val config = new LwjglApplicationConfiguration

  config.title = "Ascii Ants"
  config.width = 638
  config.height = 580

  new LwjglApplication(new Application, config)
}