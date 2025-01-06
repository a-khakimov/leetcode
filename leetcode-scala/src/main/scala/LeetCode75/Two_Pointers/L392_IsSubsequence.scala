package LeetCode75.Two_Pointers

object L392_IsSubsequence extends App {
  object Solution {
    def isSubsequence(s: String, t: String): Boolean = {
      val slen = s.length
      val tlen = t.length
      var i = 0
      var k = 0
      while (i < tlen && k < slen) {
        if (t(i) == s(k)) {
          k = k + 1
        }
        i = i + 1
      }
      k == slen
    }
  }

  println(Solution.isSubsequence("abc", "ahbgdc"))
  println(Solution.isSubsequence("abc", "ahbgdg"))
}
