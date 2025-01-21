import scala.collection.mutable

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  import scala.collection.mutable
  def rightSideView(root: TreeNode): List[Int] = {
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
    println(array)
    array.map(_.last).toList
  }
}

val tree1 = new TreeNode(1,
  _left = new TreeNode(2,
    _left = new TreeNode(5)
  ),
  _right = new TreeNode(3,
    _left = new TreeNode(6),
    _right = new TreeNode(4),
  )
)

Solution.rightSideView(tree1)
