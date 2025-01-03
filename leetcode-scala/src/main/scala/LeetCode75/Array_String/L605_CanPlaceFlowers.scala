package LeetCode75.Array_String



object L605_CanPlaceFlowers extends App {
  object Solution {

    def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
      val flowerbedLen = flowerbed.length
      val (_, flowersN) = flowerbed.indices.foldLeft((true, n)) {
        case ((canPlacePrev, flowersN), i) if flowersN > 0 => {

          val prev = if (i == 0) -1 else flowerbed(i - 1)
          val cur = flowerbed(i)
          val next = if (i == flowerbedLen - 1) -1 else flowerbed(i + 1)

          val canPlace = {
            if (prev == -1 && next == -1)      cur == 0
            else if (prev == -1 && next != -1) cur == 0 && next == 0
            else if (prev != -1 && next == -1) prev == 0 && cur == 0 && !canPlacePrev
            else                               prev == 0 && cur == 0 && next == 0 && !canPlacePrev
          }

          println(s"[$i] prev=$prev cur=$cur next=$next canPlacePrev=$canPlacePrev canPlace=$canPlace flowersN=$flowersN")

          (canPlace, if (canPlace) flowersN - 1 else flowersN)
        }
        case ((canPlacePrev, flowersN), i) => (canPlacePrev, flowersN)
      }

      flowersN == 0
    }
  }

  println(Solution.canPlaceFlowers(Array(1, 0, 0, 0, 1), 1)) // true
  println(Solution.canPlaceFlowers(Array(1, 0, 0, 0, 1), 2)) // false
  println(Solution.canPlaceFlowers(Array(1, 0, 0, 0, 0, 1), 2)) // false
  println(Solution.canPlaceFlowers(Array(1, 0, 0, 0, 0, 0, 1), 2)) // true
  println(Solution.canPlaceFlowers(Array(0, 0, 1, 0, 0), 1)) // true
  println(Solution.canPlaceFlowers(Array(0, 1, 0), 1)) // false
}
