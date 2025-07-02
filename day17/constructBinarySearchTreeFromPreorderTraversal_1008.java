package day17;

import java.util.*;

public class constructBinarySearchTreeFromPreorderTraversal_1008 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        List<Integer> preorderList = new ArrayList<>();

        // Reading input until -1 is encountered
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            preorderList.add(val);
        }
        read.close();

        // Convert list to array
        int[] preorder = new int[preorderList.size()];
        for (int i = 0; i < preorder.length; i++) {
            preorder[i] = preorderList.get(i);
        }

        // Build BST
        constructBinarySearchTreeFromPreorderTraversal_1008 obj = new constructBinarySearchTreeFromPreorderTraversal_1008();
        TreeNode root = obj.bstFromPreorder(preorder);

        // Print inorder traversal to verify the BST
        System.out.println("Inorder traversal of constructed BST:");
        inorder(root);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = insertionInBST(root, preorder[i]);
        }
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
        this.right = null;
        this.left = null;
    }
}
