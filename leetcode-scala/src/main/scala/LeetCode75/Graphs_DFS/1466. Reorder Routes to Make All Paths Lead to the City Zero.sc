object Solution {
  def minReorder(n: Int, connections: Array[Array[Int]]): Int = {
    val graph = Array.fill(n)(scala.collection.mutable.ListBuffer[(Int, Int)]())

    for (Array(a, b) <- connections) {
      graph(a) += ((b, 1))
      graph(b) += ((a, 0))
    }

    def dfs(node: Int, parent: Int): Int = {
      var changes = 0
      for ((neighbor, direction) <- graph(node)) {
        if (neighbor != parent) {
          changes += direction
          changes += dfs(neighbor, node)
        }
      }
      changes
    }

    dfs(0, -1)
  }
}
