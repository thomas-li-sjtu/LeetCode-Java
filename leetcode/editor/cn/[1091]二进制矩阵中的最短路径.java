//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 208 👎 0

package editor.cn;


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length-1][grid[0].length-1] != 0) {
            return -1;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> steps = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<int[]> dirs = new ArrayList<int[]>() {{
            add(new int[]{-1, -1});
            add(new int[]{-1, 0});
            add(new int[]{-1, 1});
            add(new int[]{0, -1});
            add(new int[]{0, 1});
            add(new int[]{1, -1});
            add(new int[]{1, 0});
            add(new int[]{1, 1});
        }};

        queue.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        set.add(new ArrayList<>(Arrays.asList(0, 0)));
        while (!queue.isEmpty()) {
            List<Integer> cur_pos = queue.poll();
            int cur_row = cur_pos.get(0), cur_column = cur_pos.get(1), cur_step = cur_pos.get(2);
            if (cur_row == grid.length-1 && cur_column == grid[0].length-1) {
                steps.add(cur_step);
            } else {
                for (int[] dir : dirs) {
                    int x = dir[0]+cur_row, y = dir[1]+cur_column;
                    if (
                            x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                            && !set.contains(new ArrayList<>(Arrays.asList(x, y))) && grid[x][y] == 0
                    ) {
                        set.add(new ArrayList<>(Arrays.asList(x, y)));
                        queue.add(new ArrayList<>(Arrays.asList(x, y, cur_step+1)));
                    }
                }
            }
        }

        if (steps.isEmpty()) {
            return -1;
        } else {
            return Collections.min(steps);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
