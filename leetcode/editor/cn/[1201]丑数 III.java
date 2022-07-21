//给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。 
//
// 丑数是可以被 a 或 b 或 c 整除的 正整数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, a = 2, b = 3, c = 5
//输出：4
//解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3, c = 4
//输出：6
//解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
// 
//
// 示例 3： 
//
// 
//输入：n = 5, a = 2, b = 11, c = 13
//输出：10
//解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
// 
//
// 示例 4： 
//
// 
//输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
//输出：1999999984
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, a, b, c <= 10^9 
// 1 <= a * b * c <= 10^18 
// 本题结果在 [1, 2 * 10^9] 的范围内 
// 
// Related Topics 数学 二分查找 数论 👍 110 👎 0

package editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = 1, r = (long) 2e9;
        while (l < r) {
            long mid = l + r >> 1;
            if (count(a, b, c, mid) >= n)
                r = mid; // 这里只能去>=,因为要取从左往右第一个
            else
                l = mid + 1;
        }
        return (int) l;
    }

    private long count(long a, long b, long c, long x) // 求<=mid的丑数个数
    {
        return x / a + x / b + x / c - x / gcd(a, b) - x / gcd(b, c) - x / gcd(a, c) + x / gcd(a, gcd(b, c));
    }

    private long gcd(long a, long b) //最小公倍数
    {
        return a * (b / _gcd(a, b));
    }

    private long _gcd(long a, long b) //最大公约数
    {
        return b == 0 ? a : _gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
