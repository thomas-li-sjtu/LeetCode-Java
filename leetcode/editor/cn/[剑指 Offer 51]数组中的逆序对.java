//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 833 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionoffer51 {
    private int res = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        sort(nums);
        return res;
    }

    public int[] sort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int[] front = new int[nums.length/2];
        int[] end = new int[nums.length-front.length];
        System.arraycopy(nums, 0, front, 0, front.length);
        if (nums.length - front.length >= 0)
            System.arraycopy(nums, front.length, end, front.length - front.length, nums.length - front.length);
        front = sort(front);
        end = sort(end);

        int[] res = new int[nums.length];
        int startA = 0;
        int startB = 0;
        int index = 0;
        while (startA < front.length && startB < end.length) {
            if (front[startA] <= end[startB]) {
                res[index] = front[startA];
                startA += 1;
            } else {
                res[index] = end[startB];
                this.res += front.length-startA;
                startB += 1;
            }

            index += 1;
        }
        if (startA == front.length && startB != end.length) {
            for (int i = index; i < res.length; i++) {
                res[i] = end[startB];
                startB += 1;
            }
        }
        if (startB == end.length && startA != front.length) {
            for (int i = index; i < res.length; i++) {
                res[i] = front[startA];
                startA += 1;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
