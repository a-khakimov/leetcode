import scala.annotation.tailrec

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {

  def pairSum(head: ListNode): Int = {
    val stack = scala.collection.mutable.Stack.empty[Int]
    var it = head
    while (it != null) {
      stack.push(it.x)
      it = it.next
    }
    val hlen = stack.length / 2
    var i = 0
    var answer = 0
    it = head
    while (i < hlen) {
      answer = Math.max(answer, it.x + stack.pop())
      it = it.next
      i += 1
    }
    answer
  }

  def pprint(head: ListNode): Unit = {
    @tailrec def go(node: ListNode, i: Int): Unit = {
      print(s"[$i]=${node.x}, ")
      if (node.next == null) ()
      else go(node.next, i + 1)
    }

    go(head, 0)
  }
}


// val list = ListNode(5, ListNode(4, ListNode(2, ListNode(1))))
val list = ListNode(47, ListNode(22, ListNode(81, ListNode(46, ListNode(90, ListNode(92, ListNode(9, ListNode(81, ListNode(5, ListNode(9))))))))))

//47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,
//9  5, 81, 9,74,32,92,

Solution.pprint(list)
Solution.pairSum(list)
Solution.pprint(list)
