//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
// Related Topics 位运算 👍 391 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;


class Solution201 {
    public int rangeBitwiseAnd(int left, int right) {
        // 因为 只要有一个0，那么无论有多少个 1 都是 0——给定两个整数，要找到它们对应的二进制字符串的公共前缀
        // 5:0 1 0 1
        // 6:0 1 1 0
        // 7:0 1 1 1
        //-----------
        //   0 1 0 0
        int i = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            i += 1;
        }
        left <<= i;
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
