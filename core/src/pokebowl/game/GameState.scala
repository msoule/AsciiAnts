package pokebowl.game

import pokebowl.model.Team

/**
  * Tracks the state of the football game.
  *
  * @author Mark Soule on 1/27/16.
  */
class GameState(homeTeam: Team, awayTeam: Team) {
  var lineOfScrimmage: Int = -50
  var firstDownMarker: Int = -40
  var down: Int = 1

//  def changeLineOfScrimmage(change: Int): Boolean = {
//    lineOfScrimmage += change
//    if(lineOfScrimmage >= firstDownMarker) {
//
//    }
//    else {
//      false
//    }
//  }

}
