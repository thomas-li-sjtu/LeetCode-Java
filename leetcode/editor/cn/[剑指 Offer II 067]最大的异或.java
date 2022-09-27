//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
// 
// 
//
// 
//
// 注意：本题与主站 421 题相同： https://leetcode-cn.com/problems/maximum-xor-of-two-
//numbers-in-an-array/ 
// Related Topics 位运算 字典树 数组 哈希表 👍 45 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
package editor.cn;

class Solutionofferii67 {
    // 定义前缀树
    class TrieNode{
        TrieNode[] next;
        public TrieNode(){
            next = new TrieNode[2];
        }
    }
    // 前缀树根节点
    private TrieNode trie;

    public int findMaximumXOR(int[] nums) {
        // 记录异或最大值
        int maxXOR = Integer.MIN_VALUE;
        // 构建前缀树：将所有数都插入前缀树中。
        buildTrie(nums);
        // 查询每个数异或的最大值
        for(int num : nums){
            maxXOR = Math.max(maxXOR, searchMaxXOR(num));
        }
        // 返回最终异或的最大值
        return maxXOR;
    }

    private void buildTrie(int[] nums){
        // 初始化前缀树的根节点
        trie = new TrieNode();
        // 将所有数都插入前缀树
        for(int num : nums){
            TrieNode cur = trie;
            // 这里也可以是 31，但由于 nums 中的数都是正数，第32位是标记位肯定都为0，异或后的结果为0，所以就不考虑这一位了。
            for(int i = 30; i >= 0; i--){
                int d = num >> i & 1;
                if(cur.next[d] == null){
                    cur.next[d] = new TrieNode();
                }
                cur = cur.next[d];
            }
        }
    }

    private int searchMaxXOR(int num){
        TrieNode cur = trie;
        // 与 num 异或值最大的数
        int xorNum = 0;

        for(int i = 30; i >= 0; i--){
            // d : num 当前"二进制位"
            int d = num >> i & 1;
            // 获取 与 d 相反的二进制位，由于 d 不是 0 就是 1
            // 当 d = 0, (d-1) * -1 = 1 ; 当 d = 1, (d - 1) * -1 = 0;
            int theOther = (d - 1) * -1;
            // 由于异或要最大，则尽量走与 num 当前二进制位 d 相反的一位，
            // 如果相反的一位为空，则只好走相同的一位了。
            if(cur.next[theOther] == null){
                cur = cur.next[d];
                xorNum = xorNum * 2 + d; // 记录走的路径，走的路径就是最后与 num 异或最大的数
            }else{
                cur = cur.next[theOther];
                xorNum = xorNum * 2 +theOther;
            }
        }
        // 返回 num 异或的最大值
        return num ^ xorNum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
