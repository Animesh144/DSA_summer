package day17;
import java.util.*;

public class constructBinarySearchTreeFromPreorderTraversal_1008 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public static TreeNode insertionInBST(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(val < root.val) root.left = insertionInBST(root.left, val);
        else root.right = insertionInBST(root.right, val);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}