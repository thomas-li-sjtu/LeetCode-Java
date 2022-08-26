//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。 
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
//
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
// Related Topics 贪心 数组 👍 933 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.ArrayList;
import java.util.List;

class Solution135 {
    public int candy(int[] ratings) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < ratings.length; i++)
            res.add(1);
        if (ratings.length == 1) {
            return 1;
        }
        if (ratings[0] > ratings[1]) {
            res.set(0, 2);
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res.set(i, res.get(i - 1) + 1);
            }
        }


        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res.set(i, Math.max(res.get(i + 1) + 1, res.get(i)));
            }
        }

        int sum = 0;
        for (Integer re : res) {
            sum += re;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
