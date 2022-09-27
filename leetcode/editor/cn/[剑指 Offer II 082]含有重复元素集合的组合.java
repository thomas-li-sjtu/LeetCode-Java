//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
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
//
// 
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
// Related Topics 数组 回溯 👍 27 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solutionofferii82 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);

        search(candidates, 0, candidates.length, 0, target, new ArrayList<>());
        return res;
    }

    public void search(int[] candidates, int start, int end, int curSum, int target, List<Integer> curRes) {
        if (curSum == target) {
            System.out.println(curRes.toString());
            List<Integer> temp = new ArrayList<>(curRes);
            res.add(temp);
        } else {
            if (curSum > target) {
                return;
            }
            for (int i = start; i < end; i++) {
                if (i > start && candidates[i] == candidates[i-1])
                    continue;
                curRes.add(candidates[i]);
                search(candidates, i+1, end, curSum + candidates[i], target, curRes);
                curRes.remove(curRes.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
