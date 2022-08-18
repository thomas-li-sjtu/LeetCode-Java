//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
// Related Topics 数组 哈希表 计数 排序 👍 612 👎 0
package editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        if (nums.length == 2) {
            res.add(nums[0]);
            if (nums[0] != nums[1])
                res.add(nums[1]);
            return res;
        }

        int a = nums[0], b = nums[0], cn_a = 0, cn_b = 0;
        for (int num : nums) {
            // 计数
            if (a == num) {
                cn_b++;
                // 每次匹配玩跳出本轮匹配
                continue;
            }

            // 计数
            if (b == num) {
                cn_a++;
                continue;
            }

            // 匹配新的候选人1
            if (cn_b == 0) {
                a = num;
                cn_b++;
                continue;
            }

            // 匹配新的候选热2
            if (cn_a == 0) {
                b = num;
                cn_a++;
                continue;
            }

            // 当没有匹配到当前任何候选人 并且当前候选人票数大于1时 进行票数的抵消
            cn_a--;
            cn_b--;
        }

        cn_a = 0;
        cn_b = 0;
        // 重新确认当前选取的候选人 票数是否超过指定票数。
        for (int num : nums) {
            if (a == num) cn_a++;
            else if (b == num) cn_b++;
        }

        if (cn_a > nums.length/3) {
            res.add(a);
        }
        if (cn_b > nums.length/3 && a != b) {
            res.add(b);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
