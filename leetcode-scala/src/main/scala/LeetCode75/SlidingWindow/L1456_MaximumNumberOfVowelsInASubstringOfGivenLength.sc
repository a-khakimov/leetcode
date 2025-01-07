object Solution {
  private val vowels = "aeiouAEIOU"

  def maxVowels(s: String, k: Int): Int = {
    var start = 0
    var end = k
    val len = s.length

    var sum = 0
    while (start < k) {
      if (vowels.contains(s(start))) {
        sum += 1
      }
      start += 1
    }
    var answer = sum
    start = 0

    while (end < len) {
      start += 1
      end += 1
      if (vowels.contains(s(start - 1))) {
        sum -= 1
      }
      if (vowels.contains(s(end - 1))) {
        sum += 1
      }
      answer = Math.max(sum, answer)
    }

    answer
  }
}

println(Solution.maxVowels("abciiidef", 3))
