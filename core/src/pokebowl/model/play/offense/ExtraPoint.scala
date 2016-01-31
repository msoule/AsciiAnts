package pokebowl.model.play.offense

import pokebowl.game.GameState
import pokebowl.model.play.PlayResult.PlayResult
import pokebowl.model.play.defense.DefensivePlay
import pokebowl.model.play.{Play, PlayResult}
import pokebowl.model.team.{StatGlossary, Team}

/**
  * @author Mark Soule on 1/29/16.
  */
class ExtraPoint extends OffensivePlay {
  override def calculateOdds(offense: Team, defense: Team, defensePlay: DefensivePlay): Array[PlayResult] = {
    val resultArray = new Array[PlayResult](100)
    val marker = 100 - offense.kicker.stats(StatGlossary.EpPct).asInstanceOf[Int]
    resultArray(0) = PlayResult.Terrible
    resultArray(marker + 1) = PlayResult.Great

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

  override def getDisplayText(): String = "will attempt Extra Point"

  override def getName(): String = "EXTRA POINT"

  override def calculateResult(state: GameState, result: PlayResult): Seq[String] = {
    var messages = Seq[String]()
    result match {
      case PlayResult.Terrible =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} attempting extra point..."
        messages = messages :+ s"${state.possession.kicker.last} kicked the ball"
        messages = messages :+ s"It was blocked!"
        state.scoreFieldGoal(false)
        messages = messages :+ s"${state.possession.location} ${state.possession.name} will start their possession"
      case _ =>
        messages = messages :+ s"${state.possession.location} ${state.possession.name} attempting extra point..."
        messages = messages :+ s"${state.possession.kicker.last} kicked the ball"
        messages = messages :+ s"It was good!"
        state.scoreExtraPoint()
    }
    messages
  }
}
