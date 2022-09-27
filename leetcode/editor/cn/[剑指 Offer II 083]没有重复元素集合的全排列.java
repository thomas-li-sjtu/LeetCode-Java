//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 👍 32 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solutionofferii83 {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        search(0, nums.length, nums);
        return res;
    }

    public void search(int start, int end, int[] nums) {
        if (start == end) {
            List<Integer> temp = new ArrayList<>();
            for (int i: nums)
                temp.add(i);
            res.add(temp);
        } else {
            for (int i = start; i < end; i++) {
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;

                search(start+1, end, nums);

                temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
