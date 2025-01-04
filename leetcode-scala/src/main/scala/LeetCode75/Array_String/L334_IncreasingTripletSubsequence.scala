package LeetCode75.Array_String

object L334_IncreasingTripletSubsequence extends App {
  object Solution {

    def increasingTriplet(nums: Array[Int]): Boolean = {
      var min1 = Int.MaxValue
      var min2 = Int.MaxValue

      val isFound: Int => Boolean = num => {
          if (num <= min1) {
            min1 = num
            false
          } else if (num <= min2) {
            min2 = num
            false
          } else true
      }

      nums.collectFirst { case num if isFound(num) => true }.getOrElse(false)
    }
  }

  println(Solution.increasingTriplet(Array(1,2,3,4,5))) // true (0,1,2)
  println(Solution.increasingTriplet(Array(5,4,3,2,1))) // false
  println(Solution.increasingTriplet(Array(20,100,10,12,5,13))) // true (2,3,5)


}
