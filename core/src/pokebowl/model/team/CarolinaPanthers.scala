package pokebowl.model.team

/**
  * Create the Carolina Panthers team. Stats scrapped from
  * http://espn.go.com/nfl/team/stats/_/name/car
  *
  * @author Mark Soule on 1/28/16.
  */
object CarolinaPanthers {
  val camNewton = new Player("Cam", "Newton", 1,
    Map(
      StatGlossary.Att -> 495,
      StatGlossary.Comp -> 296,
      StatGlossary.Pct -> 59.8,
      StatGlossary.Yds -> 3837,
      StatGlossary.Avg -> 7.8,
      StatGlossary.YdsPerG -> 222.1,
      StatGlossary.Long -> 74,
      StatGlossary.Td -> 35,
      StatGlossary.TdP -> 7.1,
      StatGlossary.Int -> 10,
      StatGlossary.IntP -> 2.0,
      StatGlossary.Sack -> 33,
      StatGlossary.Ydsl -> 284,
      StatGlossary.Rate -> 99.4
    )
  )

  // runningback/halfback/fullback

  val jonathanStewart = new Player("Jonathan", "Stewart", 28,
    Map(
      StatGlossary.Att -> 242,
      StatGlossary.Yds -> 989,
      StatGlossary.Avg -> 4.1,
      StatGlossary.YdsPerG -> 76.1,
      StatGlossary.Long -> 44,
      StatGlossary.Td -> 6,
      StatGlossary.TwentyPlus -> 4,
      StatGlossary.Fum -> 3,
      StatGlossary.Fuml -> 2,
      StatGlossary.OneDn -> 41
    )
  )

  val mikeTolbert = new Player("Mike", "Tolbert", 35,
    Map(
      StatGlossary.Att -> 62,
      StatGlossary.Yds -> 256,
      StatGlossary.Avg -> 4.1,
      StatGlossary.YdsPerG -> 16.0,
      StatGlossary.Long -> 29,
      StatGlossary.Td -> 1,
      StatGlossary.TwentyPlus -> 1,
      StatGlossary.Fum -> 0,
      StatGlossary.Fuml -> 0,
      StatGlossary.OneDn -> 18
    )
  )

  // wide receivers

  val tedGinnJr = new Player("Ted", "Ginn Jr.", 19,
    Map(
      StatGlossary.Rec -> 44,
      StatGlossary.Tar -> 96,
      StatGlossary.Yds -> 739,
      StatGlossary.Avg -> 16.8,
      StatGlossary.Td -> 10,
      StatGlossary.Long -> 74,
      StatGlossary.TwentyPlus -> 10,
      StatGlossary.YdsPerG -> 49.3,
      StatGlossary.Fum -> 0,
      StatGlossary.Fuml -> 0,
      StatGlossary.Yac -> 250,
      StatGlossary.OneDn -> 36
    )
  )

  val jerrichoCotchery = new Player("Jerricho", "Cotchery", 82,
    Map(
      StatGlossary.Rec -> 36,
      StatGlossary.Tar -> 53,
      StatGlossary.Yds -> 485,
      StatGlossary.Avg -> 12.4,
      StatGlossary.Td -> 3,
      StatGlossary.Long -> 59,
      StatGlossary.TwentyPlus -> 6,
      StatGlossary.YdsPerG -> 34.6,
      StatGlossary.Fum -> 0,
      StatGlossary.Fuml -> 0,
      StatGlossary.Yac -> 177,
      StatGlossary.OneDn -> 26
    )
  )

  // tight end

  val gregOlsen = new Player("Greg", "Olsen", 88,
    Map(
      StatGlossary.Rec -> 77,
      StatGlossary.Tar -> 123,
      StatGlossary.Yds -> 1104,
      StatGlossary.Avg -> 14.3,
      StatGlossary.Td -> 7,
      StatGlossary.Long -> 52,
      StatGlossary.TwentyPlus -> 20,
      StatGlossary.YdsPerG -> 69.0,
      StatGlossary.Fum -> 1,
      StatGlossary.Fuml -> 1,
      StatGlossary.Yac -> 364,
      StatGlossary.OneDn -> 52
    )
  )

