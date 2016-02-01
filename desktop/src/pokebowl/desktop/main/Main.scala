package pokebowl.desktop.main

import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}
import pokebowl.core.Application

object Main extends App {
  val config = new LwjglApplicationConfiguration

  config.title = "Pokebowl"
  config.width = 638
  config.height = 580

  new LwjglApplication(new Application, config)
}