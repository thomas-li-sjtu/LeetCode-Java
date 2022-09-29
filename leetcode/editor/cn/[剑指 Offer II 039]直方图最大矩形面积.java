//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-
//histogram/ 
// Related Topics 栈 数组 单调栈 👍 57 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionofferii39 {
    public int largestRectangleArea(int[] heights) {
        // 遍历每一个柱子，其左边界为左边比它小的元素的索引，其右边界为右边比它小的元素的索引
        // 宽度=右边界-左边界-1， 高度即当前柱子高度
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i - 1;
            int right = i + 1;
            if (heights.length * heights[i] > res){
                // 寻找左右边界
                while (left >= 0 && heights[left] >= heights[i])
                    left -= 1;
                while (right <= heights.length-1 && heights[right] >= heights[i])
                    right += 1;
            }
            res = Math.max(res, (right - left - 1) * heights[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
