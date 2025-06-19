package day14;
import java.util.*;
public class DeleteInBST_450 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        TreeNode root = null;
        for(int i=0;i<n;i++){
            int val = read.nextInt();
            root = insertionInBST(root, val)
        }
        while()
        read.close();
    }
    public static TreeNode insertionInBST(TreeNode root, int val){
        if(root == null ) return new TreeNode(val);
        if(val <root.val){
            root.left = insertionInBST(root.left, val);
        }else {
            root.right = insertionInBST(root.right, val)
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
