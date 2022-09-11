//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution47 {
    private List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
        Set<Integer> set = new HashSet<>();

        for (int i = begin; i < end; i++) {  // 取第i个数作为开头
            // 当这个数已经做过开头了，则跳过
            if (set.contains(target.get(i))) {
                continue;
            }
            set.add(target.get(i));

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
