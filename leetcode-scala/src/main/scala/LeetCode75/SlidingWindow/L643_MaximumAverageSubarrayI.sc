object Solution {
  // stupid solution
  def findMaxAverage1(nums: Array[Int], k: Int): Double = {
    var start = 0
    var end = start + k
    val len = nums.length
    var answer: Double = Double.MinValue

    while(end <= len) {
      var i = start
      var sum: Double = 0
      while (i < end) {
        sum += nums(i)
        i += 1
      }
      val avg: Double = sum / k
      if (avg > answer) {
        answer = avg
      }
      start += 1
      end += 1
    }

    answer
  }

  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    var start = 0
    var end = start + k
    val len = nums.length

    var i = start
    var sum: Double = 0
    while (i < end) {
      sum += nums(i)
      i += 1
    }
    var answer: Double = sum / k

    while (end < len) {
      start += 1
      end += 1
      sum = (sum - nums(start - 1)) + nums(end - 1)
      answer = Math.max(sum / k, answer)
    }

    answer
  }
}

println(Solution.findMaxAverage(Array(1,12,-5,-6,50,3), 4)) // result: 12.75000
println(Solution.findMaxAverage(Array(5), 1)) // result: 5
println(Solution.findMaxAverage(Array(-1), 1)) // result: 5
println(Solution.findMaxAverage(Array(0,1,1,3,3), 4)) // result: 5
