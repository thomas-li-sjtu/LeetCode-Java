//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//

// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1929 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution96 {
    public int numTrees(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for(int j = 0; j < i; j++) {
                temp += res.get(j) * res.get(i-(j+1));
            }
            res.add(temp);
        }
        return res.get(res.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
