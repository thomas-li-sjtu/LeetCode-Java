//给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: [0,1,1]
//解释: 
//0 --> 0
//1 --> 1
//2 --> 10
// 
//
// 示例 2: 
//
// 
//输入: n = 5
//输出: [0,1,1,2,1,2]
//解释:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
// 
//
// 说明 : 
//
// 
// 0 <= n <= 10⁵ 
// 
//
// 
//
// 进阶: 
//
// 
// 给出时间复杂度为 O(n*sizeof(integer)) 的解答非常容易。但你可以在线性时间 O(n) 内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为 O(n) 。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount ）来执行此操作。 
// 
//
// 
//
// 注意：本题与主站 338 题相同：https://leetcode-cn.com/problems/counting-bits/ 
// Related Topics 位运算 动态规划 👍 101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionofferii3 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res[1] = 1;
            return res;
        }

        res[1] = 1;
        for (int i = 2; i < n+1; i++) {
            if (i % 2 == 0) {
                res[i] = res[i/2];
            } else {
                res[i] = res[i >> 1] + 1;
            }
        }
        return res;
        // O(n*sizeof(integer))
        // int[] res = new int[n+1];
        // for (int i = 1; i < n+1; i++) {
        //     int counter = 0;
        //     String s = Integer.toBinaryString(i);
        //     for (int j = 0; j < s.length(); j++) {
        //         if (s.charAt(j) == '1') {
        //             counter += 1;
        //         }
        //     }
        //     res[i] = counter;
        // }
        // return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
