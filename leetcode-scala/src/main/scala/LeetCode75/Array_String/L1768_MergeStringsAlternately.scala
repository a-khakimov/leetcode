package LeetCode75.Array_String


object L1768_MergeStringsAlternately extends App {
  object Solution {
    def mergeAlternately(word1: String, word2: String): String = {
      word1.zipAll(word2, "", "").map { case (a, b) => s"$a$b" }.mkString
    }
  }

  println(Solution.mergeAlternately("abc", "pqr12"))
}
