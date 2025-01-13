class RecentCounter() {

  private val queue = scala.collection.mutable.Queue.empty[Int]

  def ping(t: Int): Int = {
    queue.addOne(t)
    val d = t - 3000
    queue.dequeueWhile(_ < d)
    queue.size
  }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * val obj = new RecentCounter()
 * val param_1 = obj.ping(t)
 */

val counter = new RecentCounter()
counter.ping(1)
counter.ping(100)
counter.ping(3001)
counter.ping(3002)