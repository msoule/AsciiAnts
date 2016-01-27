package pokebowl.game

/**
  * Controller for the logic and state of the football game.
  *
  * @author Mark Soule on 1/27/16.
  */
class GameStateController {

  /**
    * Starts the football game.
    */
  def startGame() = {
    newKickOff()
  }

  /**
    * Starts and controls a new play in the game.
    */
  def newPlay() = {
    //setScreen(PlayChooseScreen)
  }

  /**
    * Starts a kickOff play.
    */
  def newKickOff() = {

    // perform kickoff play

    // Start the next play.
    newPlay()
  }

  /**
    * Starts a touchDown event.
    */
  def newTouchDown() = {

  }

  /**
    * Starts a new quarter of the game.
    */
  def newQuarter() = {
    // show quarter end
    // if 2nd quarter is over call newKickOff()
    // if 4th quarter is over call endGame()
  }

  /**
    * Ends the football game.
    */
  def endGame() = {
    // show final score
  }

}
