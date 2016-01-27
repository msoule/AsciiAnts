package pokebowl.model

/**
  * Created by msoule on 1/26/16.
  */
case class Team(
                 players: Seq[Player],
                 plays: Seq[Play],
                 stats: Int
               )
