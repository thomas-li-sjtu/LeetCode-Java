//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2188 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;
import java.util.*;

class Solution46 {
    // 任取一个数打头，对后面n-1个数进行全排序，要求n-1个数的全排序，则要求n-2个数的全排序……
    // 直到要求的全排序只有一个数，找到出口
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();
        for (int num : nums) {
            tmp.add(num);
        }

        dfs(0, nums.length, tmp);

        return res;
    }

    public void dfs(int begin, int end, List<Integer> target) {
        if (begin == end) {
            res.add(new ArrayList<>(target));
            return;
        }
        for (int i = begin; i < end; i++) {  // 取第i个数作为开头
            int tmp = target.get(begin);
            target.set(begin, target.get(i));
            target.set(i, tmp);

            dfs(begin+1, end, target);

            tmp = target.get(begin);
            target.set(begin, target.get(i));
            target.set(i, tmp);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
