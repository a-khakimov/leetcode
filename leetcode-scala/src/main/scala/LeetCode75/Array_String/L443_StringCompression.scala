package LeetCode75.Array_String

object L443_StringCompression extends App {
  object Solution {
    def compress(chars: Array[Char]): Int = {
      var stack = List.empty[Char]
      var answer = List.empty[String]
      chars.foreach {
        char => {

          stack.headOption.foreach {
            c =>
              if (c != char) {
                answer = s"${stack.head}${if (stack.size != 1) stack.size.toString else ""}" :: answer
                stack = List.empty[Char]
              }
          }

          stack = char :: stack

          println(s"<- [$char] answer=${answer.mkString} stack=${stack.mkString}")
        }
      }

      stack.headOption.foreach { _ =>
        answer = s"${stack.head}${if (stack.size != 1) stack.size.toString else ""}" :: answer
      }

      val result = answer.reverse.mkString
      result.indices.foreach(i => chars(i) = result(i))

      println(s"<- [end] result=${result}")
      result.length
    }
  }

  println(Solution.compress(Array("a","a","b","b","c","c","c").map(_.head)))
  println(Solution.compress(Array("a","b","c","c","c").map(_.head)))
  println(Solution.compress(Array("a").map(_.head)))
}
