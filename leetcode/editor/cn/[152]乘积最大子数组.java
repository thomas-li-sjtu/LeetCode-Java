//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
// Related Topics 数组 动态规划 👍 1726 👎 0
package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution152 {
    public int maxProduct(int[] nums) {
        List<Integer> dp_max = new ArrayList<>();  // 以nums[i]结尾的连续子数组乘积
        List<Integer> dp_min = new ArrayList<>();
        dp_max.add(nums[0]);
        dp_min.add(nums[0]);

        for (int i = 1; i<nums.length;i++) {
            int[] arr = {nums[i], dp_max.get(dp_max.size()-1)*nums[i], dp_min.get(dp_min.size()-1)*nums[i]};
            Arrays.sort(arr);
            dp_max.add(arr[arr.length-1]);
            dp_min.add(arr[0]);
        }

        return Collections.max(dp_max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
