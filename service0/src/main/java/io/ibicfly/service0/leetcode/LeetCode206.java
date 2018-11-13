package io.ibicfly.service0.leetcode;

import io.ibicfly.service0.algorithms.ListNode;

import java.util.List;

/**
 * @Author :cyh
 * @CreateDate: 2018/9/20 14:31
 * @Description: 作用描述
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class LeetCode206 {
    /**
     * 一定要使用3个指针进行移动
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode p = head;
        ListNode q = p.next;
        ListNode r;
        p.next=null;
        while(q!=null)
        {
            r=q.next;
            q.next=p;
            p=q;
            q=r;
        }
        return p;
    }

    /**
     *
     * @param head
     * @return
     * 天然适用于递归的方法 其实是将所有的节点的next全部取消，然后沿着遍历的反方向进行连接单链表
     */
    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head;
        return newHead;
    }

    /**
     *
     * @param head
     * @return
     * 相当于这个newHead一直返回的都是5这个节点
     */
    public static ListNode reverseListDiGui(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next=head.next;
        head.next=null;
        ListNode newHead=reverseListDiGui(next);
        next.next=head;
        return newHead;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res=reverseListDiGui(head);
    }
}
