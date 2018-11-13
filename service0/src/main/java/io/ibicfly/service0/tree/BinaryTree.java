package io.ibicfly.service0.tree;

import io.ibicfly.service0.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {

    /**
     * vlr
     *
     * @param root
     */
    public static void vlr(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "  ");
            vlr(root.left);
            vlr(root.right);
        }
    }

    public static void vlrXunHuan2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                System.out.print(root.val + "  ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void vlrXunHuan(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + "  ");
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (right != null)
                stack.push(right);
            if (left != null)
                stack.push(left);
        }
    }

    /**
     * lvr
     *
     * @param root
     */
    public static void lvr(TreeNode root) {
        if (root != null) {
            lvr(root.left);
            System.out.print(root.val + "  ");
            lvr(root.right);
        }
    }

    /**
     * @param root
     */
    public static void lrv(TreeNode root) {
        if (root != null) {
            lrv(root.left);
            lrv(root.right);
            System.out.print(root.val + "  ");
        }
    }

    /**
     *
     * @param Node
     */
    public static void lrvXunHuan(TreeNode Node)
    {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while(Node != null || !stack1.empty())
        {
            //先向左走到头
            while (Node != null)
            {
                stack1.push(Node);
                stack2.push(0);
                Node = Node.left;
            }
            //如果这个元素已经走了右边，就弹出并打印
            while(!stack1.empty() && stack2.peek() == i)
            {
                stack2.pop();
                System.out.print(stack1.pop().val + "  ");
            }
            //标记已经走了右边的元素
            if(!stack1.empty())
            {
                stack2.pop();
                stack2.push(1);
                Node = stack1.peek();
                Node = Node.right;
            }
        }
    }

    /**
     * 层级遍历
     *
     * @param root
     */
    public static void levelTraverse(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "  ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    /**
     * 求最大深度
     * 真漂亮这代码
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node21 = new TreeNode(5);
        TreeNode node22 = new TreeNode(7);
        TreeNode node222 = new TreeNode(8);
        TreeNode node2222 = new TreeNode(10);
        root.left = node1;
        root.right = node2;
        node1.left = node11;
        node1.right = node12;
        node2.left = node21;
        node2.right = node22;
        node22.right = node222;
        node222.right = node2222;
//        System.out.println("/n层级遍历");
//        maxDepth(root);
        System.out.println("层级遍历");
        levelTraverse(root);
        System.out.println("\nvlr");
        vlr(root);
        System.out.println("\nvlrXunHuan");
        vlrXunHuan(root);
        System.out.println("\nvlrXunHuan2");
        vlrXunHuan2(root);
        System.out.println("\nlrv");
        lrv(root);
        System.out.println("\nlrvXunHuan");
        lrvXunHuan(root);

    }

}
