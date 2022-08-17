//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 600 👎 0


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashSet<String> curList;

    public String[] permutation(String s) {
        curList = new HashSet<>();

        back(0, s.toCharArray());
        return curList.toArray(new String[0]);
    }

    public void back(int start, char[] curRes) {
        if (start == curRes.length) {
            curList.add(String.valueOf(curRes));
        }
        for (int i = start; i < curRes.length; i++) {
            char temp = curRes[i];
            curRes[i] = curRes[start];
            curRes[start] = temp;

            back(start+1, curRes.clone());

            temp = curRes[i];
            curRes[i] = curRes[start];
            curRes[start] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
