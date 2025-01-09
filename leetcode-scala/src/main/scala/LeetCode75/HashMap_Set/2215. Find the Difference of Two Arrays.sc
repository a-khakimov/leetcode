object Solution {
  def findDifference(nums1: Array[Int], nums2: Array[Int]): List[List[Int]] = {
    val s1 = nums1.toSet
    val s2 = nums2.toSet
    List(s1.diff(s2).toList, s2.diff(s1).toList)
  }
}

Solution.findDifference(Array(1,2,3), Array(2,4,6))
Solution.findDifference(Array(1,2,3,3), Array(1,1,2,2))