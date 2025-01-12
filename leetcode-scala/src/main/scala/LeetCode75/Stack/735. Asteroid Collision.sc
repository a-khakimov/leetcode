object Solution {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    val stack = scala.collection.mutable.Stack.empty[Int]
    for (asteroid <- asteroids) {
      if (asteroid > 0) {
        stack.push(asteroid)
      } else {
        while (stack.nonEmpty && stack.top > 0 && stack.top < -asteroid) {
          stack.pop()
        }
        if (stack.nonEmpty && stack.top == -asteroid) {
          println(s"top=${stack.top} asteroid=$asteroid")
          stack.pop()
        } else if (stack.isEmpty || stack.top < 0) {
          stack.push(asteroid)
        }
      }
    }
    stack.toArray.reverse
  }
}

Solution.asteroidCollision(Array(5,10,-5)) // [5,10]
Solution.asteroidCollision(Array(8,-8)) // []
Solution.asteroidCollision(Array(10,2,-5)) // [10]
Solution.asteroidCollision(Array(-2,-1,1,2)) // [-2,-1,1,2]
Solution.asteroidCollision(Array(-3,-2,-1,1,2,3)) // [-3,-2,-1,1,2,3]
Solution.asteroidCollision(Array(3,2,1,-1,-2,-3)) // []
Solution.asteroidCollision(Array(-2,2,-1,-2)) // [-2]

