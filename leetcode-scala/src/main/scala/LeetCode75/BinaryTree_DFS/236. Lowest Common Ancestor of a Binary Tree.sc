/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  // quick first solution - todo: make it better
  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    var lca: TreeNode = null
    def dfs(node: TreeNode): (Boolean, Boolean) = {
      if (node != null) {
        //println(s"[${node.value}]")
        val foundP = node.value == p.value
        val foundQ = node.value == q.value
        val (frp, frq) = dfs(node.right)
        val (flp, flq) = dfs(node.left)

        // this is pzdc)
        val found = {
          if (frp && frq) { lca = node; true }
          else if (flp && flq) { lca = node; true }
          else if (frp && flq) { lca = node; true }
          else if (flp && frq) { lca = node; true }
          else if (frp && (node.value == q.value)) { lca = node; true }
          else if (flp && (node.value == q.value)) { lca = node; true }
          else if (frq && (node.value == p.value)) { lca = node; true }
          else if (flq && (node.value == p.value)) { lca = node; true }
          else false
        }

        if (found) (false, false) else (foundP || frp || flp, foundQ || frq || flq)
      } else (false, false)
    }
    dfs(root)
    lca
  }
}


val tree1 = new TreeNode(3,
  new TreeNode(5,
    new TreeNode(6),
    new TreeNode(7)
  ),
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

Solution.lowestCommonAncestor(tree1, new TreeNode(11), new TreeNode(10)).value // 11
Solution.lowestCommonAncestor(tree1, new TreeNode(8), new TreeNode(10)).value // 11
Solution.lowestCommonAncestor(tree1, new TreeNode(7), new TreeNode(8)).value // 11