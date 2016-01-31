package pokebowl.model.team

import pokebowl.model.play.Play
import pokebowl.model.team.StatGlossary._

/**
  * @author Mark Soule on 1/26/16.
  */
case class Team(
                 var plays: Array[Play],
                 stats: Map[StatGlossary, Double],
                 name: String,
                 location: String,
                 quarterBack: Player,
                 runningBack: Seq[Player],
                 wideReceiver: Seq[Player],
                 tightEnd: Seq[Player],
                 center: Player,
                 offensiveGuard: Seq[Player],
                 offensiveTackle: Seq[Player],
                 defensiveTackle: Seq[Player],
                 defensiveEnd: Seq[Player],
                 middleLinebacker: Seq[Player],
                 outsideLinebacker: Seq[Player],
                 cornerBack: Seq[Player],
                 safety: Seq[Player],
                 kicker: Player,
                 punter: Player,
                 kickReturner: Seq[Player]
               )
