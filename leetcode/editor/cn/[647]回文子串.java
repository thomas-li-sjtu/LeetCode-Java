//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 966 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solution647 {
    public int countSubstrings(String s) {
        int res = s.length();

        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = 1;

        for (int j = 1; j < s.length(); j++) {
            for (int i = j-1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i == 1) {
                        dp[i][j] = 1;
                        res += 1;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                        res += (dp[i][j] == 1) ? 1 : 0;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
