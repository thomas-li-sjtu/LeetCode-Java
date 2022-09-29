//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。
//
// 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//

// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 269 题相同： https://leetcode-cn.com/problems/alien-dictionary/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 127 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;
import java.util.*;
class Solutionofferii114 {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int[] d = new int[26];

        out:
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
            if(i < words.length - 1) {
                for(int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                    char c1 = words[i].charAt(j), c2 = words[i + 1].charAt(j);
                    if(c1 != c2) {
                        List<Character> nxt = graph.getOrDefault(c1, new ArrayList<>());
                        nxt.add(c2);
                        graph.put(c1, nxt);
                        d[c2 - 'a']++;  // c2的入度
                        continue out;
                    }
                }
                if(words[i].length() > words[i + 1].length()) {
                    return "";
                }
            }
        }
        // 度为0的字符
        StringBuilder sb = new StringBuilder();
        for(char c: set) {
            if(d[c - 'a'] == 0) {
                sb.append(c);
            }
        }
        for(int i = 0;i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(graph.containsKey(c)) {
                for(char nxt: graph.get(c)) {
                    if(--d[nxt - 'a'] == 0) {
                        sb.append(nxt);
                    }
                }
            }
        }
        return sb.length() == set.size() ? sb.toString() : "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
