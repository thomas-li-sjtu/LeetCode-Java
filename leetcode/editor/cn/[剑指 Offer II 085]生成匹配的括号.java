//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// 
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 👍 47 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solutionofferii85 {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate(n, 0, 0, "");
        return res;
    }

    public void generate(int n, int left, int right, String cur) {
        if (left == n && right == n) {
            res.add(cur);
        } else {
            if (left < n) {
                generate(n, left+1, right, cur+"(");
            }
            if (right < left) {
                generate(n, left, right+1, cur + ")");
            }
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
