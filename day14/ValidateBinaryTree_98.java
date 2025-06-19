package day14;
import java.util.*;

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root.left == null && root.right == null ){
//             return true;
//         }
//         if((root.left == null && root.right.val>root.val) ||(root.right == null && root.left.val < root.val)){
//             return true;
//         }
//         if(root.left.val>=root.val || root.right.val=root.val){
//             return false;
//         }
//         boolean flag1 = isValidBST(root.left);
//         boolean flag2 = isValidBST(root.right);
//         if(flag1 == true && flag2 == true ){
//             return true ;
//         }
//         else {
//             return false;
//         }
//     }
// }

public class ValidateBinaryTree_98 {
    public static void main(String[] args){
        Scanner read = new Scanner(Sustem.in);
        read.close();
    }
    public static TreeNode insertionInBST(TreeNode root, int val){
        if (root == null) return new TreeNode(val);
        if(val < root.val) root.left = insertionInBST(root.left, val);
        else root.right = insertionInBST(root.right, val);
        return root;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}