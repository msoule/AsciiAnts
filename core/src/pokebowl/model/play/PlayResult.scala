package pokebowl.model.play

/**
  * @author Mark Soule on 1/28/16.
  */
object PlayResult extends Enumeration {
  type PlayResult = Value
  val Great, VeryGood, Good, Average, Bad, VeryBad, Terrible = Value
}
