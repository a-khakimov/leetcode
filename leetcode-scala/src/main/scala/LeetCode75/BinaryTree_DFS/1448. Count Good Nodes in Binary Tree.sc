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
  def goodNodes(root: TreeNode): Int = {
    def dfs(node: TreeNode, max: Int): Int = {
      if (node == null) 0 else {
        val isGood = if (node.value >= max) 1 else 0
        val newMax = Math.max(max, node.value)
        isGood + dfs(node.left, newMax) + dfs(node.right, newMax)
      }
    }
    dfs(root, Int.MinValue)
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


val tree2 = new TreeNode(4, new TreeNode(3), new TreeNode(2))
val tree3 = new TreeNode(
  2,
  null,
  new TreeNode(
    4,
    new TreeNode(10),
    new TreeNode(
      8,
      null,
      new TreeNode(4)
    )
  )
)

Solution.goodNodes(tree3)