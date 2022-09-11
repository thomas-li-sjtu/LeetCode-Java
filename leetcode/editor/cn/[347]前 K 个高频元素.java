//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1316 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

import java.util.*;

class Solution347 {

    static class Tuple {
        int num;
        int counter;
        public Tuple(int num, int counter) {
            this.num = num;
            this.counter = counter;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Tuple> heap = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.counter - o2.counter;
            }
        });

        for (int i : nums) {
            if (map.containsKey(i)) {
                int value = map.get(i);
                map.put(i, value + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (heap.size() < k) {
                heap.add(new Tuple(entry.getKey(), entry.getValue()));
            } else {
                if (entry.getValue() > heap.peek().counter) {
                    heap.poll();
                    heap.add(new Tuple(entry.getKey(), entry.getValue()));
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
