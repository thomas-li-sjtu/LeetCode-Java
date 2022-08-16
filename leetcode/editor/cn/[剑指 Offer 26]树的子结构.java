//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 👍 618 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.ArrayList;
import java.util.List;


class Solutionoffer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return A == B;
        if (A.val == B.val && dfs(A, B))
            return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean dfs(TreeNode root, TreeNode B) {
        if (root == null || B == null)
            return B == null;
        return (root.val == B.val) && dfs(root.left, B.left) && dfs(root.right, B.right);
        //注意 最后一句不是每个语句都要执行判断，当出现否的时候 直接跳出，& 则需要全部判断，&&不需要
    }
}
//leetcode submit region end(Prohibit modification and deletion)
