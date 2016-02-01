package pokebowl.model.team

import pokebowl.model.team.StatGlossary.StatGlossary

/**
  * @author Mark Soule on 1/26/16.
  */
case class Player(
                  first: String,
                  last: String,
                  number: Int,
                  stats: Map[StatGlossary, Double]
                 )
