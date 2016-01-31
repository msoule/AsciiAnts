package pokebowl.game

import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.play._
import pokebowl.model.play.defense._
import pokebowl.model.play.offense._
import pokebowl.model.team.Team

import scala.util.Random

/**
  * Created by msoule on 1/30/16.
  */
object PlayCalculator {
  def calculatePlayResults(odds: Array[PlayResult]): PlayResult = {
    odds(new Random().nextInt(100))
  }

  def calculateResultEffects(offense: Team, defense: Team, result: PlayResult, state: GameState): Seq[String] = {
    state.changeLineOfScrimmage(1)
  }

  private def calculatePlayEnd(offensePlay: OffensivePlay, defensePlay: DefensivePlay, state: GameState): Seq[String] = {
    val offenseOdds = offensePlay.calculateOdds(state.possession, state.getNonPossessingTeam, defensePlay)
    calculateResultEffects(state.getHomeTeam, state.getAwayTeam, PlayResult.Average, state)
  }

  def kickOffResults(state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val kickOff = new KickOff()
    val kickingTeamOdds = kickOff.calculateOdds(state.possession, state.getNonPossessingTeam, new ReceiveKickOff)
    messages = messages ++ kickOff.calculateResult(state, calculatePlayResults(kickingTeamOdds))
    messages = messages ++ state.advanceGameClock()
    messages
  }

  def puntResults(punt: OffensivePlay, receive: DefensivePlay, state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val puntingTeamOdds = punt.calculateOdds(state.possession, state.getNonPossessingTeam, receive)
    messages = messages ++ punt.calculateResult(state, calculatePlayResults(puntingTeamOdds))
    messages
  }

  def fieldGoalResults(fieldGoal: OffensivePlay, defense: DefensivePlay, state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val kickingTeamOdds = fieldGoal.calculateOdds(state.possession, state.getNonPossessingTeam, defense)
    messages = messages ++ fieldGoal.calculateResult(state, calculatePlayResults(kickingTeamOdds))
    messages
  }

  def extraPointResults(state: GameState): Seq[String] = {
    var messages = Seq[String]()
    val extraPoint = new ExtraPoint()
    val kickingTeamOdds = extraPoint.calculateOdds(state.possession, state.getNonPossessingTeam, new DefendExtraPoint())
    messages = messages ++ extraPoint.calculateResult(state, calculatePlayResults(kickingTeamOdds))
    messages
  }

  private def displayMove(teamName: String, play: Play): String = {
    s"$teamName ${play.getDisplayText}"
  }

  def playEndResults(offenseChoice: Int, defenseChoice: Int, state: GameState): Seq[String] = {
    var messages = Seq[String]()
    // do calculations and stuff
    val offensePlay = state.possession.plays(offenseChoice)
    offensePlay match {
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
        messages = messages ++ Seq(displayMove(state.possession.name, offensePlay), displayMove(state.getNonPossessingTeam.name, defensePlay))
        messages = messages ++ calculatePlayEnd(offensePlay.asInstanceOf[OffensivePlay], defensePlay.asInstanceOf[DefensivePlay], state)
    }

    // track game clock
    messages = messages ++ state.advanceGameClock()
    messages
  }
}
