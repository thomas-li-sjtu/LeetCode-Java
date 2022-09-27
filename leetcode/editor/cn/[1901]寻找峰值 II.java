//一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。 
//
// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置
// [i,j] 。 
//
// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。 
//
// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法 
//
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 10⁵ 
// 任意两个相邻元素均不相等. 
// 
// Related Topics 数组 二分查找 矩阵 👍 50 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solution1901 {
    // 返回行最大值的列号
    public int maxOfRow(int[][] mat, int row) {
        if (row < 0 || row >= mat.length) {
            return -1;
        }
        int col = 0;
        for (int i = 1; i < mat[row].length; i++) {
            if (mat[row][i] > mat[row][col]) {
                col = i;
            }
        }
        return col;
    }

    public int[] findPeakGrid(int[][] mat) {
        int top = 0;
        int down = mat.length - 1;
        int mid;
        // m1 mid前一行最大值列号，m2:mid最大值列号，m3:mid+1行最大值列号
        int m1, m2, m3;
        int v1, v2, v3; //中间三行对应的最大值
        while (top <= down) {
            mid = (top + down) / 2;
            //System.out.printf("%d %d %d\n",top,mid,down);
            m2 = maxOfRow(mat, mid);
            if (top == down) {
                return new int[]{mid, m2};
            }
            m1 = maxOfRow(mat, mid - 1);
            m3 = maxOfRow(mat, mid + 1);

            v1 = mid - 1 >= 0 ? mat[mid - 1][m1] : -1;
            v2 = mat[mid][m2];
            v3 = mid + 1 < mat.length ? mat[mid + 1][m3] : -1;
            // 中间行最大，直接顶峰
            if (v2 > v3 && v2 > v1) {
                return new int[]{mid, m2};
            }
            // mid-1行最大
            if (v1 > v3 && v1 >= v2) {
                down = mid - 1;
            } else {
                // mid+1行最大
                top = mid + 1;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
