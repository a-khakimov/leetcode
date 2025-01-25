object Solution {

  def dfs(graph: Map[Int, Set[Int]], start: Int, visited: Set[Int] = Set.empty): Set[Int] = {
    if (visited.contains(start)) visited
    else graph.getOrElse(start, Nil).foldLeft(visited + start)(
      (acc, neighbor) => dfs(graph, neighbor, acc)
    )
  }

  // stupid solution
  def findCircleNum(isConnected: Array[Array[Int]]): Int = {
    val graph = scala.collection.mutable.Map.empty[Int, Set[Int]]
    val n = isConnected.length
    var i = 0
    while (i < n) {
      var j = 0
      while (j < n) {
        if (isConnected(i)(j) == 1) {
          graph.addOne(i, graph.get(i).toSet.flatten + j)
        }
        j += 1
      }
      i += 1
    }

    val circles = scala.collection.mutable.ArrayBuffer.empty[Set[Int]]
    isConnected.indices.foreach(
      i => if (!circles.exists(_.exists(_ == i))) circles.addOne(dfs(graph.toMap, i))
    )

    circles.size
  }
}

object Solution2 {
  def findCircleNum(isConnected: Array[Array[Int]]): Int = {
    val n = isConnected.length
    val visited = Array.fill(n)(false)

    def dfs(city: Int): Unit = {
      for (neighbor <- 0 until n) {
        if (isConnected(city)(neighbor) == 1 && !visited(neighbor)) {
          visited(neighbor) = true
          dfs(neighbor)
        }
      }
    }

    var provinces = 0

    for (i <- 0 until n) {
      if (!visited(i)) {
        provinces += 1
        visited(i) = true
        dfs(i)
      }
    }
    provinces
  }
}

Solution2.findCircleNum(Array(Array(1, 1, 0), Array(1, 1, 0), Array(0, 0, 1)))
Solution2.findCircleNum(Array(Array(1, 0, 0), Array(0, 1, 0), Array(0, 0, 1)))