//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
// Related Topics 树状数组 线段树 数组 动态规划 👍 654 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int dp_max = 0;
        int[] dp = new int[nums.length];
        int[] counter = new int[nums.length];
        dp[0] = 1;
        counter[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max == -1 ? 1 : max;

            int cur_counter = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] - 1 == dp[j]) {
                    cur_counter += counter[j];
                }
            }
            if (cur_counter == 0) {
                counter[i] = 1;
            } else {
                counter[i] = cur_counter;
            }
        }

        for (int i = 0; i < nums.length; i++)
            dp_max = Math.max(dp_max, dp[i]);

        int res = 0;
        for (int i = 0; i < counter.length; i++) {
            if (dp_max == dp[i]) {
                res += counter[i];
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
