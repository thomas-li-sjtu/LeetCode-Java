//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 1084 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution40 {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();

        Arrays.sort(candidates);

        dfs(0, candidates.length, target, new ArrayList<>(), 0, candidates);

        return res;
    }

    public void dfs(int begin, int end, int target, List<Integer> temp, int curSum, int[] candidates) {
        if (curSum == target) {
            res.add(new ArrayList<>(temp));
        } else if (curSum > target) {
            return;
        } else {
            for (int i = begin; i < end; i++) {
                if (i > begin && candidates[i] == candidates[i - 1]) {  // 要理解这里和前面的排序，是如何能去重的
                    continue;
                }
                temp.add(candidates[i]);
                dfs(i + 1, end, target, temp, curSum + candidates[i], candidates);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
