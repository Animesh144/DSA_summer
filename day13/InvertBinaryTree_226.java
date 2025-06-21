package day13;

import java.util.*;

public class InvertBinaryTree_226 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Example input format:
        // First line: root value
        // Next lines: pairs of left and right children for each node in level order
        // Use -1 for nulls

        int val = read.nextInt();
        TreeNode root = new TreeNode(val);
        levelOrderInsertion(root, read);

        TreeNode invertedRoot = InvertBinaryTreeSolution(root);
        System.out.println("Inverted Tree (Level Order):");
        printLevelOrder(invertedRoot);

        read.close();

    }

    public static TreeNode InvertBinaryTreeSolution(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        InvertBinaryTreeSolution(root.left);
        InvertBinaryTreeSolution(root.right);
        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        System.out.println();
    }

    public static void levelOrderInsertion(TreeNode root, Scanner read) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int l = read.nextInt();
            if (l != -1) {
                TreeNode ln = new TreeNode(l);
                curr.left = ln;
                q.add(ln);
            }
            int r = read.nextInt();
            if (r != -1) {
                TreeNode rn = new TreeNode(r);
                curr.right = rn;
                q.add(rn);
            }
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
