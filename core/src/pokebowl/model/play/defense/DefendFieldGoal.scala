package pokebowl.model.play.defense

/**
  * @author Mark Soule on 1/29/16.
  */
class DefendFieldGoal extends DefensivePlay {
  override def getDisplayText: String = "try to block the Field Goal"

  override def getName: String = "BLOCK FIELD GOAL"
}
