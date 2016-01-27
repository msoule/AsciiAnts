package pokebowl.desktop.main

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}
import pokebowl.core.Application

object Main extends App {
  val config = new LwjglApplicationConfiguration

  config.title = "Pokebowl"
  config.width = 800
  config.height = 600

  new LwjglApplication(new Application, config)
}