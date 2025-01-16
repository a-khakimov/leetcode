import scala.annotation.tailrec

/**
 * Definition for a binary tree node.
 */

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def maxDepth(root: TreeNode): Int = {
    if (root == null) 0
    else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
  }
}

val tree = new TreeNode()

Solution.maxDepth(tree)