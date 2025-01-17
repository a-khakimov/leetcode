import scala.annotation.tailrec

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

class TreeNode(
  _value: Int = 0,
  _left: TreeNode = null,
  _right: TreeNode = null
) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    def go(node: TreeNode, acc: List[Int]): List[Int] = {
      (Option(node.left), Option(node.right)) match
        case (Some(l), Some(r)) => go(l, acc) ++ go(r, acc)
        case (Some(node), None) => go(node, acc)
        case (None, Some(node)) => go(node, acc)
        case (None, None) => node.value :: acc
    }

    go(root1, Nil) == go(root2, Nil)
  }
}

val tree1 = new TreeNode(3,
  new TreeNode(5, new TreeNode(6), new TreeNode(7)),
  new TreeNode(1,
    new TreeNode(4),
    new TreeNode(2,
      new TreeNode(9),
      new TreeNode(11,
        new TreeNode(8),
        new TreeNode(10)
      )
    )
  )
)


val tree2 = new TreeNode(1, new TreeNode(3), new TreeNode(2))

Solution.leafSimilar(tree1, tree2)