package day15;

import java.util.*;

public class KthSmallestElementInBST_230 {
    static int i = 0;

    static int res = 0;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        TreeNode root = null;
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            root = insertionInBST(root, val);
        }

        int k = read.nextInt();
        read.close();

        KthSmallestElementInBST_230 obj = new KthSmallestElementInBST_230();
        int result = obj.kthSmallest(root, k);
        System.out.println(result);
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

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null)
            return;
        kthSmallest(root.left, k);
        i++;
        if (i == k)
            res = root.val;
        kthSmallest(root.right, k);
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// class Solution {
// int i = 0;
// int res = 0;

// public int kthSmallest(TreeNode root, int k) {
// inorder(root, k);
// return res;
// }

// public void inorder(TreeNode root, int k) {
// if (root == null)
// return;
// kthSmallest(root.left, k);
// i++;
// if (i == k)
// res = root.val;
// kthSmallest(root.right, k);
// }
// }