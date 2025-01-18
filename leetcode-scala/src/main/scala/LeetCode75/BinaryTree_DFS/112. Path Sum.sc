

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
    def dfs(node: TreeNode, sum: Int): Boolean = {
      if (node == null) false else {
        val newSum = sum - node.value
        if (newSum == 0 && node.right == null && node.left == null) true
        else dfs(node.left, newSum) || dfs(node.right, newSum)
      }
    }
    dfs(root, targetSum)
  }
}

val tree1 = new TreeNode(5,
  new TreeNode(4,
    new TreeNode(11,
      new TreeNode(7),
      new TreeNode(2)
    )
  ),
  new TreeNode(8,
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

val tree2 =  new TreeNode(1, new TreeNode(2))

val tree3 =  new TreeNode(1, new TreeNode(2), new TreeNode(3))

Solution.hasPathSum(tree1, 22) // true
Solution.hasPathSum(tree2, 1) // false
Solution.hasPathSum(tree3, 5) // false


