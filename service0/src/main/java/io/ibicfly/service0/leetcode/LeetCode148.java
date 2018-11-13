package io.ibicfly.service0.leetcode;

import io.ibicfly.service0.algorithms.ListNode;
import org.apache.commons.collections.list.TreeList;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author :cyh
 * @CreateDate: 2018/11/2 13:50
 * @Description: 作用描述
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class LeetCode148 {
    //    创建一个新的链表
//    快排的最坏复杂度O(n^2)
    public ListNode getMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
//        分割中间元素的前面和后面
        pre.next = null;
        return slow;
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //分治
//        取得中间元素
        ListNode left = head;
        ListNode right = getMid(head);
        //排序子链表
        left = mergeSort(left);
        right = mergeSort(right);
        //合并
        if (left == null)
            return right;
        if (right == null)
            return left;
        ListNode h = new ListNode(-1);
        ListNode p = h;
        while (left != null && right != null) {
            if (left.val > right.val) {
                p.next = right;
                right = right.next;
                p = p.next;
            } else {
                p.next = left;
                left = left.next;
                p = p.next;
            }
        }
        if (left == null) {
            p.next = right;
        }
        if (right == null) {
            p.next = left;
        }
        return h.next;
    }

    //    首先想到复杂度为O(nlogn)的排序算法有：快排，堆排和归并排序，三者的空间复杂度都为O(n)。
//    归并排序
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return mergeSort(head);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode();
        ArrayList<Integer> arrayList = new ArrayList();
        while (head != null) {
            arrayList.add(res.val);
        }
        Collections.sort(arrayList);
        for (int temp : arrayList) {
            ListNode tempNode = new ListNode(temp);
            res.next = tempNode;
            res = tempNode;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(6);

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        ListNode head = new LeetCode148().sortList2(l11);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
