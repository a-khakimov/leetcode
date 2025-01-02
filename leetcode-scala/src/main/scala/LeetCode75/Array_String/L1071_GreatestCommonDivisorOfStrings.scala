package LeetCode75.Array_String

import scala.annotation.tailrec

/*
Задача состоит в том, чтобы найти наибольшую строку \( x \), которая является делителем для двух данных строк \( str1 \) и \( str2 \).

### Что значит "строка делит другую строку"?
- Говорят, что строка \( t \) делит строку \( s \), если \( s \) можно представить как результат многократного конкатенирования \( t \) (то есть \( t \) повторяется несколько раз, чтобы составить \( s \)).

### Пример:
1. **Для строк \( str1 = "ABCABC" \) и \( str2 = "ABC" \):**
   - \( "ABC" \) делит \( "ABCABC" \), так как \( "ABCABC" = "ABC" + "ABC" \).
   - \( "ABC" \) делит саму себя.
   - Наибольшая строка, которая делит обе строки — это \( "ABC" \).

2. **Для строк \( str1 = "ABABAB" \) и \( str2 = "ABAB" \):**
   - \( "AB" \) делит обе строки, так как:
     - \( "ABABAB" = "AB" + "AB" + "AB" \),
     - \( "ABAB" = "AB" + "AB" \).
   - Наибольшая строка, которая делит обе строки, — \( "AB" \).

3. **Для строк \( str1 = "LEET" \) и \( str2 = "CODE" \):**
   - Здесь нет ни одной строки \( x \), которая делила бы обе строки. Поэтому результат — пустая строка \( "" \).

### Задача:
- Вход: две строки \( str1 \) и \( str2 \).
- Выход: строка \( x \), которая:
  1. Делит обе строки \( str1 \) и \( str2 \).
  2. Является наибольшей по длине среди всех таких строк.

Если такой строки не существует, вернуть пустую строку.

### Ограничения:
- Длина строк \( str1 \) и \( str2 \) находится в диапазоне от 1 до 1000 символов.
- Строки состоят только из заглавных английских букв.
 */

object L1071_GreatestCommonDivisorOfStrings extends App {
  object Solution {
    @tailrec private def gcdCalc(a: Int, b: Int): Int = { // алгоритм Евклида
      if (b == 0) a else gcdCalc(b, a % b)
    }

    def gcdOfStrings(str1: String, str2: String): String = {
      val gcd = gcdCalc(str1.length, str2.length)
      val candidate = str1.take(gcd)

      if (str1 == candidate * (str1.length / gcd) && str2 == candidate * (str2.length / gcd)) {
        candidate
      } else ""
    }
  }

  println(Solution.gcdOfStrings("ABCABC", "ABC"))    // "ABC"
  println(Solution.gcdOfStrings("ABABAB", "ABAB"))   // "AB"
  println(Solution.gcdOfStrings("LEET", "CODE"))     // ""
  println(Solution.gcdOfStrings("ABABABAB", "ABAB")) // "ABAB"
  println(Solution.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX")) // "TAUXX"
}
