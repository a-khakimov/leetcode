object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var i = digits.length - 1
    while (i >= 0) {
      if (digits(i) < 9) {
        digits(i) += 1
        return digits
      }
      digits(i) = 0
      i -= 1
    }
    Array(1) ++ digits
  }
}

Solution.plusOne(Array(8))