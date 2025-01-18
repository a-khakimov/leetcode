

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def pathSum(root: TreeNode, targetSum: Int): Int = {
    var result = 0
    def dfs(node: TreeNode, tail: List[Int]): Unit = {
      if (node != null) {
        val path = node.value :: tail
        val len = path.length
        var sum: Long = 0
        var i = 0
        while (i < len) {
          sum += path(i)
          if (sum == targetSum) {
            result += 1
          }
          i += 1
        }
        if (node.right != null || node.left != null) {
          dfs(node.right, path)
          dfs(node.left, path)
        }
      }
    }
    dfs(root, Nil)
    result
  }
}

val tree1 = new TreeNode(10,
  new TreeNode(5,
    new TreeNode(3,
      new TreeNode(3),
      new TreeNode(-2)
    ),
    new TreeNode(2,
      new TreeNode(1)
    )
  ),
  new TreeNode(-3, new TreeNode(11))
)

val tree2 =  new TreeNode(1, new TreeNode(2))
val tree3 =  new TreeNode(1, new TreeNode(2), new TreeNode(3))
val tree4 =  new TreeNode(1)
val tree5 =  new TreeNode(
  1000000000,
  new TreeNode(
    1000000000,
    new TreeNode(
      294967296,
      new TreeNode(
        1000000000,
        new TreeNode(
          1000000000,
          new TreeNode(
            1000000000
          )
        )
      )
    )
  )
)


Solution.pathSum(tree1, 8) // 3
Solution.pathSum(tree2, 1) // 1
Solution.pathSum(tree3, 1) // 1
Solution.pathSum(tree4, 1) // 1
Solution.pathSum(tree5, 0) // 0