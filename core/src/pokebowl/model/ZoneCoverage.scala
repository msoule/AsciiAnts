package pokebowl.model

import pokebowl.model.PlayResult._

/**
  * Created by msoule on 1/28/16.
  */
class ZoneCoverage extends Play {
  override def calculateOdds(team: Team): Array[PlayResult] = {
    Array.fill(100)(PlayResult.Average)
  }

  override def getDisplayText(): String = "zone coverage"
}
