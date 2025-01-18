

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
    var result: List[List[Int]] = Nil
    def dfs(node: TreeNode, sum: Int, acc: List[Int]): Unit = {
      if (node != null) {
        val newSum = sum - node.value
        if (newSum == 0 && node.right == null && node.left == null) {
          result = (node.value :: acc) :: result
        } else {
          dfs(node.right, newSum, node.value :: acc)
          dfs(node.left, newSum, node.value :: acc)
        }
      }
    }
    dfs(root, targetSum, Nil)
    result.map(_.reverse)
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
    new TreeNode(13),
    new TreeNode(4,
      new TreeNode(5),
      new TreeNode(1)
    )
  )
)

val tree2 =  new TreeNode(1, new TreeNode(2))

val tree3 =  new TreeNode(1, new TreeNode(2), new TreeNode(3))

Solution.pathSum(tree1, 22) // List(List(5, 4, 11, 2), List(5, 8, 4, 5))
Solution.pathSum(tree2, 1)  // Nil
Solution.pathSum(tree3, 5)  // Nil