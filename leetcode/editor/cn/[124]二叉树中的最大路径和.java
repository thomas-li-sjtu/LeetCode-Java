//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1660 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

package editor.cn;

class Solution124 {
    private int res = -10001;

    public int maxPathSum(TreeNode root) {
        search(root, res);
        return res;
    }

    public int search(TreeNode node, int cur_val) {
        if (node == null) {
            return 0;
        }

        int left_val = search(node.left, cur_val);
        int right_val = search(node.right, cur_val);

        res = Math.max(res, left_val + right_val + node.val);

        int node_contrib = Math.max(left_val + node.val, right_val + node.val);
        return Math.max(node_contrib, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
