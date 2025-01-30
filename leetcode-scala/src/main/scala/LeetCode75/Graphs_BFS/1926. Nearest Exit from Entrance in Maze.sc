object Solution {
  import scala.collection.mutable

  private def isBorderCell(row: Int, col: Int, rows: Int, cols: Int): Boolean = {
    row == 0 || row == rows - 1 || col == 0 || col == cols - 1
  }

  def nearestExit(maze: Array[Array[Char]], entrance: Array[Int]): Int = {
    val rows = maze.length
    val cols = maze(0).length
    val directions = Array((0, 1), (1, 0), (0, -1), (-1, 0))
    val visited = mutable.Set.empty[(Int, Int)]
    val (entranceRow, entranceCol) = (entrance(0), entrance(1))
    visited.addOne((entranceRow, entranceCol))
    val queue = mutable.Queue.empty[(Int, Int, Int)]
    queue.enqueue((entranceRow, entranceCol, 0))

    while (queue.nonEmpty) {
      val (row, col, steps) = queue.dequeue()
      if (isBorderCell(row, col, rows, cols) && (row, col) != (entranceRow, entranceCol)) {
        return steps
      }

      for ((dr, dc) <- directions) {
        val newRow = row + dr
        val newCol = col + dc
        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
          if (maze(newRow)(newCol) == '.' && !visited.contains((newRow, newCol))) {
            queue.enqueue((newRow, newCol, steps + 1))
            visited.addOne((newRow, newCol))
          }
        }
      }
    }
    -1
  }
}

Solution.nearestExit(
  Array(
    Array('+','+','.','+'),
    Array('+','+','.','+'),
    Array('+','+','.','+'),
    Array('+','.','.','+'),
    Array('+','+','+','+')
  ),
  Array(3, 1)
)

Solution.nearestExit(
  Array(
    Array('+','.','+','+','+','+','+'),
    Array('+','.','+','.','.','.','+'),
    Array('+','.','+','.','+','.','+'),
    Array('+','.','.','.','+','.','+'),
    Array('+','+','+','+','+','.','+')
  ),
  Array(0, 1)
)




