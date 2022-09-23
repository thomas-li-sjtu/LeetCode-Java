//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2： 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// -10⁷ <= k <= 10⁷ 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 👍 103 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;
import java.util.*;

class Solutionofferii10 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;

        int curSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for (int num : nums) {
            curSum += num;
            if (map.containsKey(curSum - k)) {
                res += map.get(curSum - k);
            }
            if (map.containsKey(curSum)) {
                map.put(curSum, map.get(curSum) + 1);
            } else {
                map.put(curSum, 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
