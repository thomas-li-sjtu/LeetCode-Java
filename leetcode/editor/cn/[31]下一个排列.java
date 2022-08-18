//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1859 👎 0
package editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution31 {
    public void nextPermutation(int[] nums) {
        int a = -1, b = -1;  //a: 从后往前，第一个不是倒序的数字下标；b：a以后，比a大的最小数下标
        for (int i = nums.length-1; i >= 1; i--) {
            if (nums[i-1] < nums[i]) {
                a = i-1;
                break;
            }
        }
        if (a == -1) {
            // 整个数组倒序
            List<Integer> arraylist = new ArrayList<>();
            for (int num : nums) {
                arraylist.add(num); //存放元素
            }
            Collections.reverse(arraylist); //使用方法进行逆序
            //完成逆序后,可以保存到新数组reverseArray
            for (int i = 0; i < nums.length; i++) {
                nums[i] = arraylist.get(i);
            }
        } else {
            int gap = 1000;
            for (int i = a+1; i < nums.length; i++) {
                if (nums[i] > nums[a]) {
                    if (gap >= nums[i]-nums[a]) {
                        gap = nums[i]-nums[a];
                        b = i;
                    }
                } else {
                    break;
                }
            }
            System.out.println(b);

            // 交换a到b
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            // a后面倒序
            List<Integer> arraylist = new ArrayList<>();
            for (int i = a+1; i < nums.length; i++) {
                arraylist.add(nums[i]); //存放元素
            }
            Collections.reverse(arraylist); //使用方法进行逆序
            System.out.println(arraylist.toString());
            //完成逆序后,可以保存到新数组reverseArray
            for (int i = a+1; i < nums.length; i++) {
                nums[i] = arraylist.get(i-(a+1));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
