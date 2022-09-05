//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 
//输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组 不为空 的情况下，1 ≤ k ≤ nums.length。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 488 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solutionoffer59 {
    class tuple {
        int index;
        int value;

        public tuple(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    // 优先队列内部是按照比较器返回的结果进行处理的，一般认为a,b比较结果大于0，就是a大于b，等于0就是a等于b；小于0就是a小于b。
    // 当比较n1,n2的时候，如果结果大于0(也就是默认的n1-n2>0)，那么要把n1下沉(默认的小根堆)
    // 改成n2-n1的时候，结果大于0，证明n2大于n1,但还是n1（值较小的元素）下沉，于是这个堆就成了大根堆
    // PriorityQueue会在比较结果大于0的时候把第一个数下沉
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<tuple> cur_tuple = new PriorityQueue<>((tuple t1, tuple t2) -> t2.value - t1.value);
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            cur_tuple.offer(new tuple(i, nums[i]));
        }
        res[0] = cur_tuple.peek().value;
        for (int i = k; i < nums.length; i++) {
            cur_tuple.offer(new tuple(i, nums[i]));
            tuple cur_top = cur_tuple.peek();
            while (cur_top.index <= i - k) {
                cur_tuple.poll();
                cur_top = cur_tuple.peek();
            }
            res[i - k + 1] = cur_top.value;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
