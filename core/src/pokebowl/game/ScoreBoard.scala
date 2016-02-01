package pokebowl.game

/**
  * @author Mark Soule on 1/31/16.
  */
class ScoreBoard {
  var homeScore = 0
  var awayScore = 0
  var down = 10
  var yardsToFirst = 10
  var lineOfScrimmage = 50
  var quarter = 1
  var clock = 0

  def update(home: Int, away: Int, downs: Int, yToFirst: Int, lineOfS: Int, quart: Int, plays: Int): Unit = {
    homeScore = home
    awayScore = away
    down = downs
    yardsToFirst = yToFirst
    lineOfScrimmage = lineOfS
    quarter = quart
    clock = plays
  }

}
