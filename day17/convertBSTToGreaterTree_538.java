package day17;

import java.util.*;

public class convertBSTToGreaterTree_538 {
    public static int sum = 0;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            root = insertionInBST(root, val);
        }
        read.close();

        TreeNode newRoot = convertBST(root);

        System.out.println("Inorder traversal of Greater Tree:");
        inorder(newRoot);
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
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

    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
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
