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
}