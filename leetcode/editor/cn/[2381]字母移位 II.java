//给你一个小写英文字母组成的字符串 s 和一个二维整数数组 shifts ，其中 shifts[i] = [starti, endi, directioni]
// 。对于每个 i ，将 s 中从下标 starti 到下标 endi （两者都包含）所有字符都进行移位运算，如果 directioni = 1 将字符向后移位，
//如果 directioni = 0 将字符向前移位。 
//
// 将一个字符 向后 移位的意思是将这个字符用字母表中 下一个 字母替换（字母表视为环绕的，所以 'z' 变成 'a'）。类似的，将一个字符 向前 移位的意思
//是将这个字符用字母表中 前一个 字母替换（字母表是环绕的，所以 'a' 变成 'z' ）。 
//
// 请你返回对 s 进行所有移位操作以后得到的最终字符串。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
//输出："ace"
//解释：首先，将下标从 0 到 1 的字母向前移位，得到 s = "zac" 。
//然后，将下标从 1 到 2 的字母向后移位，得到 s = "zbd" 。
//最后，将下标从 0 到 2 的字符向后移位，得到 s = "ace" 。 
//
// 示例 2: 
//
// 输入：s = "dztz", shifts = [[0,0,0],[1,1,1]]
//输出："catz"
//解释：首先，将下标从 0 到 0 的字母向前移位，得到 s = "cztz" 。
//最后，将下标从 1 到 1 的字符向后移位，得到 s = "catz" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, shifts.length <= 5 * 10⁴ 
// shifts[i].length == 3 
// 0 <= starti <= endi < s.length 
// 0 <= directioni <= 1 
// s 只包含小写英文字母。 
// 
// Related Topics 数组 字符串 前缀和 👍 8 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solution2381 {
    static class Difference {

        /**
         * 差分数组
         */
        private final int[] diff;

        /**
         * 初始化差分数组
         *
         * @param nums nums
         */
        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /**
         * 对区间 [i, j] 增加 val（val 可为负数）
         *
         * @param i   i
         * @param j   j
         * @param val val
         */
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        /**
         * 复原操作
         *
         * @return res
         */
        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

    public String shiftingLetters(String s, int[][] shifts) {
        Difference diff = new Difference(new int[s.length()]);
        for (int[] shift : shifts) {
            diff.increment(shift[0], shift[1], shift[2] == 1 ? 1 : -1);
        }
        int[] res = diff.result();
        char[] cur = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int c = cur[i] - 'a';
            c = ((c + res[i]) % 26 + 26) % 26;
            cur[i] = (char) (c + 'a');
        }
        return new String(cur);
    }
//    一般的模拟方法，超时
//    public String shiftingLetters(String s, int[][] shifts) {
//
//        StringBuilder builder = new StringBuilder(s);
//        for (int[] shift : shifts) {
//            int left = shift[0];
//            int right = shift[1];
//            int dir = shift[2];
//            for (int j = left; j <= right; j++) {
//                int c = builder.charAt(j) - 'a';
//                if (dir == 0) {
//                    c = ((c - 1) % 26 + 26) % 26;
//                } else {
//                    c = (c + 1) % 26;
//                }
//                builder.setCharAt(j, (char) (c + 'a'));
//            }
//        }
//        return builder.toString();
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
