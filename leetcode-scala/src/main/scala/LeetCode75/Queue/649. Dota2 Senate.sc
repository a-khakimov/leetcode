object Solution {
  def predictPartyVictory(senate: String): String = {
    val rq = scala.collection.mutable.Queue.empty[Int]
    val dq = scala.collection.mutable.Queue.empty[Int]
    val len = senate.length
    var i = 0

    while (i < len) {
      if (senate(i) == 'R') rq.addOne(i) else dq.addOne(i)
      i += 1
    }

    while (rq.nonEmpty && dq.nonEmpty) {
      val r = rq.dequeue()
      val d = dq.dequeue()
      if (r < d) rq.addOne(len + r) else dq.addOne(len + d)
    }

    if (rq.nonEmpty) "Radiant" else "Dire"
  }
}


Solution.predictPartyVictory("RD") // "Radiant"
Solution.predictPartyVictory("RDD") // "Dire"
Solution.predictPartyVictory("DDRRR") // "Dire"

