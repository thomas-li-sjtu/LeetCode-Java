//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。 
//
// 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 👍 1830 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;


class Solution287 {
    public int findDuplicate(int[] nums) {
        // 成环，环形链表入口
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;

        // 鸽笼原理，二分查找
//        int len = nums.length; // n + 1 = len, n = len - 1
//
//        // 在 [1..n] 查找 nums 中重复的元素
//        int left = 1;
//        int right = len - 1;
//        while (left < right) {
//            int mid = (left + right) / 2;
//
//            // nums 中小于等于 mid 的元素的个数
//            int count = 0;
//            for (int num : nums) {
//                if (num <= mid) {
//                    count++;
//                }
//            }
//
//            if (count > mid) {
//                // 下一轮搜索的区间 [left..mid]
//                right = mid;
//            } else {
//                // 下一轮搜索的区间 [mid + 1..right]
//                left = mid + 1;
//            }
//        }
//        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
