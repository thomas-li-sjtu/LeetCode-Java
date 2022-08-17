//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
package editor.cn;

import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<String> nodeVal = new ArrayList<>();
        Deque<TreeNode> curStack = new LinkedList<>();

        curStack.addFirst(root);
        while (!curStack.isEmpty()) {
            TreeNode curNode = curStack.pollFirst();
            if (curNode == null) {
                nodeVal.add("null");
            } else {
                nodeVal.add(String.valueOf(curNode.val));
                curStack.addLast(curNode.left);
                curStack.addLast(curNode.right);
            }
        }
        for (int i = nodeVal.size() - 1; i >= 0; i--) {
            if (!nodeVal.get(i).equals("null")) {
                break;
            } else {
                nodeVal.remove(i);
            }
        }
        return "[" + String.join(",", nodeVal) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        List<String> valList = new ArrayList<>(Arrays.asList(data.substring(1, data.length() - 1).split(",")));

        TreeNode root = new TreeNode(Integer.parseInt(valList.get(0)));
        Deque<TreeNode> curDeque = new LinkedList<>();
        curDeque.addFirst(root);
        int i = 1;

        while (!curDeque.isEmpty()) {
            TreeNode curNode = curDeque.pollFirst();
            if (i >= valList.size()) {
                continue;
            }
            if (!valList.get(i).equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(valList.get(i)));
                curNode.left = leftNode;
                curDeque.addLast(leftNode);
            }
            i += 1;
            if (i >= valList.size()) {
                continue;
            }
            if (!valList.get(i).equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(valList.get(i)));
                curNode.right = rightNode;
                curDeque.addLast(rightNode);
            }
            i += 1;
        }
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
