object Solution {
  def pivotIndex(nums: Array[Int]): Int = {
    val len = nums.length
    var rsum = nums.sum
    var lsum = 0
    var i = 0
    var answer = -1
    while (i < len) {
      rsum -= nums(i)
      if (lsum == rsum) {
        answer = i
        i = len
      } else {
        lsum += nums(i)
      }
      i += 1

      println(s"lsum=$lsum rsum=${rsum}")
    }
    answer
  }
}


Solution.pivotIndex(Array(1,7,3,6,5,6)) // 3
Solution.pivotIndex(Array(1,2,3)) // -1
Solution.pivotIndex(Array(2,1,-1)) // 0
