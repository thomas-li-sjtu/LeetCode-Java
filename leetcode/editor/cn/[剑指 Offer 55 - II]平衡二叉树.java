//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 二叉树 👍 307 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package editor.cn;

class Solutionoffer55 {
    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return this.flag;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_balance = height(root.left);
        int right_balance = height(root.right);
        if (Math.abs(left_balance - right_balance) > 1 || !flag) {
            flag = false;
        }
        System.out.println(left_balance + " " + right_balance + " " + root.val);
        return Math.max(left_balance, right_balance) + 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
