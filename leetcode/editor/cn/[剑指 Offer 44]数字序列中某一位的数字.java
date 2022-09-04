//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 👍 282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionoffer44 {
    public int findNthDigit(long n) {
        if (n < 10) {
            return (int) n;
        }
        int temp = 9;
        int cur_len = 1;
        while (n > 0) {
            n -= (long) temp * Math.pow(10, cur_len-1) * cur_len;
            cur_len += 1;
        }
        cur_len -= 1;
        n += (cur_len) * 9 * Math.pow(10, cur_len-1);

        long res = (long) Math.pow(10, cur_len-1);
        long interval = n / cur_len;
        if (n - n/cur_len*cur_len == 0) {
            res += interval - 1;
            String last_num = String.valueOf(res);
            return last_num.charAt(last_num.length()-1)-'0';
        } else {
            res += interval;
            n -= n/cur_len*cur_len;
            String last_num = String.valueOf(res);
            return last_num.charAt((int) (n-1)) - '0';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
