package LeetCode75.Array_String

object L238_ProductOfArrayExceptSelf extends App {

  object Solution {

    import scala.collection.mutable

    def productExceptSelf(nums: Array[Int]): Array[Int] = {
      val len = nums.length
      val answer: mutable.ArraySeq[Int] = mutable.ArraySeq.fill(len)(1)

      var lp = 1
      (0 until len).foreach { i =>
        answer(i) = lp
        lp = lp * nums(i)
      }

      var rp = 1
      (0 until len).reverse.toList.foreach { i =>
        answer(i) = answer(i) * rp
        rp = rp * nums(i)
      }

      answer.toArray
    }
  }

  println(Solution.productExceptSelf(Array(1,2,3,4)).toList)

}
