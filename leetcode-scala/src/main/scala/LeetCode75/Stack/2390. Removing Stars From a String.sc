import scala.collection.mutable

object Solution {
  def removeStars(s: String): String = {
    val stack = mutable.Stack.empty[Char]
    s.foreach(c => if (c == '*') stack.pop() else stack.push(c))
    stack.mkString.reverse
  }
}

Solution.removeStars("leet**cod*e") // "lecoe"

