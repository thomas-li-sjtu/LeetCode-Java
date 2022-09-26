//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可
//流向大西洋 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 514 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution417 {
    class Tuple {
        int row;
        int column;

        public Tuple(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tuple tuple = (Tuple) o;
            return row == tuple.row && column == tuple.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
    int[][] map;
    int row;
    int column;
    int[][] dir;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        row = heights.length;
        column = heights[0].length;
        map = new int[row][column];

        map[0][column-1] = 2;
        map[row-1][0] = 2;

        dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Set<Tuple> visited = new HashSet();
        Deque<Tuple> stack = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            visited.add(new Tuple(i, 0));
            map[i][0] = 1;
            stack.addLast(new Tuple(i, 0));
        }
        for (int i = 0; i < column; i++) {
            visited.add(new Tuple(0, i));
            map[0][i] = 1;
            stack.addLast(new Tuple(0, i));
        }
        search(visited, stack, heights);

        visited.clear();
        stack.clear();

        if (map[row-1][column-1] == 1)
            map[row-1][column-1] = 2;
        for (int i = 0; i < row; i++) {
            visited.add(new Tuple(i, column-1));
            if (map[i][column-1] == 0) {
                map[i][column-1] = 1;
            } else if (map[i][column-1] == 1) {
                map[i][column-1] = 2;
            }
            stack.addLast(new Tuple(i, column-1));
        }
        for (int i = 0; i < column; i++) {
            visited.add(new Tuple(row-1, i));
            if (map[row-1][i] == 0) {
                map[row-1][i] = 1;
            } else if (map[row-1][i] == 1 && i != column-1) {
                map[row-1][i] = 2;
            }
            stack.addLast(new Tuple(row-1, i));
        }
        search(visited, stack, heights);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 2) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public void search(Set<Tuple> visited, Deque<Tuple> stack, int[][] heights) {
        while (!stack.isEmpty()) {
            Tuple curTuple = stack.removeFirst();
            visited.add(curTuple);

            for (int[] curDir: dir) {
                int curRow = curTuple.row + curDir[0];
                int curColumn = curTuple.column + curDir[1];
                Tuple nextTuple = new Tuple(curRow, curColumn);
                if (curRow < row && curRow >= 0
                        && curColumn < column && curColumn >= 0
                        && heights[curRow][curColumn] >= heights[curTuple.row][curTuple.column]
                        && !visited.contains(nextTuple)) {
                    map[curRow][curColumn] += 1;
                    visited.add(nextTuple);
                    stack.addLast(nextTuple);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
