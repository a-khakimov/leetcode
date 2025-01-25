object Solution {
  def dfs(graph: Map[Int, List[Int]], start: Int, visited: Set[Int] = Set()): Set[Int] = {
    if (visited.contains(start)) visited
    else graph.getOrElse(start, Nil).foldLeft(visited + start)(
      (acc, neighbor) => dfs(graph, neighbor, acc)
    )
  }

  def canVisitAllRooms(rooms: List[List[Int]]): Boolean = {
    val graph = rooms.zipWithIndex.map(r => r._2 -> r._1).toMap
    val visited = dfs(graph, 0)
    visited.size == graph.size
  }
}

Solution.canVisitAllRooms(List(List(1), List(2), List(3), Nil))
Solution.canVisitAllRooms(List(List(1, 3), List(3, 0, 1), List(2), List(0)))