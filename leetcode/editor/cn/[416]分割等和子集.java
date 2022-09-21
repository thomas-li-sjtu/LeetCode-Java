//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1452 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.Arrays;

class Solution416 {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        int[][] dp = new int[target+1][nums.length];
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] <= target) {
                dp[nums[j]][j] = 1;
            }
        }

        for (int i = 1; i < target+1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i-nums[j] >= 0 && dp[i - nums[j]][j-1] == 1 || dp[i][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (dp[target][j] == 1)
                return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
