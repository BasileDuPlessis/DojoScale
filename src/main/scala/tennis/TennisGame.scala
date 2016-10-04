class TennisGame(val player1:String, val player2:String) {

  private val _score = collection.mutable.Seq[Tuple2[Int,Int]]()

  def player1Scores(score:Tuple2[Int,Int] = (0,0)) = (score._1 + 1, score._2)

  def player2Scores(score:Tuple2[Int,Int] = (0,0)) = (score._1, score._2 + 1)

  def winnerIs(score:Tuple2[Int,Int]):Option[String] = score match {
    case (a,b) if (a-b).abs<2 => None
    case (4,_) => Some(player1)
  }

}