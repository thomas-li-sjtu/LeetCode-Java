//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1819 👎 0
package editor.cn;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<List<Integer>> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res += 1;

                    Deque<List<Integer>> queue = new LinkedList<>();
                    List<Integer> cur_pos = new ArrayList<>(Arrays.asList(i, j));
                    queue.add(cur_pos);
                    visited.add(cur_pos);

                    while (!queue.isEmpty()) {
                        cur_pos = queue.poll();
                        int row = cur_pos.get(0), column = cur_pos.get(1);
                        for (int[] cur : dirs) {
                            if (
                                    0 <= row + cur[0] && row + cur[0] < grid.length &&
                                            0 <= column + cur[1] && column + cur[1] < grid[0].length &&
                                            grid[row + cur[0]][column + cur[1]] == '1' &&
                                            !visited.contains(Arrays.asList(row + cur[0], column + cur[1]))
                            ) {
                                grid[row + cur[0]][column + cur[1]] = '0';
                                queue.addLast(Arrays.asList(row + cur[0], column + cur[1]));
                                visited.add(Arrays.asList(row + cur[0], column + cur[1]));
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
