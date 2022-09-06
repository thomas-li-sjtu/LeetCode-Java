//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 386 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionoffer56II {
    public int singleNumber(int[] nums) {
        // 字典
        // 排序，目标数字前后的数字和它不同
        // 位运算：只需要修改求余数值 mm ，即可实现解决 除了一个数字以外，其余数字都出现 mm 次 的通用问题
        int[] counts = new int[32];  // 存储二进制位上为1的数目（倒序）
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;  // num最后一位是否为1（此时num不是原先的num，而是经过移位的num）
                num >>>= 1;  // nums向右移位
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {  // 利用 左移操作 和 或运算 ，可将 counts 数组中各二进位的值恢复到数字 res 上
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
