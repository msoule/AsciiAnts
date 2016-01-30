package pokebowl.model.play

import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.team.Team

/**
  * @author Mark Soule on 1/29/16.
  */
class Punt extends Play {
  override def calculateOdds(team: Team): Array[PlayResult] = {
    Array.fill(100)(PlayResult.Average)
  }

  override def getDisplayText(): String = "to Punt the ball"

  override def getName(): String = "PUNT"
}
