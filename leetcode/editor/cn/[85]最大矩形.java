//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1356 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int len = matrix[0].length;
        int ans = 0;
        int[] height = new int[len];
        for (char[] s : matrix) {
            for (int i = 0; i < len; ++i) {
                height[i] = s[i] == '1' ? height[i] + 1 : 0;
            }
            ans = Math.max(largestRectangleArea(height), ans);
        }
        return ans;
    }

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
