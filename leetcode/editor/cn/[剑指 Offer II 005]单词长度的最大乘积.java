//给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语
//的小写字母。如果没有不包含相同字符的一对字符串，返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。 
//
// 示例 2: 
//
// 
//输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 
//输入: words = ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= words.length <= 1000 
// 1 <= words[i].length <= 1000 
// words[i] 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-
//lengths/ 
// Related Topics 位运算 数组 字符串 👍 104 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionofferii5 {
    public int maxProduct(String[] words) {
        int res = 0;
        StringBuilder[] binWord = new StringBuilder[words.length];
        for (int i = 0; i < words.length; i++) {
            int cur = 0;
            for (int j = 0; j < words[i].length(); j++) {
                cur |= 1 << words[i].charAt(j) - 'a';
            }
            binWord[i] = new StringBuilder(Integer.toBinaryString(cur)).reverse();
        }

        for (int i = 0; i < binWord.length - 1; i++) {
            for (int j = i + 1; j < binWord.length; j++) {
                int pos = 0;
                boolean flag = true;
                while (pos < binWord[i].length() && pos < binWord[j].length()) {
                    if (binWord[i].charAt(pos) == '1' && binWord[j].charAt(pos) == '1') {
                        flag = false;
                        break;
                    }
                    pos += 1;
                }
                if (flag) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
