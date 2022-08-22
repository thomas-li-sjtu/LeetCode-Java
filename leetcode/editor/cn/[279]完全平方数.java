//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 广度优先搜索 数学 动态规划 👍 1441 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution279 {
    public int numSquares(int n) {
        List<Integer> square = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            if (isSquare(i)) {
                dp.add(1);
                square.add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                for (Integer integer : square) {
                    temp.add(dp.get(i - integer - 1));
                }
                dp.add(Collections.min(temp) + 1);
            }
        }

        return dp.get(n - 1);
    }

    public boolean isSquare(int n) {
        return (int) Math.sqrt(n) - Math.sqrt(n) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
