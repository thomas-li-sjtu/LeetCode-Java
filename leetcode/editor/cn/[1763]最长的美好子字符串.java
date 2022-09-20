//当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 
//'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。 
//
// 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "YazaAay"
//输出："aAa"
//解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
//"aAa" 是最长的美好子字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "Bb"
//输出："Bb"
//解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。 
//
// 示例 3： 
//
// 
//输入：s = "c"
//输出：""
//解释：没有美好子字符串。 
//
// 示例 4： 
//
// 
//输入：s = "dDzeE"
//输出："dD"
//解释："dD" 和 "eE" 都是最长美好子字符串。
//由于有多个美好子字符串，返回 "dD" ，因为它出现得最早。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含大写和小写英文字母。 
// 
// Related Topics 位运算 哈希表 字符串 分治 滑动窗口 👍 175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;
class Solution1763 {

    List<String> res = new ArrayList<>();

    public String longestNiceSubstring(String s) {
        split(s);
        int max_length = -1;

        if (res.size() == 0)
            return "";
        else {
            for (String temp: res) {
                max_length = Math.max(temp.length(), max_length);
            }
            for (String temp: res) {
                if (max_length == temp.length())
                    return temp;
            }
            return "";
        }
    }

    public void split(String s) {
        Set<Character> charSet = new HashSet<>();
        Set<Character> unmatch = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
        }
        for (char ch: charSet) {
            if (ch >= 'a' && ch <= 'z') {
                if (!charSet.contains((char) ('A' + (ch - 'a')))) {
                    unmatch.add(ch);
                }
            } else {
                if (!charSet.contains((char) ('a' + (ch - 'A')))) {
                    unmatch.add(ch);
                }
            }
        }

        if (unmatch.size() == 0) {
            res.add(s);
        } else {
            List<String> candidate = new ArrayList<>();
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                if (unmatch.contains(s.charAt(i))) {
                    if (!s.substring(start, i).equals(""))
                        candidate.add(s.substring(start, i));
                    start = i+1;
                }
            }
            if (start != s.length())
                candidate.add(s.substring(start));
            System.out.println(candidate.toString());
            if (candidate.size() != 0) {
                for (String temp: candidate) {
                    split(temp);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
