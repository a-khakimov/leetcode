

/**
 * Definition for singly-linked list.
 */

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object Solution {
  import scala.annotation.tailrec

  def len(head: ListNode): Int = {
    @tailrec def go(node: ListNode, acc: Int): Int = {
      if (node.next == null) acc + 1
      else go(node.next, acc + 1)
    }
    go(head, 0)
  }

  def deleteMiddle(head: ListNode): ListNode = {
    val llen = len(head)
    @tailrec def go(node: ListNode, curPos: Int): Unit = {
      if (curPos == llen / 2 - 1) {
        node.next = node.next.next
      } else go(node.next, curPos + 1)
    }
    if (head.next == null) null
    else {
      go(head, 0)
      head
    }
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

val list = ListNode(1)
Solution.len(list)

Solution.pprint(list)
val nl = Solution.deleteMiddle(list)
Solution.pprint(nl)
