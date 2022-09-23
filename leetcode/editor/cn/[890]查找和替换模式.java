//你有一个单词列表 words 和一个模式 pattern，你想知道 words 中的哪些单词与模式匹配。 
//
// 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。 
//
// （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。） 
//
// 返回 words 中与给定模式匹配的单词列表。 
//
// 你可以按任何顺序返回答案。 
//
// 
//
// 示例： 
//
// 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//输出：["mee","aqq"]
//解释：
//"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//因为 a 和 b 映射到同一个字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 50 
// 1 <= pattern.length = words[i].length <= 20 
// 
// Related Topics 数组 哈希表 字符串 👍 198 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        int charType = getCharType(pattern);
        for (String s: words) {
            if (s.length() == pattern.length() && getCharType(s) == charType) {
                Map<Character, Character> map = new HashMap<>();
                StringBuilder transfer = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char sIndex = s.charAt(i);
                    char pIndex = pattern.charAt(i);
                    if (map.containsKey(sIndex)) {
                        if (map.get(sIndex) != pIndex) {
                            break;
                        } else {
                            transfer.append(pIndex);
                        }
                    } else {
                        map.put(sIndex, pIndex);
                        transfer.append(pIndex);
                    }
                }

                if (transfer.toString().equals(pattern)) {
                    res.add(s);
                }
            }
        }
        return res;
    }

    public int getCharType(String pattern) {
        Set<Character> counter = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!counter.contains(pattern.charAt(i))) {
                counter.add(pattern.charAt(i));;
            }
        }
        return counter.size();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
