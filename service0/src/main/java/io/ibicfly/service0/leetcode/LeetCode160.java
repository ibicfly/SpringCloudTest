package io.ibicfly.service0.leetcode;

import io.ibicfly.service0.algorithms.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode160 {
    //找到两个单链表的相交节点
//    a1 → a2
//                   ↘
//                        c1 → c2 → c3
//                   ↗
//    B:     b1 → b2 → b3
//    因为会超时，所以必须要求复杂度
    public static void main(String[] args) {
        ListNode headA=new ListNode(1);
        ListNode headA1=new ListNode(2);
        headA.next=headA1;

        ListNode headB=new ListNode(3);
        ListNode headB1=new ListNode(2);
        headB.next=headB1;
        ListNode res=getIntersectionNode1ms(headA,headB);
    }
    public static  ListNode getIntersectionNode12ms(ListNode headA,ListNode headB) {
        HashMap map=new HashMap();
        while(headA!=null){
            map.put(headA.val,"1");
            headA=headA.next;
        }
        while(headB!=null){
            if(map.get(headB.val)!=null)
                return headB;
            headB=headB.next;
        }
        return null;
    }
    public static ListNode getIntersectionNode1ms(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p = headA;
        ListNode q = headB;
        int pn = 1;
        int qn = 1;
        while(p.next != null){
            pn++;
            p = p.next;
        }
        while(q.next != null){
            qn++;
            q = q.next;
        }
        //reset p,q
        p = headA;
        q = headB;
        if(pn > qn){
            int d = pn - qn;
            while(d > 0 && p != null){
                p = p.next;
                d--;
            }
        }else if(pn < qn){
            int d = qn - pn;
            while (d >0 && q != null){
                q = q.next;
                d--;
            }
        }
        while(p != null && q != null){
            if(p == q) return q;
            p = p.next;
            q = q.next;
        }
        return null;
    }
}