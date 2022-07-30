//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1481 👎 0


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

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode backup = newHead;

        while (newHead.next != null && newHead.next.next != null) {
            ListNode switch_1 = newHead.next;
            ListNode switch_2 = newHead.next.next;
            newHead.next = switch_2;
            switch_1.next = switch_2.next;
            newHead.next.next = switch_1;

            newHead = newHead.next.next;
        }

        return backup.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
