package LeetCode75.Two_Pointers

object L283_MoveZeroes extends App {
  object Solution {
    def moveZeroes(nums: Array[Int]): Unit = {
      val (zeroes, others) = nums.partition(_ == 0)
      val full = others ++ zeroes
      nums.indices.foreach(i => nums(i) = full(i))
    }

    import scala.util.control.Breaks._
    def moveZeroes2(nums: Array[Int]): Unit = {
      var i = 0
      var j = 0
      val len = nums.length

      while (i < len) {
        if (nums(i) == 0) {
          j = i + 1
          breakable {
            while (j < len) {
              if (nums(j) != 0) {
                nums(i) = nums(j)
                nums(j) = 0
                break
              }
              j = j + 1
            }
          }
        }
        i = i + 1
      }
    }

    def moveZeroes3(nums: Array[Int]): Unit = {
      val len = nums.length
      var i = 0
      var l = 0
      while (i < len) {
        if (nums(i) != 0) {
          val tmp = nums(i)
          nums(i) = nums(l)
          nums(l) = tmp
          l = l + 1
        }
        i = i + 1
      }
    }
  }



  val array1 = Array(0,1,0,3,12)
  Solution.moveZeroes3(array1)
  println(array1.toList)

  val array2 = Array(1, 0)
  Solution.moveZeroes3(array2)
  println(array2.toList)

  val array3 = Array(0)
  Solution.moveZeroes3(array3)
  println(array3.toList)
}
