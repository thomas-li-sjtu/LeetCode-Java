//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 369 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution49 {
    public int nthUglyNumber(int n) {
        List<Long> res = new ArrayList<>();
        res.add(1L);

        PriorityQueue<Long> queue_2 = new PriorityQueue<>();
        queue_2.add(2L);
        PriorityQueue<Long> queue_3 = new PriorityQueue<>();
        queue_3.add(3L);
        PriorityQueue<Long> queue_5 = new PriorityQueue<>();
        queue_5.add(5L);

        for (int i = 1; i < n; i++) {
            long threshold = res.get(res.size() - 1);
            long q2 = queue_2.poll();
            long q3 = queue_3.poll();
            long q5 = queue_5.poll();

            while (q2 <= threshold) {
                q2 = queue_2.poll();
            }
            while (q3 <= threshold) {
                q3 = queue_3.poll();
            }
            while (q5 <= threshold) {
                q5 = queue_5.poll();
            }

            long min = q2;
            if (q3 < min) {
                min = q3;
            }
            if (q5 < min) {
                min = q5;
            }

            res.add(min);
            queue_2.add(min * 2);
            queue_3.add(min * 3);
            queue_5.add(min * 5);
            if (q2 > min) {
                queue_2.add(q2);
            }
            if (q3 > min) {
                queue_3.add(q3);
            }
            if (q5 > min) {
                queue_5.add(q5);
            }
        }
        long out = res.get(res.size() - 1);
        return (int) out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
