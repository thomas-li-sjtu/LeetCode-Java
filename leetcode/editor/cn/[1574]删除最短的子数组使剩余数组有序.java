//给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。 
//
// 一个子数组指的是原数组中连续的一个子序列。 
//
// 请你返回满足题目要求的最短子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,10,4,2,3,5]
//输出：3
//解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
//另一个正确的解为删除子数组 [3,10,4] 。 
//
// 示例 2： 
//
// 
//输入：arr = [5,4,3,2,1]
//输出：4
//解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,2,3]
//输出：0
//解释：数组已经是非递减的了，我们不需要删除任何元素。
// 
//
// 示例 4： 
//
// 
//输入：arr = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 0 <= arr[i] <= 10^9 
// 
// Related Topics 栈 数组 双指针 二分查找 单调栈 👍 86 👎 0
package editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        // [0...left]有序
        if (left == n - 1) {
            return 0;
        }
        // [right...n-1]有序
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // 完全删除一边[left+1, n-1], 或者[0...right - 1]
        int result = Math.min(n - left - 1, right);

        // 左边和右边各保留一部分
        int i = 0, j = right;

        while (i <= left && j <= n - 1) {
            if (arr[i] <= arr[j]) {
                // [0...i] 和 [j...n-1] 有序, 删除 [i+1...j-1]
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                // 小的+1
                j++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
