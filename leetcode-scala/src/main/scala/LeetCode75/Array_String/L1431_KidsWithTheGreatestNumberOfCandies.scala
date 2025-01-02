package LeetCode75.Array_String

object L1431_KidsWithTheGreatestNumberOfCandies extends App {
  object Solution {
    def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] = {
      val maxCandies = candies.max
      candies.map(candie => (candie + extraCandies) >= maxCandies).toList
    }
  }

  println(Solution.kidsWithCandies(Array(2,3,5,1,3), 3))
}
