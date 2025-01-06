package LeetCode75.Two_Pointers

object L11_ContainerWithMostWater extends App {
  object Solution {
    def maxArea(height: Array[Int]): Int = {
      val len = height.length
      var a = 0
      var b = 1
      var maxArea = 0
      while (a < len) {
        while (b < len) {
          val area = (b - a) * Math.min(height(a), height(b))
          if (area > maxArea) {
            maxArea = area
          }
          b += 1
        }
        a += 1
        b = a + 1
      }
      maxArea
    }
  }

  println(Solution.maxArea(Array(1,8,6,2,5,4,8,3,7))) // 49
  println(Solution.maxArea(Array(1,1))) // 1
}
