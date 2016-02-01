package pokebowl.model.play.offense

import pokebowl.game.GameState
import pokebowl.model.play.Play
import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.play.defense.DefensivePlay
import pokebowl.model.team.Team

/**
  * @author Mark Soule on 1/26/16.
  */
trait OffensivePlay extends Play {
  def calculateOdds(offense: Team, defense: Team, defensePlay: DefensivePlay): Array[PlayResult]
  def calculateResult(state: GameState, result: PlayResult): Seq[String]
}


