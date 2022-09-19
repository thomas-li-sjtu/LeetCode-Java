//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1291 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution309 {
    public int maxProfit(int[] prices) {
        List<Integer> buy = new ArrayList<>();
        buy.add(-prices[0]);
        List<Integer> sell = new ArrayList<>();
        sell.add(0);
        List<Integer> freeze = new ArrayList<>();
        freeze.add(0);

        for (int i = 1; i < prices.length; i++) {
            buy.add(Math.max(buy.get(i-1), freeze.get(i-1)-prices[i]));
            sell.add(Math.max(sell.get(i-1), buy.get(i-1) + prices[i]));
            freeze.add(sell.get(i-1));
        }
        return Math.max(buy.get(prices.length-1), Math.max(sell.get(prices.length-1), freeze.get(prices.length-1)));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
