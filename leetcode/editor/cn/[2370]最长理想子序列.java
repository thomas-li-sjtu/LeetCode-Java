//给你一个由小写字母组成的字符串 s ，和一个整数 k 。如果满足下述条件，则可以将字符串 t 视作是 理想字符串 ： 
//
// 
// t 是字符串 s 的一个子序列。 
// t 中每两个 相邻 字母在字母表中位次的绝对差值小于或等于 k 。 
// 
//
// 返回 最长 理想字符串的长度。 
//
// 字符串的子序列同样是一个字符串，并且子序列还满足：可以经由其他字符串删除某些字符（也可以不删除）但不改变剩余字符的顺序得到。 
//
// 注意：字母表顺序不会循环。例如，'a' 和 'z' 在字母表中位次的绝对差值是 25 ，而不是 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "acfgbd", k = 2
//输出：4
//解释：最长理想字符串是 "acbd" 。该字符串长度为 4 ，所以返回 4 。
//注意 "acfgbd" 不是理想字符串，因为 'c' 和 'f' 的字母表位次差值为 3 。 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 3
//输出：4
//解释：最长理想字符串是 "abcd" ，该字符串长度为 4 ，所以返回 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// 0 <= k <= 25 
// s 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 动态规划 👍 21 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solution2370 {
    public int longestIdealString(String s, int k) {
        // dp(i,[0,25])代表遍历到字符串第i个位置时，以26个字母为已选子序列结尾的子序列的长度
        int n = s.length();
        int[][] dp = new int[n + 1][26];
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int c = s.charAt(i - 1) - 'a';
            int maxv = 0;
            for (int j = 0; j < 26; ++j) {
                // 遍历dp[i - 1]中以26个字符结尾的子序列长度，找到满足题目条件的最大长度
                if (Math.abs(c - j) <= k) {
                    maxv = Math.max(dp[i - 1][j], maxv);
                }
                // 其他结尾的长度直接复制过来
                dp[i][j] = dp[i - 1][j];
            }
            // 将dp[i]中当前字符位置的值更新为最大长度 + 1
            dp[i][c] = maxv + 1;
            // 记录最大长度
            ans = Math.max(ans, dp[i][c]);
        }
        return ans;

//        超时
//        int[] dp = new int[s.length()];
//        dp[0] = 1;
//        int res = 1;
//
//        for (int i = 1; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            for (int j = i-1; j >= 0; j--) {
//                char cmp = s.charAt(j);
//                if (Math.abs(ch - cmp) <= k) {
//                    dp[i] = Math.max(dp[j]+1, dp[i]);
//                    res = Math.max(res, dp[i]);
//                    break;
//                }
//            }
//            dp[i] = Math.max(dp[i], 1);
//        }
//
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
