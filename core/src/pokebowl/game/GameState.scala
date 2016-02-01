package pokebowl.game

import pokebowl.controller.PlayMode
import pokebowl.controller.PlayMode._
import pokebowl.model.play._
import pokebowl.model.play.defense.ZoneCoverage
import pokebowl.model.play.offense.{ScreenPass, Punt, FieldGoal}
import pokebowl.model.team.Team

import scala.util.Random

/**
  * Tracks the state of the football game.
  *
  * @author Mark Soule on 1/27/16.
  */
class GameState(homeTeam: Team, awayTeam: Team) {
  var homeScore = 0
  var awayScore = 0
  var lineOfScrimmage: Int = 0
  var firstDownMarker: Int = 10
  var down: Int = 1
  var possession = homeTeam
  var playMode: PlayMode = PlayMode.SelectPlay
  var playCount = 0
  var currentQuarter = 1

  // constants
  val MAX_YARDS = 100
  val FIRST_DOWN_YARDS = 10
  private val PLAYS_PER_QUARTER = 10
  private val TOUCHDOWN_SCORE = 6
  private val EXTRA_POINT_SCORE = 1
  private val FIELD_GOAL_SCORE = 3


  def changeLineOfScrimmage(newLine: Int): Seq[String] = {
    var messages: Seq[String] = Seq()
    lineOfScrimmage = newLine
    if(lineOfScrimmage >= MAX_YARDS) {
      addScore(possession, TOUCHDOWN_SCORE)
      playMode = PlayMode.ExtraPoint
      down = 1
      messages = messages :+ "... TOUCHDOWN!"
    }
    else if(lineOfScrimmage >= firstDownMarker) {
      down = 1
      firstDownMarker = lineOfScrimmage + FIRST_DOWN_YARDS
      messages = messages :+ "First down!"
    }
    else {
      messages = messages ++ advanceDowns()
    }
    messages
  }

  def scoreExtraPoint(success: Boolean = true) = {
    if(success) addScore(possession, EXTRA_POINT_SCORE)
    playMode = PlayMode.KickOff
  }

  def scoreFieldGoal(success: Boolean = true) = {
    if(success) {
      addScore(possession, FIELD_GOAL_SCORE)
      playMode = PlayMode.KickOff
    }
    else {
      changePossession()
      firstDownMarker = lineOfScrimmage + 10
    }
  }

  def kickOff(fieldPosition: Int) = {
    changePossession()
    lineOfScrimmage = fieldPosition
    firstDownMarker = lineOfScrimmage + FIRST_DOWN_YARDS
    down = 1
    playMode = PlayMode.SelectPlay
    Seq(s"${possession.name} to start possession at $getFieldPositionText")
  }

  def punt(fieldPosition: Int) = {
    changePossession()
    lineOfScrimmage = fieldPosition
    firstDownMarker = lineOfScrimmage + FIRST_DOWN_YARDS
    down = 1
    playMode = PlayMode.SelectPlay
    Seq(s"${possession.name} to start possession at $getFieldPositionText")
  }

  def addScore(scoringTeam: Team, amount: Int) = {
    if(scoringTeam == homeTeam) homeScore += amount else awayScore += amount
  }

  def changePossession(): Unit = {
    if(possession == awayTeam) {
      possession = homeTeam
      homeTeam.plays = getOffensivePlays
      awayTeam.plays = getDefensivePlays
    } else {
      possession = awayTeam
      awayTeam.plays = getOffensivePlays
      homeTeam.plays = getDefensivePlays
    }
    down = 1
  }

  private def getOffensivePlays: Array[Play] = {
    Array(new ScreenPass, new ScreenPass, new ScreenPass, new ScreenPass)//Array(new ScreenPass, new ScreenPass, new Punt, new FieldGoal)
  }

  private def getDefensivePlays: Array[Play] = {
    Array(new ZoneCoverage, new ZoneCoverage, new ZoneCoverage, new ZoneCoverage)
  }

  def advanceDowns(): Seq[String] = {
    down += 1
    if(down > 4) {
      changePossession()
      Seq("Turnover!", s"${possession.name} will get the ball at $getFieldPositionText")
    }
    else {
      Seq()
    }
  }

  def advanceGameClock(): Seq[String] = {
    playCount += 1
    var messages: Seq[String] = Seq()
    if(playCount >= PLAYS_PER_QUARTER) {
      messages = messages :+ s"Quarter $currentQuarter is over"
      currentQuarter += 1
      currentQuarter match {
        case 3 => messages = messages ++ Seq(s"Halftime!", s"Quarter $currentQuarter begins")
        case 5 => messages = messages :+ s"Game over!"
        case _ => messages = messages :+ s"Quarter $currentQuarter begins!"
      }
      playCount = 0
    }
    messages
  }

  def getFieldPositionText: String = {
    lineOfScrimmage.toString
    //val intermediate = lineOfScrimmage - (MAX_YARDS / 2)
    //var our = true
    //if(intermediate > 0)
    //  our = false
    //val yardLine = (MAX_YARDS / 2) - Math.abs(intermediate)
    //val yardString = s"$yardLine yard line"
    //if(yardLine == (MAX_YARDS / 2))
    //  s"the $yardString"
    //else if(our)
    //  s"the $yardString"
    //else
    //  s"their own $yardString"
  }

  def getNonPossessingTeam = {
    if(possession == awayTeam) homeTeam else awayTeam
  }

  def getHomeTeam = {
    homeTeam
  }

  def getAwayTeam = {
    awayTeam
  }
}

object GameState {
  val rand = new Random()
}
