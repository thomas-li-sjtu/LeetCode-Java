//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
// Related Topics 贪心 数组 动态规划 排序 👍 776 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int res = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                res += 1;
                end = Math.min(end, intervals[i][1]);
            } else {
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
