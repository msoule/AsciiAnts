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
    state.changeLineOfScrimmage(1)
  }

  private def calculatePlayResults(offensePlay: Int, defencePlay: Int, state: GameState): Seq[String] = {
    val offenceOdds = state.possession.plays(offensePlay).calculateOdds(state.getHomeTeam)
    val defenceOdds = state.getNonPossessingTeam.plays(defencePlay).calculateOdds(state.getAwayTeam)
    val result = calculatePlayResults(offenceOdds, defenceOdds)
    calculateResultEffects(state.getHomeTeam, state.getAwayTeam, result, state)
  }

  def kickOffResults(state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val kickingTeamOdds = new KickOff().calculateOdds(state.possession)
    val receivingTeamOdds = new ReceiveKickOff().calculateOdds(state.getNonPossessingTeam)
    val result = PlayCalculator.calculatePlayResults(kickingTeamOdds, receivingTeamOdds)
    // todo calculate kickOff effects
    messages = messages :+ "It was a touchback"
    messages = messages ++ state.kickOff(20)
    messages
  }

  def extraPointResults(state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val kickingTeamOdds = new ExtraPoint().calculateOdds(state.possession)
    val defendingTeamOdds = new DefendExtraPoint().calculateOdds(state.getNonPossessingTeam)
    val result = PlayCalculator.calculatePlayResults(kickingTeamOdds, defendingTeamOdds)
    // todo calculate extraPoint effects
    messages = messages :+ "... It's good!"
    state.scoreExtraPoint()
    messages
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
