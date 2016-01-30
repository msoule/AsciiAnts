package pokebowl.game

import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.play._
import pokebowl.model.team.Team

/**
  * Created by msoule on 1/30/16.
  */
object PlayCalculator {
  def calculatePlayResults(offense: Array[PlayResult], defense: Array[PlayResult]): PlayResult = {
    PlayResult.Average
  }

  def calculateResultEffects(offense: Team, defense: Team, result: PlayResult, state: GameState): Seq[String] = {
    state.changeLineOfScrimmage(1)
  }

  private def calculatePlayEnd(offensePlay: Play, defencePlay: Play, state: GameState): Seq[String] = {
    val offenceOdds = offensePlay.calculateOdds(state.getHomeTeam)
    val defenceOdds = defencePlay.calculateOdds(state.getAwayTeam)
    val result = calculatePlayResults(offenceOdds, defenceOdds)
    calculateResultEffects(state.getHomeTeam, state.getAwayTeam, result, state)
  }

  def kickOffResults(state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val kickingTeamOdds = new KickOff().calculateOdds(state.possession)
    val receivingTeamOdds = new ReceiveKickOff().calculateOdds(state.getNonPossessingTeam)
    val result = calculatePlayResults(kickingTeamOdds, receivingTeamOdds)
    // todo calculate kickOff effects
    messages = messages :+ "It was a touchback"
    messages = messages ++ state.kickOff(20)
    messages = messages ++ state.advanceGameClock()
    messages
  }

  def puntResults(punt: Play, receive: Play, state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val kickingTeamOdds = punt.calculateOdds(state.possession)
    val receivingTeamOdds = receive.calculateOdds(state.getNonPossessingTeam)
    val result = calculatePlayResults(kickingTeamOdds, receivingTeamOdds)
    // todo calculate punt effects
    messages = messages :+ "Fair catch"
    messages = messages ++ state.punt(20)
    messages
  }

  def fieldGoalResults(fieldGoal: Play, defense: Play, state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val kickingTeamOdds = fieldGoal.calculateOdds(state.possession)
    val defendingTeamOdds = defense.calculateOdds(state.getNonPossessingTeam)
    val result = calculatePlayResults(kickingTeamOdds, defendingTeamOdds)
    // todo calculate fieldGoal effects
    messages = messages :+ "... It's good!"
    state.scoreFieldGoal()
    messages
  }

  def extraPointResults(state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val kickingTeamOdds = new ExtraPoint().calculateOdds(state.possession)
    val defendingTeamOdds = new DefendExtraPoint().calculateOdds(state.getNonPossessingTeam)
    val result = calculatePlayResults(kickingTeamOdds, defendingTeamOdds)
    // todo calculate extraPoint effects
    messages = messages :+ "... It's good!"
    state.scoreExtraPoint()
    messages
  }

  private def displayMove(teamName: String, play: Play): String = {
    s"$teamName ${play.getDisplayText()}"
  }

  def playEndResults(offenceChoice: Int, defenseChoice: Int, state: GameState): Seq[String] = {
    var messages = Seq[String]()
    // do calculations and stuff
    val offencePlay = state.possession.plays(offenceChoice)
    offencePlay match {
      case offP: FieldGoal =>
        val kick = new FieldGoal
        val defend = new DefendFieldGoal
        messages = messages ++ Seq(displayMove(state.possession.name, kick), displayMove(state.getNonPossessingTeam.name, defend))
        fieldGoalResults(kick, defend, state)
      case offP: Punt =>
        val punt = new Punt
        val receive = new ReceivePunt
        messages = messages ++ Seq(displayMove(state.possession.name, punt), displayMove(state.getNonPossessingTeam.name, receive))
        puntResults(punt, receive, state)
      case _ =>
        val defensePlay = state.getNonPossessingTeam.plays(defenseChoice)
        messages = messages ++ Seq(displayMove(state.possession.name, offencePlay), displayMove(state.getNonPossessingTeam.name, defensePlay))
        messages = messages ++ calculatePlayEnd(offencePlay, defensePlay, state)
    }

    // track game clock
    messages = messages ++ state.advanceGameClock()
    messages
  }
}
