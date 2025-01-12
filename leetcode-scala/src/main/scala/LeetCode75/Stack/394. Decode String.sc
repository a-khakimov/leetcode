object Solution {
  def decodeString(s: String): String = {
    val stack = scala.collection.mutable.Stack.empty[String]
    for (c <- s) {
      if (c != ']') {
        stack.push(c.toString)
      } else {
        var s = ""
        while (stack.top != "[") {
          s += stack.pop()
        }
        stack.pop()
        var n = ""
        while (stack.nonEmpty && stack.top.toIntOption.nonEmpty) {
          n = stack.pop() + n
        }
        stack.push(s * n.toInt)
      }
    }
    stack.mkString.reverse
  }
}


Solution.decodeString("3[a]2[bc]")      // "aaabcbc"
Solution.decodeString("3[a2[c]]")       // "accaccacc"
Solution.decodeString("2[abc]3[cd]ef")  // "abcabccdcdcdef"

