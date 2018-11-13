package io.ibicfly.service0.leetcode;

import io.ibicfly.service0.algorithms.ListNode;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/20 15:38
 * @Description: 作用描述
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode a = null;
        ListNode res = null;
        while (i != null || j != null) {
            int temp = 0;
            if (i != null && j != null) {
                if (i.val < j.val) {
                    temp = i.val;
                    i = i.next;
                } else {
                    temp = j.val;
                    j = j.next;
                }
            } else if (i != null) {
                temp = i.val;
                i = i.next;
            } else if (j != null) {
                temp = j.val;
                j = j.next;
            }
            if (a == null) {
                a = res;
            } else {
                ListNode tempNode = new ListNode(temp);
                a.next = tempNode;
                a = tempNode;
            }
        }
        return res;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;
        new LeetCode21().mergeTwoLists(l11, l21);
    }
}
