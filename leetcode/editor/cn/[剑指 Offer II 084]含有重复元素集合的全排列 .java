//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 👍 28 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solutionofferii84 {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            Set<Integer> visited = new HashSet<>();
            for (int i = start; i < end; i++) {
                if (visited.contains(nums[i])) {
                    continue;
                } else {
                    visited.add(nums[i]);
                }
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
