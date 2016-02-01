package pokebowl.controller

/**
  * @author Mark Soule on 1/28/16.
  */
object PlayMode extends Enumeration {
  type PlayMode = Value
  val SelectPlay, ExtraPoint, KickOff, Punt, EndGame = Value
}
