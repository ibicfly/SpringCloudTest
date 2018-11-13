package io.ibicfly.service0.leetcode;

import io.ibicfly.service0.algorithms.ListNode;

public class Solution2 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
//        ListNode l11=new ListNode(8);
//        ListNode l12=new ListNode(3);
//        l1.next=l11;
//        l11.next=l12;
        ListNode l2=new ListNode(5);
//        ListNode l21=new ListNode(6);
//        ListNode l22=new ListNode(4);
//        l2.next=l21;
//        l21.next=l22;
        ListNode res=addTwoNumbers(l1,l2);
        System.out.println("temp");
    }
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode res=head;
        int jinwei=0;
        while(l1!=null||l2!=null)
        {
            int temp=(l1!=null?l1.val:0)+(l2!=null?l2.val:0)+jinwei;
            jinwei=temp/10;
            res.next=new ListNode(temp%10);
            res=res.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;;
        }
        if(jinwei>0)
            res.next=new ListNode(jinwei);
        return head.next;
    }
}

