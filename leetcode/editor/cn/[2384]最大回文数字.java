//给你一个仅由数字（0 - 9）组成的字符串 num 。 
//
// 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。 
//
// 注意： 
//
// 
// 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。 
// 数字可以重新排序。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：num = "444947137"
//输出："7449447"
//解释：
//从 "444947137" 中选用数字 "4449477"，可以形成回文整数 "7449447" 。
//可以证明 "7449447" 是能够形成的最大回文整数。
// 
//
// 示例 2： 
//
// 
//输入：num = "00009"
//输出："9"
//解释：
//可以证明 "9" 能够形成的最大回文整数。
//注意返回的整数不应含前导零。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10⁵ 
// num 由数字（0 - 9）组成 
// 
// Related Topics 贪心 哈希表 字符串 👍 12 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;


class Solution2384 {
    public String largestPalindromic(String num) {
        // 定义暂存数组
        int[] dig = new int[10];
        StringBuilder s = new StringBuilder();

        // 统计各个数字出现的次数
        for (int i = 0; i < num.length(); i++) {
            dig[num.charAt(i) - '0']++;
        }
        // 从9开始遍历各个数字
        for (int i = 9; i >= 0; i--) {
            // 如果是偶数个，依次一个i，0最后填入
            if ((dig[i] > 0 && dig[i] % 2 == 0 && i != 0) ||
                    (i == 0 && s.length() != 0 && dig[i] > 0 && dig[i] % 2 == 0)) {
                while (dig[i] != 0) {
                    s.append(i);
                    dig[i] -= 2;
                }
            }
            // 如果是奇数个，依次填入i，直到为1，0最后填入
            if ((dig[i] > 1 && dig[i] % 2 == 1 && i != 0) ||
                    (i == 0 && s.length() != 0 && dig[i] > 1 && dig[i] % 2 == 1)) {
                while (dig[i] != 1) {
                    s.append(i);
                    dig[i] -= 2;
                }
            }
        }

        // 反转字符串
        StringBuilder sReverse = new StringBuilder(s).reverse();
        // 填入单个的数字
        for (int i = 9; i >= 0; i--) {
            if (dig[i] == 1) {
                s.append(i);
                break;
            }
        }
        // 加上之前反转的字符串
        s.append(sReverse);
        return s.length() == 0 ? "0" : s.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
