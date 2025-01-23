class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root == null || root.value == `val`) root else {
      if (`val` < root.value) searchBST(root.left, `val`)
      else searchBST(root.right, `val`)
    }
  }
}

val tree1 = new TreeNode(4,
  _left = new TreeNode(2,
    _left = new TreeNode(1),
    _right = new TreeNode(3),
  ),
  _right = new TreeNode(7),
)

val subTree = Solution.searchBST(tree1, 7)
subTree.value