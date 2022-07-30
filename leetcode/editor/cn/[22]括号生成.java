//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
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
// Related Topics 字符串 动态规划 回溯 👍 2778 👎 0
package editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public Set<String> res;

    public Solution22 () {
        res = new HashSet<>();
    }

    public List<String> generateParenthesis(int n) {
        gen("", 0, 0, n);
        return new ArrayList<>(res);
    }

    public void gen(String cur_res, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(cur_res);
        } else {
            if (left < n) {
                gen(cur_res + "(", left+1, right, n);
            }
            if (right < n && right < left) {
                gen(cur_res + ")", left, right+1, n);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
