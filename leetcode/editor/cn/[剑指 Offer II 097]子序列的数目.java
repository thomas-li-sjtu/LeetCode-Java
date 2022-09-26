//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 注意：本题与主站 115 题相同： https://leetcode-cn.com/problems/distinct-subsequences/ 
// Related Topics 字符串 动态规划 👍 34 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionofferii97 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (t.charAt(0) == s.charAt(i)) {
                if (i > 0) {
                    dp[0][i] = dp[0][i - 1] + 1;
                } else {
                    dp[0][0] = 1;
                }
            } else {
                if (i > 0) {
                    dp[0][i] = dp[0][i - 1];
                }
            }
        }

        for (int i = 1; i < t.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()-1][s.length()-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
