//给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。 
//
// 在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 
//。 
//
// 给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 
//1 。 
//
// 返回存在长度 恰好 为 m 的 一组 1 的最后步骤。如果不存在这样的步骤，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,5,1,2,4], m = 1
//输出：4
//解释：
//步骤 1："00100"，由 1 构成的组：["1"]
//步骤 2："00101"，由 1 构成的组：["1", "1"]
//步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
//步骤 4："11101"，由 1 构成的组：["111", "1"]
//步骤 5："11111"，由 1 构成的组：["11111"]
//存在长度为 1 的一组 1 的最后步骤是步骤 4 。 
//
// 示例 2： 
//
// 输入：arr = [3,1,5,4,2], m = 2
//输出：-1
//解释：
//步骤 1："00100"，由 1 构成的组：["1"]
//步骤 2："10100"，由 1 构成的组：["1", "1"]
//步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
//步骤 4："10111"，由 1 构成的组：["1", "111"]
//步骤 5："11111"，由 1 构成的组：["11111"]
//不管是哪一步骤都无法形成长度为 2 的一组 1 。
// 
//
// 示例 3： 
//
// 输入：arr = [1], m = 1
//输出：1
// 
//
// 示例 4： 
//
// 输入：arr = [2,1], m = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n == arr.length 
// 1 <= n <= 10^5 
// 1 <= arr[i] <= n 
// arr 中的所有整数 互不相同 
// 1 <= m <= arr.length 
// 
// Related Topics 数组 二分查找 模拟 👍 60 👎 0
package editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1562 {
    public int findLatestStep(int[] arr, int m) {
        int len = arr.length;
        int[] t = new int[len + 2];
        int ret = -1;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int x = arr[i];
            int left = t[x - 1];
            int right = t[x + 1];
            if (left == m)
                cnt -= 1;
            if (right == m)
                cnt -= 1;
            int cur = left + right + 1;
            if (cur == m)
                cnt += 1;
            t[x - left] = cur;
            t[x + right] = cur;
            if (cnt > 0) {
                ret = i + 1;
            }
        }
        return ret;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
