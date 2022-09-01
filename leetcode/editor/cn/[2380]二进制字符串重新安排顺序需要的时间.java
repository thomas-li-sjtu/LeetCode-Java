//给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。 
//
// 请你返回完成这个过程所需要的秒数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0110101"
//输出：4
//解释：
//一秒后，s 变成 "1011010" 。
//再过 1 秒后，s 变成 "1101100" 。
//第三秒过后，s 变成 "1110100" 。
//第四秒后，s 变成 "1111000" 。
//此时没有 "01" 存在，整个过程花费 4 秒。
//所以我们返回 4 。
// 
//
// 示例 2： 
//
// 
//输入：s = "11100"
//输出：0
//解释：
//s 中没有 "01" 存在，整个过程花费 0 秒。
//所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 要么是 '0' ，要么是 '1' 。 
// 
//
// 
//
// 进阶： 
//
// 你能以 O(n) 的时间复杂度解决这个问题吗？ 
// Related Topics 字符串 动态规划 模拟 👍 11 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solution2380 {
    public int secondsToRemoveOccurrences(String s) {
        int counter = 0;
        StringBuilder builder = new StringBuilder(s);

        while (true) {
            int flag = 0;
            for (int i = 0; i < builder.length(); i++) {
                if (i + 1 < builder.length()) {
                    if (builder.substring(i, i + 2).equals("01")) {
                        flag = 1;

                        builder.replace(i, i + 2, "10");
                        i = i + 1;
                    }
                }
            }
            if (flag == 0) {
                break;
            }

            counter += 1;
        }
        return counter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
