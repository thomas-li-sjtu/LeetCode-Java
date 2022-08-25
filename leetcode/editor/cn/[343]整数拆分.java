//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics 数学 动态规划 👍 875 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.ArrayList;
import java.util.List;

class Solution343 {
    public int integerBreak(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);

        if (n <= 5) {
            return list.get(n - 2);
        }

        int temp = n % 3;
        if (temp == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (temp == 2) {
            return (int) Math.pow(3, n / 3) * 2;
        } else {
            return (int) Math.pow(3, n / 3 - 1) * 4;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
