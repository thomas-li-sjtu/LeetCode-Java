//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
// Related Topics 贪心 数组 动态规划 👍 191 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        // 将所有数相加，记录总和，如果被三整除即可直接返回。
        // 剩下除以3余1和余2两种情况，分别讨论。
        // 如果除以3余1，可以删除最小一个余1的数，或删除最小两个余2的数；如果除以3余2，可以删除最小一个余2的数，或删除最小两个余1的数

        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        for (int i : nums) {
            if (i % 3 == 0)
                zero.add(i);
            else if (i % 3 == 1)
                one.add(i);
            else
                two.add(i);
        }
        Collections.sort(one);
        Collections.sort(two);

        int res = 0;
        for (int i : zero)
            res += i;
        for (int i : one)
            res += i;
        for (int i : two)
            res += i;

        if (res % 3 == 0) {
            return res;
        } else if (res % 3 == 1) {
            if (one.size() >= 1 && two.size() >= 2) {
                return Math.max(res - two.get(0) - two.get(1), res - one.get(0));
            } else if (one.size() == 0) {
                res = res - two.get(0) - two.get(1);
            } else {
                res = res - one.get(0);
            }
            return res;
        } else {
            if (one.size() >= 2 && two.size() >= 1) {
                return Math.max(res - one.get(0) - one.get(1), res - two.get(0));
            } else if (two.size() == 0) {
                res = res - one.get(0) - one.get(1);
            } else {
                res = res - two.get(0);
            }
            return res;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
