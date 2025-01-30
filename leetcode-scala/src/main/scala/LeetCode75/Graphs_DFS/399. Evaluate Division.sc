object Solution {

  import scala.util.control.Breaks.{break, breakable}
  import scala.collection.mutable

  def calcEquation(
    equations: List[List[String]],
    values: Array[Double],
    queries: List[List[String]]
  ): Array[Double] = {
    val len = values.length
    var i = 0
    val graph = mutable.Map.empty[String, mutable.ListBuffer[(String, Double)]]
    
    while (i < len) {
      val List(var1, var2) = equations(i)
      val value = values(i)
      graph.update(var1, mutable.ListBuffer.empty[(String, Double)].addAll((var2, value) :: graph.get(var1).toList.flatten))
      graph.update(var2, mutable.ListBuffer.empty[(String, Double)].addAll((var1, 1 / value) :: graph.get(var2).toList.flatten))
      i += 1
    }

    println(graph.toMap)

    def dfs(cur: String, target: String, visited: Set[String], acc: Double): Double = {
      if (cur == target) acc
      else {
        val newVisited = visited + cur
        val nodes = graph(cur)
        var res: Double = -1
        breakable {
          for ((neighbor, value) <- nodes) {
            println(s"dfs cur=$cur target=$target acc=$acc value=$value")
            if (newVisited.contains(neighbor)) {
              res = -1
            } else {
              res = dfs(neighbor, target, newVisited, value * acc)
              if (res != -1) break()
            }
          }
        }
        res
      }
    }


    val result = scala.collection.mutable.ArrayBuffer.empty[Double]
    for (List(var1, var2) <- queries) {
      println(s"var1=$var1 var2=$var2 ")
      if (!graph.contains(var1) || !graph.contains(var2)) {
        result.addOne(-1)
      } else if (var1 == var2) {
        result.addOne(1)
      } else {
        result.addOne(dfs(var1, var2, Set.empty, 1))
      }
    }

    result.toArray
  }
}

Solution.calcEquation(
  List(List("a","b"), List("b","c")),
  Array(2.0,3.0),
  List(List("a","c"), List("b","a"), List("a","e"), List("a","a"), List("x","x"))
)