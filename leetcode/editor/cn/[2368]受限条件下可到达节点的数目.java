//现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。 
//
// 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给
//你一个整数数组 restricted 表示 受限 节点。 
//
// 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。 
//
// 注意，节点 0 不 会标记为受限节点。 
//
// 
//
// 示例 1： 
//
// 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
//输出：4
//解释：上图所示正是这棵树。
//在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。 
//
// 示例 2： 
//
// 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
//
//输出：3
//解释：上图所示正是这棵树。
//在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// edges 表示一棵有效的树 
// 1 <= restricted.length < n 
// 1 <= restricted[i] < n 
// restricted 中的所有值 互不相同 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 图 数组 哈希表 👍 24 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list;
            if (map.containsKey(edge[0])) {
                list = map.get(edge[0]);
            } else {
                list = new ArrayList<>();
            }
            list.add(edge[1]);
            map.put(edge[0], list);

            if (map.containsKey(edge[1])) {
                list = map.get(edge[1]);
            } else {
                list = new ArrayList<>();
            }
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        Set<Integer> restrict = new HashSet<>();
        for (int i : restricted) {
            restrict.add(i);
        }
        Set<Integer> visited = new HashSet<>();

        int res = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        while (!deque.isEmpty()) {
            int node = deque.removeFirst();
            visited.add(node);
            res += 1;
            List<Integer> nextNodes = map.get(node);
            for (int curNode : nextNodes) {
                if (!restrict.contains(curNode) && !visited.contains(curNode)) {
                    deque.addLast(curNode);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
