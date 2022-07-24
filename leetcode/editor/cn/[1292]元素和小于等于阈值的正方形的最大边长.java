//给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。 
//
// 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
//输出：2
//解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], 
//threshold = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 300 
// 0 <= mat[i][j] <= 10⁴ 
// 0 <= threshold <= 10⁵ 
// 
// Related Topics 数组 二分查找 矩阵 前缀和 👍 98 👎 0
package editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] prefix_sum = new int[mat.length+1][mat[0].length+1];

        int ans = 0;
        for (int i = 1; i < prefix_sum.length; i++) {
            for (int j = 1; j < prefix_sum[0].length; j++) {
                prefix_sum[i][j] = mat[i-1][j-1] - prefix_sum[i-1][j-1] + prefix_sum[i-1][j] + prefix_sum[i][j-1];
                if (i-ans >= 0 &&
                        j-ans >= 0 &&
                        prefix_sum[i][j] + prefix_sum[i-ans][j-ans] - prefix_sum[i-ans][j] - prefix_sum[i][j-ans] <= threshold
                ) {
                    ans += 1;
                }
            }
        }
        return ans-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
