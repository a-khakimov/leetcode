package LeetCode75.Array_String

object L151_ReverseWordsInAString extends App {
  object Solution {
    def reverseWords(s: String): String = {
      s.split(" ").view.filterNot(_.isEmpty).toList.reverse.mkString(" ")
    }
  }

  println(Solution.reverseWords("the sky is blue")) // "blue is sky the"
  println(Solution.reverseWords("  hello world  ")) // "world hello"
  println(Solution.reverseWords("a good   example")) // "example good a"
}
