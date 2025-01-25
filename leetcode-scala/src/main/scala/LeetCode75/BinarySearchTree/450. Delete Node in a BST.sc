import scala.annotation.tailrec

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  import scala.collection.mutable
  def print(root: TreeNode): Unit = {
    val array = mutable.ArrayBuffer.empty[mutable.ArrayBuffer[Int]]
    def bfs(node: TreeNode, level: Int): Unit = {
      if (node != null) {
        if (array.size <= level) {
          array.addOne(mutable.ArrayBuffer.empty)
        }
        array(level).addOne(node.value)
        bfs(node.left, level + 1)
        bfs(node.right, level + 1)
      }
    }
    bfs(root, 0)
    array.foreach(println)
  }

  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    if (root == null) return null

    if (key < root.value) {
      root.left = deleteNode(root.left, key)
    } else if (key > root.value) {
      root.right = deleteNode(root.right, key)
    } else {
      if (root.left == null) return root.right
      if (root.right == null) return root.left
      val minNode = findMin(root.right)
      root.value = minNode.value
      root.right = deleteNode(root.right, minNode.value)
    }
    root
  }

  private def findMin(node: TreeNode): TreeNode = {
    var current = node
    while (current.left != null) {
      current = current.left
    }
    current
  }
}

val tree1 = new TreeNode(5,
  _left = new TreeNode(3,
    _left = new TreeNode(2),
    _right = new TreeNode(4),
  ),
  _right = new TreeNode(6,
    _right = new TreeNode(7)
  ),
)

Solution.print(tree1)
val subTree = Solution.deleteNode(tree1, 3)
Solution.print(subTree)