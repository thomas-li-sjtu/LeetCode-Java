//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 字符串 👍 298 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.Arrays;
import java.util.Collections;

class Solution556 {
    public int nextGreaterElement(int n) {
        StringBuilder builder = new StringBuilder(String.valueOf(n));
        int thresDown = -1;
        for (int i = builder.length()-1; i>=1; i--) {
            if ((int) builder.charAt(i) > (int) builder.charAt(i - 1)) {
                thresDown = i-1;
                break;
            }
        }
        if (thresDown == -1) {
            return -1;
        } else {
            int thresSwitch = -1;
            for (int i = builder.length()-1; i>=thresDown; i--) {
                if ((int) builder.charAt(i) > (int) builder.charAt(thresDown)) {
                    thresSwitch = i;
                    break;
                }
            }
            char temp = builder.charAt(thresDown);
            builder.setCharAt(thresDown, builder.charAt(thresSwitch));
            builder.setCharAt(thresSwitch, temp);

            char[] subBuilder = builder.substring(thresDown+1).toCharArray();
            Arrays.sort(subBuilder);

            for (int i = 0; i < subBuilder.length; i++) {
                builder.setCharAt(thresDown+1+i, subBuilder[i]);
            }
        }
        if (Long.parseLong(builder.toString()) > Integer.MAX_VALUE) {
            return -1;
        } else {
            return Integer.parseInt(builder.toString());
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
