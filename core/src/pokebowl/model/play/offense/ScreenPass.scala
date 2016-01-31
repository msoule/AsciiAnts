package pokebowl.model.play.offense

import pokebowl.game.GameState
import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.play.defense.DefensivePlay
import pokebowl.model.play.{Play, PlayResult}
import pokebowl.model.team.Team

/**
  * @author Mark Soule on 1/28/16.
  */
class ScreenPass extends OffensivePlay {
  override def calculateOdds(offense: Team, defense: Team, defensePlay: DefensivePlay): Array[PlayResult] = {
    Array.fill(100)(PlayResult.Average)
  }

  override def getDisplayText: String = "do a Screen Pass"

  override def getName: String = "SCREEN PASS"

  override def calculateResult(state: GameState, result: PlayResult): Seq[String] = ???

}
