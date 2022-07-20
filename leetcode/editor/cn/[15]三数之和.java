//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4997 👎 0

package editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        /*  通过改索引去除重复项
        List<List<Integer>> res = new ArrayList<>();

        int length = nums.length;
        if (length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    int cur_left = nums[left];
                    while (left < length && cur_left == nums[left]) {
                        left += 1;
                    }
                    int cur_right = nums[right];
                    while (right > -1 && cur_right == nums[right]) {
                        right -= 1;
                    }
                } else if (nums[left] + nums[right] > target) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }

        return res;
         */

        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        int length = nums.length;
        if (length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++) {
            int target = -nums[i];
            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    set.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left += 1;
                    right -= 1;
                } else if (nums[left] + nums[right] > target) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }

        }

        res.addAll(set);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
