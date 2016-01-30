package pokebowl.model.team

/**
  * Enum for for the different types of stats on a player.
  * @author Mark Soule on 1/30/16.
  */
object StatGlossary extends Enumeration {
  type StatGlossary = Value
  val Att, Comp, Pct, Yds, Avg, YdsPerG, Long, Td, TdP, Int, IntP, Sack, Ydsl, Rate, TwentyPlus, Fum, Fuml, OneDn = Value
}
