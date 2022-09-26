//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）： 
//
// 
// nums.length == n 
// nums[i] 是 正整数 ，其中 0 <= i < n 
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1 
// nums 中所有元素之和不超过 maxSum 
// nums[index] 的值被 最大化 
// 
//

// 返回你所构造的数组中的 nums[index] 。 
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// 
//
// 示例 2： 
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= maxSum <= 10⁹ 
// 0 <= index < n 
// 
// Related Topics 贪心 二分查找 👍 41 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solution1802 {
    public int maxValue(int n, int index, int maxSum) {
        long l = 0, r = maxSum;
        //因为数组中所有的数均为正整数，所以减去n，剩余的表示可以填的数
        maxSum -= n;
        while (l < r) {
            //m表示index指向位置的高度
            long m = l + r + 1 >> 1;

            //计算当index的位置高度为m时，数组所有元素的和
            long count = m * m;
            //如果左边越界，就减去左边多的
            if (m > index) count -= (m - index - 1) * (m - index) / 2;
            //如果右边越界，就减去右边多的
            if (m > (n - index)) count -= (m - (n - index - 1) - 1) * (m - (n - index - 1)) / 2;

            //二分法判断
            if (count > maxSum) r = m - 1;
            else l = m;
        }
        return (int) l + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
