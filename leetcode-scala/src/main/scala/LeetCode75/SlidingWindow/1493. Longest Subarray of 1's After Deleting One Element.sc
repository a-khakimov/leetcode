/*
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
 */

object Solution {
  def longestSubarray(nums: Array[Int]): Int = {
    var start = 0
    var end = 0
    var limit = 1
    var answer = 0
    val len = nums.length
    while (end < len) {
      if (nums(end) == 0)
        limit -= 1
      end += 1
      while (limit < 0) {
        if (nums(start) == 0)
          limit += 1
        start += 1
      }
      answer = Math.max(answer, end - start)
    }
    answer - 1
  }
}

println(Solution.longestSubarray(Array(1,1,0,1))) // 4
println(Solution.longestSubarray(Array(0,1,1,1,0,1,1,0,1))) // 5


