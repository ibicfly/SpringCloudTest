package io.ibicfly.service0.leetcode;

import io.ibicfly.service0.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/24 17:05
 * @Description: 作用描述
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 * 二叉搜索树，遵循根节点大于左子节点，小于右子节点的规则
 */
public class LeetCode230 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public int kthSmallest(TreeNode root, int k) {
        TreeNode min=null;
        TreeNode temp=root;
        List<Integer> list = new ArrayList();
        if(root!=null)
            lvr(root,list);
//        二叉搜索最左元素最小元素
//        while (temp!=null)
//        {
//            min=temp;
//            if(temp.left!=null){
//                temp=temp.left;
//            }else if(temp.right!=null){
//                temp=temp.right;
//            }else{
//                temp=temp.left;
//            }
//        }
        return list.get(k);
    }
    public void lvr (TreeNode root,List list){
        if(root==null)
            return ;
        lvr(root.left, list);
        System.out.println(root.val);
        list.add(root.val);
        lvr(root.right, list);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node11 = new TreeNode(2);
        TreeNode node111 = new TreeNode(1);

        TreeNode node12 = new TreeNode(4);
        TreeNode node2 = new TreeNode(6);
//        TreeNode node21 = new TreeNode(5);
//        TreeNode node22 = new TreeNode(7);
//        TreeNode node222 = new TreeNode(8);
//        TreeNode node2222 = new TreeNode(10);
        root.left = node1;
        root.right = node2;
        node1.left = node11;
        node1.right = node12;
        node11.left=node111;
//        node2.left = node21;
//        node2.right = node22;
//        node22.right = node222;
//        node222.right = node2222;
        new LeetCode230().kthSmallest(root,3);
    }
}
