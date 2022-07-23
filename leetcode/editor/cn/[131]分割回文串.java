//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 1207 👎 0
package editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution131 {
    private List<List<String>> res;
    private int[][] cur_dp;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        cur_dp = new int[s.length() + 1][s.length() + 1];

        for (int i = 1; i < s.length() + 1; i++) {
            cur_dp[i][i] = 1;
        }

        for (int j = 1; j < s.length() + 1; j++) {
            for (int i = 1; i < j; i++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if (j - i > 2) {
                        if (cur_dp[i + 1][j - 1] == 1) {
                            cur_dp[i][j] = 1;
                        }
                    } else {
                        cur_dp[i][j] = 1;
                    }
                }
            }
        }

        search(1, s.length() + 1, new ArrayList<>(), s);
        return res;
    }

    public void search(int start, int end, List<String> cur_res, String s) {
        if (start == end) {
            res.add(new ArrayList<>(cur_res));
        } else {
            int[] cur_char_dp = cur_dp[start];
            for (int i = start; i < end; i++) {
                if (cur_char_dp[i] == 1) {
                    cur_res.add(s.substring(start - 1, i));
                    search(i + 1, end, cur_res, s);
                    cur_res.remove(cur_res.size() - 1);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
