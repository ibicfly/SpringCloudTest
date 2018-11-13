package io.ibicfly.service0.leetcode;

import io.ibicfly.service0.algorithms.ListNode;

public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
//        快慢指针
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(fast.val==slow.val)
                return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
//        ListNode l11=new ListNode(8);
//        ListNode l12=new ListNode(3);
//        l1.next=l11;
//        l11.next=l12;
//        l12.next=l1;
        new LeetCode141().hasCycle(l1);
    }
}
