/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

//  println(s"${node.value} isRight=$isRight count=$count")

object Solution {
  def longestZigZag(root: TreeNode): Int = {
    var result = 0
    def dfs(node: TreeNode, count: Int, isRight: Boolean): Unit = {
      result = Math.max(result, count)
      if (node != null) {
        dfs(node.left, if (isRight) count + 1 else 0, isRight = false)
        dfs(node.right, if (!isRight) count + 1 else 0, isRight = true)
      }
    }
    dfs(root.left, 0, isRight = false)
    dfs(root.right, 0, isRight = true)
    result
  }
}

val tree1 = {
  new TreeNode(1,
    _left = new TreeNode(2,
      _right = new TreeNode(3,
        _left = new TreeNode(4,
          _right = new TreeNode(5)
        ),
        _right = new TreeNode(4)
      )
    ),
    _right = new TreeNode(2)
  )
}

Solution.longestZigZag(tree1)