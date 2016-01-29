package pokebowl.model

import pokebowl.model.PlayResult.PlayResult

/**
  * @author Mark Soule on 1/26/16.
  */
trait Play {
  def calculateOdds(team: Team): Array[PlayResult]
  def getDisplayText(): String
}

object PlayCalculator {
  def calculatePlayResults(offense: Array[PlayResult], defense: Array[PlayResult]): PlayResult = {
    PlayResult.Average
  }

  def calculateResultEffects(offense: Team, defense: Team, result: PlayResult): Seq[String] = {
    Seq("The play happened")
  }
}
