//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1126 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution77 {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        List<Integer> target = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            target.add(i);
        }

        dfs(0, target.size(), new ArrayList<>(), target, k);
        return res;
    }

    public void dfs(int begin, int end, List<Integer> cur, List<Integer> target, int k) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = begin; i < end; i++) {
                cur.add(target.get(i));
                dfs(i+1, end, cur, target, k);
                cur.remove(cur.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
