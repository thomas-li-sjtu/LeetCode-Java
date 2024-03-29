//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 313 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;


class Solutionoffer39 {
    public int majorityElement(int[] nums) {
        int vote = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                vote += 1;
            } else {
                vote -= 1;
                if (vote < 0) {
                    vote = 1;
                    res = nums[i];
                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
