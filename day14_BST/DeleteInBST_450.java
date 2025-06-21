package day14_BST;

import java.util.*;

public class DeleteInBST_450 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int val = read.nextInt();
            root = insertionInBST(root, val);
        }
        read.close();
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            TreeNode temp = root.left;
            while (temp.right != null)
                temp = temp.right;
            root.val = temp.val;
            root.left = deleteNode(root.left, temp.val);
        }
        return root;
    }

    public static TreeNode insertionInBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val) {
            root.left = insertionInBST(root.left, val);
        } else {
            root.right = insertionInBST(root.right, val);
        }
        return root;
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
