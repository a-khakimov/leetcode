object Solution {
  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    val occurrences = arr.zipWithIndex.groupBy(_._1).map { case (k, v) => v.map(_._2).length }
    occurrences.size == occurrences.toSet.size
  }
}

Solution.uniqueOccurrences(Array(1,2,2,1,1,3)) // true
Solution.uniqueOccurrences(Array(1,2)) // false
Solution.uniqueOccurrences(Array(3,5,-2,-3,-6,-6)) // false
Solution.uniqueOccurrences(Array(-3,0,1,-3,1,1,1,-3,10,0)) // true