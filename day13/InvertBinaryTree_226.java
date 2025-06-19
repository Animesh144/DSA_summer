package day13;
import java.util.*;

public class InvertBinaryTree_226 {
    public static void main(String[] args){
        Scanner read = new  Scanner(System.in);
        int val = read.nextInt();
        TreeNode root = new TreeNode(val);
        levelOrderInsertion(root, read);
        read.close();

    }
    public static void levelOrderInsertion(TreeNode root, Scanner read){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
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
