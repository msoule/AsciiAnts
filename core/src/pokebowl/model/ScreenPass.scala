package pokebowl.model

import pokebowl.model.PlayResult.PlayResult

/**
  * Created by msoule on 1/28/16.
  */
class ScreenPass extends Play {
  override def calculateOdds(team: Team): Array[PlayResult] = {
    Array.fill(100)(PlayResult.Average)
  }

  override def getDisplayText(): String = "screen pass"
}
