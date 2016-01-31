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
class Punt extends OffensivePlay {
  override def calculateOdds(offense: Team, defense: Team, defensePlay: DefensivePlay): Array[PlayResult] = {
    val resultArray = new Array[PlayResult](100)
    val blockedPunts = offense.punter.stats(StatGlossary.Bp).asInstanceOf[Int]
    for(i <- 0 to blockedPunts) {
      resultArray(i) = PlayResult.Terrible
    }
    resultArray(blockedPunts) = PlayResult.VeryBad
    resultArray(blockedPunts + 1) = PlayResult.Bad
    resultArray(blockedPunts + 5) = PlayResult.Average
    resultArray(95) = PlayResult.Good
    resultArray(99) = PlayResult.Great



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

  override def getDisplayText: String = "to Punt the ball"

  override def getName: String = "PUNT"

  override def calculateResult(state: GameState, result: PlayResult): Seq[String] = {
    var messages = Seq[String]()
    result match {
      case PlayResult.Terrible =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} will punt..."
        messages = messages :+ s"${state.possession.punter.last} punted the ball"
        messages = messages :+ s"It was blocked!"
        messages = messages ++ state.punt(state.lineOfScrimmage - new Random().nextInt(10))
      case PlayResult.VeryBad | PlayResult.Bad =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} will punt..."
        messages = messages :+ s"${state.possession.punter.last} punted the ball"
        messages = messages :+ s"${state.getNonPossessingTeam.name} returning the ball"
        messages = messages :+ s"It was a great return"
        messages = messages ++ state.punt(new Random().nextInt(20) + 20)
      case PlayResult.Average =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} will punt..."
        messages = messages :+ s"${state.possession.punter.last} kicked the ball"
        messages = messages :+ s"${state.getNonPossessingTeam.name} returning the ball"
        messages = messages ++ state.punt(state.lineOfScrimmage + state.possession.punter.stats(StatGlossary.Net).asInstanceOf[Int] - new Random().nextInt(10))
      case PlayResult.Good =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} will punt..."
        messages = messages :+ s"${state.possession.punter.last} punted the ball"
        messages = messages :+ s"It was a touchback"
        messages = messages ++ state.punt(20)
      case _ =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} will punt..."
        messages = messages :+ s"${state.possession.punter.last} punted the ball"
        messages = messages :+ s"Great punt!"
        messages = messages :+ s"${state.getNonPossessingTeam.name} returning the ball"
        messages = messages ++ state.punt(new Random().nextInt(15) + 5)
    }
    messages
  }

}
