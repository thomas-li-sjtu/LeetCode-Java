//给定一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 
//values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
//"a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
//
// 
//
// 注意：本题与主站 399 题相同： https://leetcode-cn.com/problems/evaluate-division/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 数组 最短路 👍 27 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solutionofferii111 {
    static class Tuple {
        String str;
        double value;

        public Tuple(String str, double value) {
            this.str = str;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "str='" + str + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];

        Map<String, Set<Tuple>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            double curValue = values[i];
            List<String> curEqual = equations.get(i);

            Set<Tuple> curSet;
            if (map.containsKey(curEqual.get(0))) {
                curSet = map.get(curEqual.get(0));
            } else {
                curSet = new HashSet<>();
            }
            curSet.add(new Tuple(curEqual.get(1), curValue));
            map.put(curEqual.get(0), curSet);

            Set<Tuple> curSetReverse;
            if (map.containsKey(curEqual.get(1))) {
                curSetReverse = map.get(curEqual.get(1));
            } else {
                curSetReverse = new HashSet<>();
            }
            curSetReverse.add(new Tuple(curEqual.get(0), 1/curValue));
            map.put(curEqual.get(1), curSetReverse);
        }

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            Set<String> visited = new HashSet<>();

            if (!map.containsKey(start) || !map.containsKey(end)) {
                res[i] = -1.0;
            } else {
                boolean notFound = true;

                Deque<Tuple> deque = new LinkedList<>();
                for (Tuple tuple: map.get(start)) {
                    if (tuple.str.equals(end)) {
                        res[i] = tuple.value;
                        notFound = false;
                        break;
                    }
                    deque.add(tuple);
                }
                if (!notFound) {
                    continue;
                }

                visited.add(start);

                while (!deque.isEmpty()) {
                    Tuple curTuple = deque.removeFirst();
                    if (!visited.contains(curTuple.str)) {
                        visited.add(curTuple.str);

                        double curRes = curTuple.value;
                        for (Tuple tuple: map.get(curTuple.str)) {
                            if (tuple.str.equals(end)) {
                                res[i] = curRes * tuple.value;
                                notFound = false;
                                break;
                            } else {
                                deque.addLast(new Tuple(tuple.str, curRes * tuple.value));
                            }
                        }
                    }
                }
                if (notFound) {
                    res[i] = -1.0;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
