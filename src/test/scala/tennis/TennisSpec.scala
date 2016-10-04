import org.scalatest._



class TennisSpec extends FeatureSpec with GivenWhenThen {

  info("In order to get the last score of a game as an arbitrator I can sum results")

  feature("Sum results") {
    scenario("Bob win a point") {
      Given("Bob & Alice start playing")
      val tennisGame = new TennisGame("Bob", "Alice")

      When("Bob win the point")
      val score = tennisGame.player1Scores()

      Then("Bob score is incremented by 1")
      assert(score == (1, 0))
    }

    scenario("Alice win a point") {
      Given("Bob & Alice start playing")
      val tennisGame = new TennisGame("Bob", "Alice")

      When("Alice win the point")
      val score = tennisGame.player2Scores()

      Then("Alice score is incremented by 1")
      assert(score == (0, 1))
    }
  }

  info("In order to define who win the game as an arbitrator I can evaluate result")


  feature("The winner has 4 point") {
    scenario("Bob has 3 points") {
      Given("Bob & alice playing and score is (3,2)")
      val tennisGame = new TennisGame("Bob", "Alice")

      When("Bob win the point")
      val score = tennisGame.player1Scores((3,2))

      Then("Bob win the game")
      assert(tennisGame.winnerIs(score) == Some("Bob"))
    }
  }

  feature("the winner should win the game by 2 points") {
    scenario("Bob&Alice has 3 points and Bob win the point") {
      Given("Bob & alice playing and score is (3,3)")
      val tennisGame = new TennisGame("Bob", "Alice")

      When("Bob win the point")
      val score = tennisGame.player1Scores((3,3))

      Then("Nobody win the game")
      assert(tennisGame.winnerIs(score) == None)
    }
    scenario("Bob&Alice has 3 points and Alice win the point") {
      Given("Bob & alice playing and score is (3,3)")
      val tennisGame = new TennisGame("Bob", "Alice")

      When("Alice win the point")
      val score = tennisGame.player2Scores((3,3))

      Then("Nobody win the game")
      assert(tennisGame.winnerIs(score) == None)
    }
  }


}