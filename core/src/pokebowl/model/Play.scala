package pokebowl.model

import pokebowl.game.GameState
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

  def calculateResultEffects(offense: Team, defense: Team, result: PlayResult, state: GameState): Seq[String] = {
    Seq("The play happened")
  }

  private def calculatePlayResults(playerPlay: Int, npcPlay: Int, state: GameState): Seq[String] = {
    val playerOdds = state.getHomeTeam.plays(playerPlay).calculateOdds(state.getHomeTeam)
    val npcOdds = state.getAwayTeam.plays(npcPlay).calculateOdds(state.getAwayTeam)
    // todo flip based on who is on offence and who is on defense
    val result = PlayCalculator.calculatePlayResults(playerOdds, npcOdds)
    calculateResultEffects(state.getHomeTeam, state.getAwayTeam, result, state)
  }

  def playEndResults(playerPlay: Int, npcPlay: Int, state: GameState): Seq[String] = {
    var messages = Seq[String]()
    // do calculations and stuff
    messages = messages ++ calculatePlayResults(playerPlay, npcPlay, state)
    // track game clock
    messages = messages ++ state.advanceGameClock()
    messages
  }
}
