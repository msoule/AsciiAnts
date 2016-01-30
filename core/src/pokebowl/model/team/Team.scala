package pokebowl.model.team

import pokebowl.model.play.Play

/**
  * Created by msoule on 1/26/16.
  */
case class Team(
                 players: Seq[Player],
                 var plays: Array[Play],
                 stats: Int,
                 name: String,
                 location: String
               )
