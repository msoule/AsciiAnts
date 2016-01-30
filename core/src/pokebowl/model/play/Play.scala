package pokebowl.model.play

import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.team.Team

/**
  * @author Mark Soule on 1/26/16.
  */
trait Play {
  def calculateOdds(team: Team): Array[PlayResult]
  def getDisplayText(): String
  def getName(): String
}


