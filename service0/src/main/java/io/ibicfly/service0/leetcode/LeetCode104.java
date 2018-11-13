package io.ibicfly.service0.leetcode;

import io.ibicfly.service0.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class LeetCode104 {

    public static int maxDepth(TreeNode root) {
        int len=0;
        if (root!=null)
        {
            System.out.print(root.val+"  ");
            maxDepth(root.left);
            maxDepth(root.right);
        }
        return 1;
    }
    /**
     * vlr
     * @param root
     */
    public static void vlr(TreeNode root) {
        if (root!=null)
        {
            System.out.print(root.val+"  ");
            vlr(root.left);
            vlr(root.right);
        }
    }
    public static void vlrXunHuan(TreeNode root) {
        Stack <TreeNode> stack=new Stack();
        stack.add(root);
        while(!stack.isEmpty()){
//            if (pNode != null) {
//                System.out.print(pNode.val+"  ");
//                stack.push(pNode);
//                pNode = pNode.left;
//            } else { //pNode == null && !stack.isEmpty()
//                TreeNode node = stack.pop();
//                pNode = node.right;
//            }
            TreeNode node=stack.pop();
            System.out.print(node.val+"  ");
            TreeNode left=node.left;
            TreeNode right=node.right;
            if(right!=null)
                stack.push(right);
            if(left!=null)
                stack.push(left);
        }
    }
    /**
     * lvr
     * @param root
     */
    public  static void lvr(TreeNode root){
        if (root!=null)
        {
            lvr(root.left);
            System.out.print(root.val+"  ");
            lvr(root.right);
        }
    }
    /**
     *
     * @param root
     */
    public  static void lrv(TreeNode root){
        if (root!=null)
        {
            lrv(root.left);
            lrv(root.right);
            System.out.print(root.val+"  ");
        }
    }

    public static void levelTraverse(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+"  ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        TreeNode node1=new TreeNode(2);
        TreeNode node11=new TreeNode(1);
        TreeNode node12=new TreeNode(3);
        TreeNode node2=new TreeNode(6);
        TreeNode node21=new TreeNode(5);
        TreeNode node22=new TreeNode(7);
        TreeNode node222=new TreeNode(8);
        TreeNode node2222=new TreeNode(10);
        root.left=node1;
        root.right=node2;
        node1.left=node11;
        node1.right=node12;
        node2.left=node21;
        node2.right=node22;
        node22.right=node222;
        node222.right=node2222;
//        System.out.println("/n层级遍历");
//        maxDepth(root);
        System.out.println("层级遍历");
        levelTraverse(root);
        System.out.println("\nvlr");
        vlr(root);
        System.out.println("\nvlrXunHuan");
        vlrXunHuan(root);
    }
}
