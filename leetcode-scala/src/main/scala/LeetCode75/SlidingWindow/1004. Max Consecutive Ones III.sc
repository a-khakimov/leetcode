object Solution {
  def longestOnes(nums: Array[Int], k: Int): Int = {
    var start = 0
    var end = 0
    var limit = k
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
    answer
  }
}


println(Solution.longestOnes(Array(0,0,0,1), 4)) // 4
println(Solution.longestOnes(Array(1,1,1,0,0,0,1,1,1,1), 0)) // 4
println(Solution.longestOnes(Array(1,1,1,0,0,0,1,1,1,1,0), 2)) // 6
println(Solution.longestOnes(Array(0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1), 3)) // 10
println(Solution.longestOnes(Array(1,0,0,1,0,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,0,1,0,0,1,0,0,1,1), 9)) // 32
