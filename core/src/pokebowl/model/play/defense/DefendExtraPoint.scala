package pokebowl.model.play.defense

/**
  * @author Mark Soule on 1/29/16.
  */
class DefendExtraPoint extends DefensivePlay {
  override def getDisplayText: String = "will try to block"

  override def getName: String = "BLOCK EXTRA POINT"
}
