//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文字母组成 
// 1 <= k <= 10⁵ 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 👍 720 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution395 {
    public int longestSubstring(String s, int k) {
        // 递归最基本的是记住递归函数的含义（务必牢记函数定义）：
        // 本题的 longestSubstring(s, k) 函数表示的就是题意，即求一个最长的子字符串的长度，
        // 该子字符串中每个字符出现的次数都最少为 kk。函数入参 ss 是表示源字符串；kk 是限制条件，即子字符串中每个字符最少出现的次数；
        // 函数返回结果是满足题意的最长子字符串长度。

        // 递归的终止条件（能直接写出的最简单case）：如果字符串 s 的长度少于 k，那么一定不存在满足题意的子字符串，返回 0；

        // 调用递归（重点）：
        // 如果一个字符 c 在 s 中出现的次数少于 k 次，那么 s 中所有的包含 c 的子字符串都不能满足题意。
        // 所以，应该在 s 的所有不包含 c 的子字符串中继续寻找结果：把 s 按照 c 分割（分割后每个子串都不包含 c），得到很多子字符串 t；
        // 下一步要求 t 作为源字符串的时候，它的最长的满足题意的子字符串长度（到现在为止，我们把大问题分割为了小问题(s → t)）。
        // 此时我们发现，恰好已经定义了函数 longestSubstring(s, k) 就是来解决这个问题的！所以直接把 longestSubstring(s, k)
        // 函数拿来用，于是形成了递归。

        // 未进入递归时的返回结果：如果 s 中的每个字符出现的次数都大于 k 次，那么 s 就是要求的字符串，直接返回该字符串的长度


        // 如果存在某个字符ch出现次数大于 0 且小于 k，则任何包含ch的子串都不可能满足要求
        // 将字符串按照ch切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int counter = map.get(s.charAt(i));
                map.put(s.charAt(i), counter+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() < k) {
                String[] string_list = s.split(String.valueOf(entry.getKey()));
                List<Integer> temp_res = new ArrayList<>();
                for (String temp: string_list) {
                    temp_res.add(longestSubstring(temp, k));
                }
                return Collections.max(temp_res);
            }
        }

        return s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
