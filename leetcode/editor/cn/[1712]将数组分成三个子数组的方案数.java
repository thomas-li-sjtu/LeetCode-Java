//我们称一个分割整数数组的方案是 好的 ，当它满足： 
//
// 
// 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。 
// left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。 
// 
//
// 给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 109 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1]
//输出：1
//解释：唯一一种好的分割方案是将 nums 分成 [1] [1] [1] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,2,2,5,0]
//输出：3
//解释：nums 总共有 3 种好的分割方案：
//[1] [2] [2,2,5,0]
//[1] [2,2] [2,5,0]
//[1,2] [2,2] [5,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,1]
//输出：0
//解释：没有好的分割方案。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 双指针 二分查找 前缀和 👍 79 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.ArrayList;
import java.util.List;

class Solution1712 {
    public int waysToSplit(int[] nums) {
        List<Integer> cur_sum = new ArrayList<>();
        cur_sum.add(0);

        for (int num : nums) {
            cur_sum.add(num + cur_sum.get(cur_sum.size() - 1));
        }

        long res = 0L;
        int total = cur_sum.get(cur_sum.size() - 1);

        for (int i = 1; i < cur_sum.size() - 2 && cur_sum.get(i) * 3 <= total; i++) {
            int min_thres = 0, max_thres = 0;
            int left = i + 1, right = cur_sum.size();

            // 寻找左侧边界的二分查找
            while (left < right) {
                int mid = (left + right) / 2;
                if (cur_sum.get(mid) - cur_sum.get(i) < cur_sum.get(i)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            min_thres = left;

            // 寻找右侧边界的二分查找
            left = min_thres + 1;
            right = cur_sum.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (cur_sum.get(cur_sum.size() - 1) - cur_sum.get(mid) >= cur_sum.get(mid) - cur_sum.get(i)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            max_thres = left - 1;

            if (max_thres == cur_sum.size() - 1)
                max_thres -= 1;
            if (max_thres == min_thres && cur_sum.get(cur_sum.size() - 1) - cur_sum.get(max_thres) < cur_sum.get(max_thres) - cur_sum.get(i))
                continue;

            res = (res + max_thres - min_thres + 1) % 1000000007;
        }

        return (int) res % 1000000007;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
