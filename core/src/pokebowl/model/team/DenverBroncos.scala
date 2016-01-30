package pokebowl.model.team

/**
  * @author Mark Soule on 1/28/16.
  */
object DenverBroncos {
  val peytonManning = new Player("Peyton", "Manning", 18,
    Map(
      StatGlossary.Att -> 331,
      StatGlossary.Comp -> 198,
      StatGlossary.Pct -> 59.8,
      StatGlossary.Yds -> 2249,
      StatGlossary.Avg -> 6.8,
      StatGlossary.YdsPerG -> 215.4,
      StatGlossary.Long -> 75,
      StatGlossary.Td -> 9,
      StatGlossary.TdP -> 2.7,
      StatGlossary.Int -> 17,
      StatGlossary.IntP -> 5.1,
      StatGlossary.Sack -> 16,
      StatGlossary.Ydsl -> 95,
      StatGlossary.Rate -> 67.9
    )
  )

  val ronnieHillman = new Player("Ronnie", "Hillman", 23,
    Map(
      StatGlossary.Att -> 207,
      StatGlossary.Yds -> 863,
      StatGlossary.Avg -> 4.2,
      StatGlossary.YdsPerG -> 53.9,
      StatGlossary.Long -> 72,
      StatGlossary.Td -> 7,
      StatGlossary.TwentyPlus -> 5,
      StatGlossary.Fum -> 2,
      StatGlossary.Fuml -> 1,
      StatGlossary.OneDn -> 43
    )
  )
  val team =
    new Team(
            Array(),
            10,
            "Denver",
            "Broncos",
            null,
            Seq(),
            Seq(),
            Seq(),
            null,
            Seq(),
            Seq(),
            Seq(),
            Seq(),
            null,
            Seq(),
            Seq(),
            Seq(),
            null,
            null,
            Seq()
            )
}
