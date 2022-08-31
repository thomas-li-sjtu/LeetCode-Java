//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。 
//
// 每分钟，如果节点满足以下全部条件，就会被感染： 
//
// 
// 节点此前还没有感染。 
// 节点与一个已感染节点相邻。 
// 
//
// 返回感染整棵树需要的分钟数。 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
// 
//
// 示例 2： 
//
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 每个节点的值 互不相同 
// 树中必定存在值为 start 的节点 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 23 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
package editor.cn;

import java.util.*;

class Solution2385 {
    static class tuple {
        int layer;
        TreeNode node;

        tuple(int layer, TreeNode node) {
            this.layer = layer;
            this.node = node;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();  // 存储无向图

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);

        TreeNode startNode = new TreeNode();

        while (!deque.isEmpty()) {
            TreeNode curElement = deque.removeFirst();

            List<TreeNode> curList;
            if (map.containsKey(curElement))
                curList = map.get(curElement);
            else
                curList = new ArrayList<>();

            if (curElement.left != null)
                curList.add(curElement.left);
            if (curElement.right != null)
                curList.add(curElement.right);
            map.put(curElement, curList);

            if (curElement.left != null) {
                List<TreeNode> leftList = new ArrayList<>();
                leftList.add(curElement);
                map.put(curElement.left, leftList);
                deque.addLast(curElement.left);
            }
            if (curElement.right != null) {
                List<TreeNode> rightList = new ArrayList<>();
                rightList.add(curElement);
                map.put(curElement.right, rightList);
                deque.addLast(curElement.right);
            }
            if (curElement.val == start)
                startNode = curElement;
        }

        int res = 0;
        Deque<tuple> tuple_deque = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        tuple_deque.add(new tuple(0, startNode));

        while (!tuple_deque.isEmpty()) {
            tuple curElement = tuple_deque.removeFirst();
            res = Math.max(res, curElement.layer);

            visited.add(curElement.node);

            List<TreeNode> nextLayer = map.get(curElement.node);
            for (TreeNode node : nextLayer) {
                if (!visited.contains(node)) {
                    tuple_deque.addLast(new tuple(curElement.layer + 1, node));
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
