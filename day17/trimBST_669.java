package day17;

import java.util.*;

public class trimBST_669 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        TreeNode root = null;

        // Read BST nodes until -1
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            root = insertionInBST(root, val);
        }

        // Read the low and high values
        int low = read.nextInt();
        int high = read.nextInt();

        // Trim the BST
        TreeNode trimmedRoot = trimBST(root, low, high);

        // Print the in-order traversal of the trimmed BST
        inorderTraversal(trimmedRoot);
        System.out.println(); // Optional: newline after printing
        read.close();
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static TreeNode insertionInBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val)
            root.left = insertionInBST(root.left, val);
        else
            root.right = insertionInBST(root.right, val);
        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
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
