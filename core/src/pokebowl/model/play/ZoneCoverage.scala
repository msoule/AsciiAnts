package pokebowl.model.play

import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.team.Team

/**
  * Created by msoule on 1/28/16.
  */
class ZoneCoverage extends Play {
  override def calculateOdds(team: Team): Array[PlayResult] = {
    Array.fill(100)(PlayResult.Average)
  }

  override def getDisplayText(): String = "zone coverage"
}
