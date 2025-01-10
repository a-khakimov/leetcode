object Solution {

  private def occurrences(word: String): Map[Char, Int] = {
    word
      .zipWithIndex
      .groupBy(_._1)
      .map { case (k, v) => k -> v.map(_._2).length }
  }

  def closeStrings(word1: String, word2: String): Boolean = {
    val occ1 = occurrences(word1)
    val occ2 = occurrences(word2)
    (occ1.keys == occ2.keys) && (occ1.values.toList.sorted == occ2.values.toList.sorted)
  }
}

Solution.closeStrings("abc", "bca") // true
Solution.closeStrings("a", "aa") // false
Solution.closeStrings("cabbba", "abbccc") // true
Solution.closeStrings("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff") // false