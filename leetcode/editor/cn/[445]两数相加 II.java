//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
// Related Topics 栈 链表 数学 👍 548 👎 0


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

import java.util.*;

class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> list1 = new LinkedList<>();
        Deque<ListNode> list2 = new LinkedList<>();
        Deque<ListNode> res = new LinkedList<>();
        while (l1 != null) {
            list1.addLast(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.addLast(l2);
            l2 = l2.next;
        }
        int carry = 0;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            ListNode node = new ListNode(0);
            ListNode n1 = list1.removeLast();
            ListNode n2 = list2.removeLast();
            node.val = (n1.val + n2.val + carry) % 10;
            carry = (n1.val + n2.val + carry) / 10;
            res.addFirst(node);
        }
        if (list1.isEmpty() && !list2.isEmpty()) {
            while (!list2.isEmpty()) {
                ListNode node = new ListNode(0);
                ListNode n2 = list2.removeLast();
                node.val = (n2.val + carry) % 10;
                carry = (n2.val + carry) / 10;
                res.addFirst(node);
            }
            if (carry != 0) {
                ListNode node = new ListNode(carry);
                res.addFirst(node);
            }
        } else if (!list1.isEmpty() && list2.isEmpty()) {
            while (!list1.isEmpty()) {
                ListNode node = new ListNode(0);
                ListNode n1 = list1.removeLast();
                node.val = (n1.val + carry) % 10;
                carry = (n1.val + carry) / 10;
                res.addFirst(node);
            }
            if (carry != 0) {
                ListNode node = new ListNode(carry);
                res.addFirst(node);
            }
        } else {
            if (carry != 0) {
                ListNode node = new ListNode(carry);
                res.addFirst(node);
            }
        }
        ListNode head = res.removeFirst();
        ListNode backup = head;
        while (!res.isEmpty()) {
            ListNode cur = res.removeFirst();
            head.next = cur;
            head = cur;
        }
        return backup;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
