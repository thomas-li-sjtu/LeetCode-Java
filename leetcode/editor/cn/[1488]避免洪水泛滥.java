//你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨前是空的，那么它就会装满水。如果第 n 个湖泊下雨前是 满的 ，这个湖泊会发生 洪水 。你
//的目标是避免任意一个湖泊发生洪水。 
//
// 给你一个整数数组 rains ，其中： 
//
// 
// rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。 
// rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。 
// 
//
// 请返回一个数组 ans ，满足： 
//
// 
// ans.length == rains.length 
// 如果 rains[i] > 0 ，那么ans[i] == -1 。 
// 如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。 
// 
//
// 如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。 
//
// 请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生。 
//
// 
//
// 示例 1： 
//
// 
//输入：rains = [1,2,3,4]
//输出：[-1,-1,-1,-1]
//解释：第一天后，装满水的湖泊包括 [1]
//第二天后，装满水的湖泊包括 [1,2]
//第三天后，装满水的湖泊包括 [1,2,3]
//第四天后，装满水的湖泊包括 [1,2,3,4]
//没有哪一天你可以抽干任何湖泊的水，也没有湖泊会发生洪水。
// 
//
// 示例 2： 
//
// 
//输入：rains = [1,2,0,0,2,1]
//输出：[-1,-1,2,1,-1,-1]
//解释：第一天后，装满水的湖泊包括 [1]
//第二天后，装满水的湖泊包括 [1,2]
//第三天后，我们抽干湖泊 2 。所以剩下装满水的湖泊包括 [1]
//第四天后，我们抽干湖泊 1 。所以暂时没有装满水的湖泊了。
//第五天后，装满水的湖泊包括 [2]。
//第六天后，装满水的湖泊包括 [1,2]。
//可以看出，这个方案下不会有洪水发生。同时， [-1,-1,1,2,-1,-1] 也是另一个可行的没有洪水的方案。
// 
//
// 示例 3： 
//
// 
//输入：rains = [1,2,0,1,2]
//输出：[]
//解释：第二天后，装满水的湖泊包括 [1,2]。我们可以在第三天抽干一个湖泊的水。
//但第三天后，湖泊 1 和 2 都会再次下雨，所以不管我们第三天抽干哪个湖泊的水，另一个湖泊都会发生洪水。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rains.length <= 10⁵ 
// 0 <= rains[i] <= 10⁹ 
// 
// Related Topics 贪心 数组 哈希表 二分查找 堆（优先队列） 👍 97 👎 0
package editor.cn

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1488 {
    public int[] avoidFlood(int[] rains) {
        /*
        遇到可以抽水的天时，把它存起来，遇到满水湖泊需要抽水时，观察上次该湖泊满水时与当前日期之间是否有可抽水天气 ， 取最靠近上次满水的那一天
        HashMap作用 ：记录某湖泊最近一次蓄满水的日期。
        HashSet作用 ：记录某湖泊是否满水。(HashMap已经记录，这里可省略)
        TreeSet作用 ：存可以抽水的日期，用于二分查找出对某需要抽水湖泊的最佳抽水日期。
         */

        int n = rains.length;
        int[] res = new int[n];
        //初始化答案数组为-1
        Arrays.fill(res , -1);
        //数据结构作用见思路
        //HashSet<Integer> set = new HashSet<>();
        HashMap<Integer , Integer> map = new HashMap<>();
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i = 0 ; i < n ; i++){
            //可以抽水时，存日期 ，并且默认操作1号湖泊
            if(rains[i] == 0){
                tree.add(i);
                res[i] = 1;
                continue;
            }
            //湖泊为空，直接进水
            if(!map.containsKey(rains[i])){
                //当前日期为该湖泊最近满水日期
                map.put(rains[i] , i);
                //湖泊已满，记录
                //set.add(rains[i]);
                continue;
            }
            //查找对于该湖泊的最优抽水日期（离该湖泊满后最近的抽水日期）
            Integer t = tree.higher(map.get(rains[i]));
            //没有可抽水的日期，泛滥
            if(t == null) return new int[0];
            //当前日期变更为该湖泊的最近满水日期
            map.put(rains[i] , i);
            res[t] = rains[i];
            tree.remove(t);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