  val edDickson = new Player("Ed", "Dickson", 84,
    Map(
      StatGlossary.Rec -> 17,
      StatGlossary.Tar -> 26,
      StatGlossary.Yds -> 121,
      StatGlossary.Avg -> 7.1,
      StatGlossary.Td -> 2,
      StatGlossary.Long -> 17,
      StatGlossary.TwentyPlus -> 0,
      StatGlossary.YdsPerG -> 7.6,
      StatGlossary.Fum -> 0,
      StatGlossary.Fuml -> 0,
      StatGlossary.Yac -> 55,
      StatGlossary.OneDn -> 10
    )
  )

  // linebacker

  val lukeKuechly = new Player("Luke", "Keuchly", 59,
    Map(
      StatGlossary.Solo -> 76,
      StatGlossary.Ast -> 42,
      StatGlossary.Tot -> 118,
      StatGlossary.Sack -> 1,
      StatGlossary.Ydsl -> 5,
      StatGlossary.Tloss -> 8,
      StatGlossary.Pd -> 10,
      StatGlossary.Int -> 4,
      StatGlossary.Yds -> 48,
      StatGlossary.Long -> 32,
      StatGlossary.ITd -> 1,
      StatGlossary.Ff -> 2,
      StatGlossary.Rec -> 1,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val thomasDavis = new Player("Thomas", "Davis", 58,
    Map(
      StatGlossary.Solo -> 75,
      StatGlossary.Ast -> 30,
      StatGlossary.Tot -> 105,
      StatGlossary.Sack -> 5.5,
      StatGlossary.Ydsl -> 44,
      StatGlossary.Tloss -> 3,
      StatGlossary.Pd -> 7,
      StatGlossary.Int -> 4,
      StatGlossary.Yds -> 22,
      StatGlossary.Long -> 22,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 4,
      StatGlossary.Rec -> 1,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val ajKlein = new Player("A.J.", "Klein", 56,
    Map(
      StatGlossary.Solo -> 39,
      StatGlossary.Ast -> 16,
      StatGlossary.Tot -> 55,
      StatGlossary.Sack -> 1.0,
      StatGlossary.Ydsl -> 8,
      StatGlossary.Tloss -> 6,
      StatGlossary.Pd -> 1,
      StatGlossary.Int -> 1,
      StatGlossary.Yds -> 8,
      StatGlossary.Long -> 8,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 1,
      StatGlossary.Rec -> 0,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val shaqThompson = new Player("Shaq", "Thompson", 54,
    Map(
      StatGlossary.Solo -> 32,
      StatGlossary.Ast -> 18,
      StatGlossary.Tot -> 50,
      StatGlossary.Sack -> 1,
      StatGlossary.Ydsl -> 0,
      StatGlossary.Tloss -> 4,
      StatGlossary.Pd -> 2,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 0,
      StatGlossary.Rec -> 0,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  // defensive end

  val konyEaly = new Player("Kony", "Ealy", 94,
    Map(
      StatGlossary.Solo -> 15,
      StatGlossary.Ast -> 17,
      StatGlossary.Tot -> 32,
      StatGlossary.Sack -> 5.0,
      StatGlossary.Ydsl -> 30,
      StatGlossary.Tloss -> 2,
      StatGlossary.Pd -> 2,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 3,
      StatGlossary.Rec -> 2,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val jaredAllen = new Player("Jared", "Allen", 69,
    Map(
      StatGlossary.Solo -> 15,
      StatGlossary.Ast -> 12,
      StatGlossary.Tot -> 27,
      StatGlossary.Sack -> 2.0,
      StatGlossary.Ydsl -> 13,
      StatGlossary.Tloss -> 1,
      StatGlossary.Pd -> 2,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 1,
      StatGlossary.Rec -> 1,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  // defensive tackle

  val kawannShort = new Player("Kawann", "Short", 99,
    Map(
      StatGlossary.Solo -> 36,
      StatGlossary.Ast -> 19,
      StatGlossary.Tot -> 55,
      StatGlossary.Sack -> 11.0,
      StatGlossary.Ydsl -> 91,
      StatGlossary.Tloss -> 7,
      StatGlossary.Pd -> 4,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 3,
      StatGlossary.Rec -> 2,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val starLotulelei = new Player("Star", "Lotulelei", 98,
    Map(
      StatGlossary.Solo -> 13,
      StatGlossary.Ast -> 9,
      StatGlossary.Tot -> 22,
      StatGlossary.Sack -> 1,
      StatGlossary.Ydsl -> 8,
      StatGlossary.Tloss -> 2,
      StatGlossary.Pd -> 2,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 1,
      StatGlossary.Rec -> 1,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  // cornerback

  val beneBenwikere = new Player("Bene", "Benwikere", 25,
    Map(
      StatGlossary.Solo -> 44,
      StatGlossary.Ast -> 15,
      StatGlossary.Tot -> 59,
      StatGlossary.Sack -> 1,
      StatGlossary.Ydsl -> 9,
      StatGlossary.Tloss -> 3,
      StatGlossary.Pd -> 9,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 1,
      StatGlossary.Rec -> 1,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val joshNorman = new Player("Josh", "Norman", 24,
    Map(
      StatGlossary.Solo -> 48,
      StatGlossary.Ast -> 8,
      StatGlossary.Tot -> 56,
      StatGlossary.Sack -> 0,
      StatGlossary.Ydsl -> 0,
      StatGlossary.Tloss -> 3,
      StatGlossary.Pd -> 18,
      StatGlossary.Int -> 4,
      StatGlossary.Yds -> 110,
      StatGlossary.Long -> 46,
      StatGlossary.ITd -> 2,
      StatGlossary.Ff -> 3,
      StatGlossary.Rec -> 2,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  // safety

  val kurtColeman = new Player("Kurt", "Coleman", 20,
    Map(
      StatGlossary.Solo -> 55,
      StatGlossary.Ast -> 35,
      StatGlossary.Tot -> 90,
      StatGlossary.Sack -> 1,
      StatGlossary.Ydsl -> 7,
      StatGlossary.Tloss -> 3,
      StatGlossary.Pd -> 9,
      StatGlossary.Int -> 7,
      StatGlossary.Yds -> 89,
      StatGlossary.Long -> 36,
      StatGlossary.ITd -> 1,
      StatGlossary.Ff -> 0,
      StatGlossary.Rec -> 0,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val romanHarper = new Player("Roman", "Harper", 41,
    Map(
      StatGlossary.Solo -> 46,
      StatGlossary.Ast -> 27,
      StatGlossary.Tot -> 73,
      StatGlossary.Sack -> 0,
      StatGlossary.Ydsl -> 0,
      StatGlossary.Tloss -> 2,
      StatGlossary.Pd -> 5,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 0,
      StatGlossary.Rec -> 2,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  // kicker
  val grahamGano = new Player("Graham", "Gano", 9,
    Map(
      StatGlossary.Fgm -> 30,
      StatGlossary.Fga -> 36,
      StatGlossary.FgPct -> 83.3,
      StatGlossary.Long -> 52,
      StatGlossary.One19 -> 1,
      StatGlossary.Twenty29 -> 10,
      StatGlossary.Thirty39 -> 4,
      StatGlossary.Fourty49 -> 13,
      StatGlossary.FiftyPlus -> 2,
      StatGlossary.Xpm -> 56,
      StatGlossary.Xpa -> 59,
      StatGlossary.EpPct -> 94.9,
      StatGlossary.Tb -> 94.9
    )
  )

  // punter
  val bradNortman = new Player("Brad", "Nortman", 8,
    Map(
      StatGlossary.Punts -> 70,
      StatGlossary.Yds -> 3175,
      StatGlossary.Long -> 65,
      StatGlossary.Avg -> 45.4,
      StatGlossary.Net -> 39.8,
      StatGlossary.Bp -> 0,
      StatGlossary.In20 -> 20,
      StatGlossary.Tb -> 5,
      StatGlossary.Fc -> 19,
      StatGlossary.Ret -> 37,
      StatGlossary.Rety -> 288,
      StatGlossary.AvgReturn -> 7.8
    )
  )

  val team =
    new Team(Array(),
             Map(),
             "Panthers",
             "Carolina",
             camNewton,
             Seq(jonathanStewart, mikeTolbert),
             Seq(tedGinnJr, jerrichoCotchery),
             Seq(gregOlsen, edDickson),
             null,
             Seq(),
             Seq(),
             Seq(lukeKuechly, thomasDavis),
             Seq(ajKlein, shaqThompson),
             Seq(konyEaly, jaredAllen),
             Seq(kawannShort, starLotulelei),
             Seq(beneBenwikere, joshNorman),
             Seq(kurtColeman, romanHarper),
             grahamGano,
             bradNortman,
             Seq()
             )
}
