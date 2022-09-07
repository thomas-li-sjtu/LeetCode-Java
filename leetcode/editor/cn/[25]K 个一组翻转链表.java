//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
// Related Topics 递归 链表 👍 1772 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
package editor.cn;

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode backup = newHead;

        newHead = head;
        ListNode pre = backup;
        ListNode cur_last = newHead;

        while (cur_last != null && cur_last.next != null) {
            if (next_k(head, k)) {
                for (int i = 0; i < k-1; i++) {
                    ListNode next = cur_last.next;
                    cur_last.next = next.next;
                    next.next = null;

                    ListNode pre_next = pre.next;
                    pre.next = next;
                    next.next = pre_next;
                }
                pre = cur_last;
                cur_last = cur_last.next;
                head = cur_last;
            } else {
                break;
            }
        }
        return backup.next;
    }

    public boolean next_k (ListNode node, int k) {
        for (int i = 0; i < k-1; i++) {
            node = node.next;
            if (node == null) {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
