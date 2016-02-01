package pokebowl.model.play.offense

import pokebowl.game.GameState
import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.play.defense.DefensivePlay
import pokebowl.model.play.{Play, PlayResult}
import pokebowl.model.team.{StatGlossary, Team}

import scala.util.Random

/**
  * @author Mark Soule on 1/29/16.
  */
class KickOff extends OffensivePlay {
  override def calculateOdds(offense: Team, defense: Team, defensePlay: DefensivePlay): Array[PlayResult] = {
    val resultArray = new Array[PlayResult](100)
    resultArray(0) = PlayResult.Terrible
    resultArray(1) = PlayResult.VeryBad
    resultArray(2) = PlayResult.Bad
    resultArray(99) = PlayResult.Great

    // resultArraySlotsLeft * approximateAccuracy% - padding
    val touchBack = 97 * (offense.kicker.stats(StatGlossary.FgPct) / 100) - 3
    resultArray(touchBack.asInstanceOf[Int]) = PlayResult.Good
    val averageReturn = (97 - touchBack) / 2
    resultArray(averageReturn.asInstanceOf[Int]) = PlayResult.Average

    // Fill the empty slots of resultArray. It will fill empty slots with the value of
    // the previous slot. So only border slots need to be set above.
    def fillArray(index: Int): Array[PlayResult] = index match {
      case i if i >= 100 => resultArray
      // assumes the 0th position is filled
      case i if i == 0 => fillArray(i + 1)
      case i =>
        if (resultArray(i) == null)
          resultArray(i) = resultArray(i - 1)
        fillArray(i + 1)
    }

    fillArray(0)
  }

  override def getDisplayText: String = "Kickoff"

  override def getName: String = "KICKOFF"

  override def calculateResult(state: GameState, result: PlayResult): Seq[String] = {
    var messages = Seq[String]()
    result match {
      case PlayResult.Terrible | PlayResult.VeryBad | PlayResult.Bad =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} kicking off..."
        messages = messages :+ s"${state.possession.kicker.last} kicked the ball"
        messages = messages :+ s"${state.getNonPossessingTeam.name} returning the ball"
        messages = messages :+ s"It was a great return"
        messages = messages ++ state.kickOff(GameState.rand.nextInt(40) + 40)
      case PlayResult.Average =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} kicking off..."
        messages = messages :+ s"${state.possession.kicker.last} kicked the ball"
        messages = messages :+ s"${state.getNonPossessingTeam.name} returning the ball"
        messages = messages ++ state.kickOff(GameState.rand.nextInt(20) + 20)
      case PlayResult.Good =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} kicking off..."
        messages = messages :+ s"${state.possession.kicker.last} kicked the ball"
        messages = messages :+ s"It was a touchback"
        messages = messages ++ state.kickOff(20)
      case _ =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} kicking off..."
        messages = messages :+ s"${state.possession.kicker.last} kicked the ball"
        messages = messages :+ s"Great kick!"
        messages = messages :+ s"${state.getNonPossessingTeam.name} returning the ball"
        messages = messages ++ state.kickOff(GameState.rand.nextInt(15) + 5)
    }
    messages
  }

}
