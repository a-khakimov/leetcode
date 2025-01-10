object Solution {
  def equalPairs(grid: Array[Array[Int]]): Int = {
    val columns = grid.map(_.toList).toList
    val rows = grid.transpose.toList.map(_.toList)
    var answer: Int = 0
    rows.foreach { row => answer += columns.count(_ == row) }
    answer
  }
}

Solution.equalPairs(Array(Array(3,2,1),Array(1,7,6),Array(2,7,7))) // 1
Solution.equalPairs(Array(Array(3,1,2,2),Array(1,4,4,5),Array(2,4,2,2),Array(2,4,2,2))) // 3
Solution.equalPairs(Array(Array(13, 13),Array(13, 13))) // 4
