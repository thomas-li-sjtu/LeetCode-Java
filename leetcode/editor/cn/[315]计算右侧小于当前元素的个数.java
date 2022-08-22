//给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 
//nums[i] 的元素的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,6,1]
//输出：[2,1,1,0] 
//解释：
//5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-1]
//输出：[0,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 854 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.ArrayList;
import java.util.List;

class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> ordered = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int target = nums[i];
            int index = 0;
            if (ordered.size() == 0) {
                ordered.add(target);
            } else {
                int left = 0, right = ordered.size();
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (ordered.get(mid) < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                index = left;
                ordered.add(index, target);
            }
            res[i] = index;
        }
        List<Integer> out = new ArrayList<>();
        for (int i : res)
            out.add(i);
        return out;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
