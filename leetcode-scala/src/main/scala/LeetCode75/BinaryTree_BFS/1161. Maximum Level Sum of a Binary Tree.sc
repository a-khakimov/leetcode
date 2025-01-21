
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  import scala.collection.mutable
  def maxLevelSum(root: TreeNode): Int = {
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
    array.map(_.sum).zipWithIndex.maxBy(a => a._1)._2 + 1
  }
}


val tree1 = new TreeNode(1,
  new TreeNode(7,
    new TreeNode(7),
    new TreeNode(-8),
  ),
  new TreeNode(0)
)

Solution.maxLevelSum(tree1)