object Solution {
  def largestAltitude(gain: Array[Int]): Int = {
    val len = gain.length
    var altitude = 0
    var i = 0
    var answer = 0
    while (i < len) {
      altitude += gain(i)
      answer = Math.max(answer, altitude)
      i += 1
    }
    answer
  }
}


println(Solution.largestAltitude(Array(-5,1,5,0,-7))) // 1
println(Solution.largestAltitude(Array(-4,-3,-2,-1,4,3,2))) // 0
println(Solution.largestAltitude(Array(44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81))) // 781
