//给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
//
// 
//
// 注意：本题与主站 132 题相同： https://leetcode-cn.com/problems/palindrome-partitioning-
//ii/ 
// Related Topics 字符串 动态规划 👍 43 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;
class Solutionofferii94 {
    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j == 1)
                        dp[j][i] = 1;
                    else
                        dp[j][i] = dp[j+1][i-1] == 1 ? 1: 0;
                }
            }
        }

        int[] dpCut = new int[s.length()];
        Arrays.fill(dpCut, dpCut.length-1);
        dpCut[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (dp[0][i] == 1)
                dpCut[i] = 0;
            else {
                for (int j = i; j >= 1; j--) {
                    if (dp[j][i] == 1)
                        dpCut[i] = Math.min(dpCut[j-1] + 1, dpCut[i]);
                }
            }
        }
        return dpCut[dpCut.length-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
