package LeetCode75.Two_Pointers

object L11_ContainerWithMostWater extends App {
  object Solution {

    // bad solution
    def maxArea2(height: Array[Int]): Int = {
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

    def maxArea3(height: Array[Int]): Int = {
      var a = 0
      var b = height.length - 1
      var maxArea = 0
      while (a < b) {
        maxArea = Math.max(Math.min(height(a), height(b)) * (b - a), maxArea)
        if (height(a) < height(b)) {
          val cur = a
          while (a < b && height(cur) >= height(a)) {
            a += 1
          }
        } else {
          val cur = b
          while (a < b && height(cur) >= height(b)) {
            b -= 1
          }
        }
      }
      maxArea
    }

    def maxArea(height: Array[Int]): Int = {
      var a = 0
      var b = height.length - 1
      var maxArea = 0
      while (a < b) {
        maxArea = Math.max(Math.min(height(a), height(b)) * (b - a), maxArea)
        if (height(a) < height(b)) {
          a += 1
        } else {
          b -= 1
        }
      }
      maxArea
    }
  }

  println(Solution.maxArea(Array(1,8,6,2,5,4,8,3,7))) // 49
  println(Solution.maxArea(Array(1,1))) // 1
}
