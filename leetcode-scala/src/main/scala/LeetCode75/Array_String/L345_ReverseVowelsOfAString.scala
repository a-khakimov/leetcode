package LeetCode75.Array_String

object L345_ReverseVowelsOfAString extends App {

  object Solution {

    private val vowels = List('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')

    implicit class CharSyntax(c: Char) extends AnyVal {
      def isVowel: Boolean = vowels.contains(c)
    }

    def reverseVowels(s: String): String = {
      val (vowelsIndexed, consonantsIndexed) = s.zipWithIndex.partition(_._1.isVowel)
      val (vowels, indexes) = vowelsIndexed.unzip
      (consonantsIndexed ++ vowels.reverse.zip(indexes)).sortBy(_._2).map(_._1).mkString
    }
  }

  println(Solution.reverseVowels("IceCreAm")) // "AceCreIm"
  println(Solution.reverseVowels("leetcode")) // "leotcede"
}
