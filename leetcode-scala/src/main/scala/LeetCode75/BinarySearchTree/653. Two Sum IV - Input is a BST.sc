import scala.annotation.tailrec

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def searchBST(root: TreeNode, node: TreeNode, value: Int): Boolean = {
    if (root == null || root.value == node.value) false
    else if (root.value == value) true
    else {
      if (value < root.value) searchBST(root.left, node, value)
      else searchBST(root.right, node, value)
    }
  }

  def findTarget(root: TreeNode, k: Int): Boolean = {
    def search(node: TreeNode): Boolean = {
      if (node == null) false else {
        val w = k - node.value
        val found = searchBST(root, node, w)
        if (!found) {
          val foundRight = search(node.right)
          if (!foundRight) search(node.left)
          else foundRight
        } else found
      }
    }
    search(root)
  }
}

val tree1 = new TreeNode(4,
  _left = new TreeNode(2,
    _left = new TreeNode(1),
    _right = new TreeNode(3),
  ),
  _right = new TreeNode(7),
)

Solution.findTarget(tree1, 10)