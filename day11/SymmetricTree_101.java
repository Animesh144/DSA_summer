package day11;
import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;

public class SymmetricTree_101{
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int val = read.nextInt();
        TreeNode root = new TreeNode(val);
        levelOrderInsertion(root, read);
        
        read.close();
    }
    public static boolean SymmetricTreeSolution(TreeNode root){
        return sym(root.left,root.right);
    }
    public static boolean sym(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return (left.val == right.val) && (sym(left.left,right.right) && sym(left.right,right.left));
    }
    public static void levelOrderInsertion(TreeNode root, Scanner read){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int l = read.nextInt();
            if(l!=-1){
                TreeNode ln = new TreeNode(l);
                curr.left = ln;
                q.add(ln);
            }
            int r = read.nextInt();
            if(r!=-1){
                TreeNode rn = new TreeNode(r);
                curr.right = rn;
                q.add(rn);
            }
        }
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