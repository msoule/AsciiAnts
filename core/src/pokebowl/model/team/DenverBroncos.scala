package pokebowl.model.team

/**
  * Create the Denver Broncos team. Stats scrapped from
  * http://espn.go.com/nfl/team/stats/_/name/den
  *
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

  val cjAnderson = new Player("C.J.", "Anderson", 22,
    Map(
      StatGlossary.Att -> 152,
      StatGlossary.Yds -> 863,
      StatGlossary.Avg -> 4.7,
      StatGlossary.YdsPerG -> 48.0,
      StatGlossary.Long -> 48,
      StatGlossary.Td -> 5,
      StatGlossary.TwentyPlus -> 5,
      StatGlossary.Fum -> 2,
      StatGlossary.Fuml -> 2,
      StatGlossary.OneDn -> 33
    )
  )

  val demaryiusThomas = new Player("Demaryius", "Thomas", 88,
    Map(
      StatGlossary.Rec -> 105,
      StatGlossary.Tar -> 176,
      StatGlossary.Yds -> 1304,
      StatGlossary.Avg -> 12.4,
      StatGlossary.Td -> 6,
      StatGlossary.Long -> 72,
      StatGlossary.TwentyPlus -> 14,
      StatGlossary.YdsPerG -> 81.5,
      StatGlossary.Fum -> 2,
      StatGlossary.Fuml -> 2,
      StatGlossary.Yac -> 418,
      StatGlossary.OneDn -> 63
    )
  )

  val emmanuelSanders = new Player("Emmanuel", "Sanders", 10,
    Map(
      StatGlossary.Rec -> 76,
      StatGlossary.Tar -> 137,
      StatGlossary.Yds -> 1135,
      StatGlossary.Avg -> 12.4,
      StatGlossary.Td -> 6,
      StatGlossary.Long -> 75,
      StatGlossary.TwentyPlus -> 12,
      StatGlossary.YdsPerG -> 75.7,
      StatGlossary.Fum -> 1,
      StatGlossary.Fuml -> 1,
      StatGlossary.Yac -> 337,
      StatGlossary.OneDn -> 51
    )
  )

  val owenDaniels = new Player("Owen", "Daniels", 81,
    Map(
      StatGlossary.Rec -> 46,
      StatGlossary.Tar -> 77,
      StatGlossary.Yds -> 517,
      StatGlossary.Avg -> 11.2,
      StatGlossary.Td -> 3,
      StatGlossary.Long -> 37,
      StatGlossary.TwentyPlus -> 6,
      StatGlossary.YdsPerG -> 32.3,
      StatGlossary.Fum -> 0,
      StatGlossary.Fuml -> 0,
      StatGlossary.Yac -> 260,
      StatGlossary.OneDn -> 27
    )
  )

  val vernonDavis = new Player("Vernon", "Davis", 80,
    Map(
      StatGlossary.Rec -> 20,
      StatGlossary.Tar -> 29,
      StatGlossary.Yds -> 201,
      StatGlossary.Avg -> 10.1,
      StatGlossary.Td -> 0,
      StatGlossary.Long -> 23,
      StatGlossary.TwentyPlus -> 1,
      StatGlossary.YdsPerG -> 22.3,
      StatGlossary.Fum -> 0,
      StatGlossary.Fuml -> 0,
      StatGlossary.Yac -> 79,
      StatGlossary.OneDn -> 11
    )
  )

  // linebacker

  val dannyTrevathan = new Player("Danny", "Trevathan", 59,
    Map(
      StatGlossary.Solo -> 73,
      StatGlossary.Ast -> 36,
      StatGlossary.Tot -> 109,
      StatGlossary.Sack -> 0,
      StatGlossary.Ydsl -> 0,
      StatGlossary.Tloss -> 3,
      StatGlossary.Pd -> 6,
      StatGlossary.Int -> 2,
      StatGlossary.Yds -> 39,
      StatGlossary.Long -> 25,
      StatGlossary.ITd -> 1,
      StatGlossary.Ff -> 0,
      StatGlossary.Rec -> 0,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val brandonMarshall = new Player("Brandon", "Marshall", 54,
    Map(
      StatGlossary.Solo -> 77,
      StatGlossary.Ast -> 25,
      StatGlossary.Tot -> 109,
      StatGlossary.Sack -> 1.5,
      StatGlossary.Ydsl -> 11,
      StatGlossary.Tloss -> 8,
      StatGlossary.Pd -> 4,
      StatGlossary.Int -> 1,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 2,
      StatGlossary.Rec -> 0,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val shaquilBarrett = new Player("Shaquil", "Barrett", 48,
    Map(
      StatGlossary.Solo -> 35,
      StatGlossary.Ast -> 15,
      StatGlossary.Tot -> 50,
      StatGlossary.Sack -> 5.5,
      StatGlossary.Ydsl -> 39,
      StatGlossary.Tloss -> 6,
      StatGlossary.Pd -> 4,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 5,
      StatGlossary.Rec -> 2,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val vonMiller = new Player("Von", "Miller", 58,
    Map(
      StatGlossary.Solo -> 30,
      StatGlossary.Ast -> 5,
      StatGlossary.Tot -> 35,
      StatGlossary.Sack -> 11,
      StatGlossary.Ydsl -> 78,
      StatGlossary.Tloss -> 2,
      StatGlossary.Pd -> 1,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 4,
      StatGlossary.Rec -> 3,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  // defensive end

  val derekWolfe = new Player("Derek", "Wolfe", 95,
    Map(
      StatGlossary.Solo -> 35,
      StatGlossary.Ast -> 14,
      StatGlossary.Tot -> 49,
      StatGlossary.Sack -> 5.5,
      StatGlossary.Ydsl -> 39,
      StatGlossary.Tloss -> 4,
      StatGlossary.Pd -> 1,
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

  val deMarcusWare = new Player("DeMarcus", "Ware", 94,
    Map(
      StatGlossary.Solo -> 17,
      StatGlossary.Ast -> 8,
      StatGlossary.Tot -> 25,
      StatGlossary.Sack -> 7.5,
      StatGlossary.Ydsl -> 58,
      StatGlossary.Tloss -> 2,
      StatGlossary.Pd -> 0,
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

  val malikJackson = new Player("Malik", "Jackson", 97,
    Map(
      StatGlossary.Solo -> 34,
      StatGlossary.Ast -> 11,
      StatGlossary.Tot -> 45,
      StatGlossary.Sack -> 5.0,
      StatGlossary.Ydsl -> 32,
      StatGlossary.Tloss -> 2,
      StatGlossary.Pd -> 7,
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

  val vanceWalker = new Player("Vance", "Walker", 96,
    Map(
      StatGlossary.Solo -> 23,
      StatGlossary.Ast -> 10,
      StatGlossary.Tot -> 33,
      StatGlossary.Sack -> 2,
      StatGlossary.Ydsl -> 16,
      StatGlossary.Tloss -> 2,
      StatGlossary.Pd -> 0,
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

  // cornerback

  val chrisHarrisJr = new Player("Chris", "Harris Jr.", 25,
    Map(
      StatGlossary.Solo -> 49,
      StatGlossary.Ast -> 9,
      StatGlossary.Tot -> 58,
      StatGlossary.Sack -> 0,
      StatGlossary.Ydsl -> 0,
      StatGlossary.Tloss -> 4,
      StatGlossary.Pd -> 6,
      StatGlossary.Int -> 2,
      StatGlossary.Yds -> 94,
      StatGlossary.Long -> 74,
      StatGlossary.ITd -> 1,
      StatGlossary.Ff -> 2,
      StatGlossary.Rec -> 0,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val aqibTalib = new Player("Aqib", "Talib", 21,
    Map(
      StatGlossary.Solo -> 39,
      StatGlossary.Ast -> 14,
      StatGlossary.Tot -> 45,
      StatGlossary.Sack -> 0,
      StatGlossary.Ydsl -> 0,
      StatGlossary.Tloss -> 1,
      StatGlossary.Pd -> 13,
      StatGlossary.Int -> 3,
      StatGlossary.Yds -> 123,
      StatGlossary.Long -> 63,
      StatGlossary.ITd -> 2,
      StatGlossary.Ff -> 0,
      StatGlossary.Rec -> 0,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 1
    )
  )

  // safety

  val darianStewart = new Player("Darian", "Stewart", 26,
    Map(
      StatGlossary.Solo -> 48,
      StatGlossary.Ast -> 15,
      StatGlossary.Tot -> 63,
      StatGlossary.Sack -> 0,
      StatGlossary.Ydsl -> 0,
      StatGlossary.Tloss -> 0,
      StatGlossary.Pd -> 10,
      StatGlossary.Int -> 1,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 1,
      StatGlossary.Rec -> 2,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  val tjSmith = new Player("T.J.", "Smith", 43,
    Map(
      StatGlossary.Solo -> 50,
      StatGlossary.Ast -> 11,
      StatGlossary.Tot -> 61,
      StatGlossary.Sack -> 2,
      StatGlossary.Ydsl -> 18,
      StatGlossary.Tloss -> 3,
      StatGlossary.Pd -> 6,
      StatGlossary.Int -> 0,
      StatGlossary.Yds -> 0,
      StatGlossary.Long -> 0,
      StatGlossary.ITd -> 0,
      StatGlossary.Ff -> 2,
      StatGlossary.Rec -> 0,
      StatGlossary.Td -> 0,
      StatGlossary.Bk -> 0
    )
  )

  // kicker
  val brandonMcManus = new Player("Brandon", "McManus", 8,
    Map(
      StatGlossary.Fgm -> 30,
      StatGlossary.Fga -> 35,
      StatGlossary.FgPct -> 85.7,
      StatGlossary.Long -> 57,
      StatGlossary.One19 -> 0,
      StatGlossary.Twenty29 -> 12,
      StatGlossary.Thirty39 -> 8,
      StatGlossary.Fourty49 -> 5,
      StatGlossary.FiftyPlus -> 5,
      StatGlossary.Xpm -> 35,
      StatGlossary.Xpa -> 36,
      StatGlossary.EpPct -> 97.2
    )
  )

  // punter
  val brittonColquitt = new Player("Britton", "Colquitt", 4,
    Map(
      StatGlossary.Punts -> 84,
      StatGlossary.Yds -> 3663,
      StatGlossary.Long -> 62,
      StatGlossary.Avg -> 43.6,
      StatGlossary.Net -> 39.7,
      StatGlossary.Bp -> 0,
      StatGlossary.In20 -> 22,
      StatGlossary.Tb -> 4,
      StatGlossary.Fc -> 16,
      StatGlossary.Ret -> 36,
      StatGlossary.Rety -> 247,
      StatGlossary.AvgReturn -> 6.9
    )
  )

  val team =
    new Team(
            Array(),
            Map(),
            "Broncos",
            "Denver",
            peytonManning,
            Seq(ronnieHillman, cjAnderson),
            Seq(demaryiusThomas, emmanuelSanders),
            Seq(owenDaniels, vernonDavis),
            null,
            Seq(),
            Seq(),
            Seq(malikJackson, vanceWalker),
            Seq(derekWolfe, deMarcusWare),
            Seq(dannyTrevathan, brandonMarshall),
            Seq(shaquilBarrett, vonMiller),
            Seq(chrisHarrisJr, aqibTalib),
            Seq(darianStewart, tjSmith),
            brandonMcManus,
            brittonColquitt,
            Seq()
            )
}
