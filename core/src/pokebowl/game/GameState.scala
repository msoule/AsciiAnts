package pokebowl.game

import pokebowl.controller.PlayMode
import pokebowl.controller.PlayMode._
import pokebowl.model.Team

/**
  * Tracks the state of the football game.
  *
  * @author Mark Soule on 1/27/16.
  */
class GameState(homeTeam: Team, awayTeam: Team) {
  var lineOfScrimmage: Int = 0
  var firstDownMarker: Int = 10
  var down: Int = 1
  var possession = awayTeam
  var playMode: PlayMode = PlayMode.SelectPlay
  var playCount = 0
  var currentQuarter = 1

  // constants
  private val MAX_YARDS = 100
  private val FIRST_DOWN_YARDS = 10
  private val PLAYS_PER_QUARTER = 3


  def changeLineOfScrimmage(change: Int): Seq[String] = {
    var messages: Seq[String] = Seq()
    lineOfScrimmage += change
    if(lineOfScrimmage >= MAX_YARDS) {
      messages = messages :+ "...TOUCHDOWN!"
    }
    else if(lineOfScrimmage >= firstDownMarker) {
      down = 1
      firstDownMarker = lineOfScrimmage + FIRST_DOWN_YARDS
      messages = messages :+ "First down!"
    }
    messages
  }

  def changePossession(kickoff: Boolean): Unit = {
    if(possession == awayTeam) possession = homeTeam else possession = awayTeam
  }

  def advanceGameClock(): Seq[String] = {
    playCount += 1
    var messages = Seq(s"Play #$playCount")
    if(playCount >= PLAYS_PER_QUARTER) {
      messages = messages ++ Seq(s"Quarter $currentQuarter is over")
      currentQuarter += 1
      currentQuarter match {
        case 3 => messages = messages ++ Seq(s"Halftime!", s"Quarter $currentQuarter begins!")
        case 5 => messages = messages ++ Seq(s"Game over!")
        case _ => messages = messages ++ Seq(s"Quarter $currentQuarter begins!")
      }
      playCount = 0
    }
    messages
  }

  def getHomeTeam = {
    homeTeam
  }

  def getAwayTeam = {
    awayTeam
  }
}
