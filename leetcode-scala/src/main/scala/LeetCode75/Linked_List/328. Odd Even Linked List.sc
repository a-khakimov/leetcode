

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

  def reverseList(head: ListNode): ListNode = {
    var prev: ListNode = null
    var next: ListNode = null
    var cur: ListNode = head
    while (cur != null) {
      next = cur.next
      cur.next = prev
      prev = cur
      cur = next
    }
    prev
  }

  def concat(first: ListNode, second: ListNode): ListNode = {
    @tailrec def go(node: ListNode): Unit = {
      if (node.next == null) node.next = second
      else go(node.next)
    }
    go(first)
    first
  }

  def oddEvenListBad(head: ListNode): ListNode = {
    @tailrec def go(node: ListNode, odd: ListNode, even: ListNode, acc: Int): ListNode = {
      if (node.next == null) {
        concat(reverseList(odd), reverseList(even))
      } else {
        if (acc.toDouble % 2 == 0) {
          go(node.next, ListNode(node.next.x, odd), even, acc + 1)
        } else {
          go(node.next, odd, ListNode(node.next.x, even), acc + 1)
        }
      }
    }

    if (head == null || head.next == null) head
    else {
      val odd = ListNode(head.x)
      val even = ListNode(head.next.x)
      go(head.next, odd, even, 2)
    }
  }

  def oddEvenList(head: ListNode): ListNode = {
    if (head == null || head.next == null) head
    else {
      var odd: ListNode = null
      var even: ListNode = null
      var it = head
      var i: Int = 0
      while (it != null) {
        println(it.x)
        if (i.toDouble % 2 == 0 && even != null) {
          val next = even.next
          even = it

        }
        it = it.next
        i += 1
      }
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


val list1 = ListNode(2, ListNode(1, ListNode(3, ListNode(5, ListNode(6, ListNode(4, ListNode(7)))))))
val list2 = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
val list3 = ListNode(1)

Solution.pprint(list1)
val res1 = Solution.oddEvenList(list1)
Solution.pprint(res1)

Solution.pprint(list2)
val res2 = Solution.oddEvenList(null)
//Solution.pprint(res2)
