//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 345 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionoffer65 {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;  // 有进位加法
            a = a ^ b;  // 无进位加法
            b = carry;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
