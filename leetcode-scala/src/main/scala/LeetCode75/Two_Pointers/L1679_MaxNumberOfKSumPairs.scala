package LeetCode75.Two_Pointers

object L1679_MaxNumberOfKSumPairs extends App {
  object Solution {
    // stupid solution
    def maxOperations1(nums: Array[Int], k: Int): Int = {
      val len = nums.length
      var i = 0
      var result = 0
      while (i < len) {
        var j = 0
        while (j < len) {
          if (j != i && nums(i) != -1 && nums(j) != -1 && ((nums(i) + nums(j)) == k)) {
            result += 1
            nums(i) = -1
            nums(j) = -1
          }
          j += 1
        }
        i += 1
      }
      result
    }

    def maxOperations(nums: Array[Int], k: Int): Int = {
      var a = 0
      var b = nums.length - 1
      val srtd = nums.sorted
      println(srtd.toList)
      var result = 0
      while (a < b) {
        val sum = srtd(a) + srtd(b)
        if (sum == k) {
          result += 1
          a += 1
          b -= 1
        } else if (sum < k) {
          a += 1
        } else {
          b -= 1
        }
      }
      result
    }
  }

  println(Solution.maxOperations(Array(1, 2, 3, 4), 5)) // 2
  println(Solution.maxOperations(Array(1, 2, 3, 4, 3, 2), 5)) // 3
  println(Solution.maxOperations(Array(3, 1, 2, 4, 3), 6)) // 1
  println(Solution.maxOperations(Array(3, 1, 2, 4, 3), 3)) // 1
}
