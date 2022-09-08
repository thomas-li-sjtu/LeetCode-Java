//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 👍 472 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solutionoffer60 {
    public double[] dicesProbability(int n) {
        int[][] dp = new int[n][n*6];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < (i+1)*6; j++) {
                int sum = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0) {
                        sum += dp[i-1][j-k];
                    }
                }
                dp[i][j] = sum;
            }
        }
        int sum = 0;
        List<Integer> last = new ArrayList<>();
        for (int i : dp[dp.length-1]) {
            if (i != 0) {
                last.add(i);
                sum += i;
            }
        }
        double[] res = new double[last.size()];
        for (int i = 0; i < last.size(); i++) {
            res[i] = last.get(i) / (sum+0.0);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
