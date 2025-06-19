package day12;
import java.util.*;

public class constructBinarytreeFromPreorderAndPostorderTraversal_889 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public static void levelOrderInsertion(TreeNode root,Scanner read){
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
                curr.right = rn ;
                q.add(rn);
            }
        }
    }
}
class TreeNode {
    int val ;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.right = null;
        this.left = null;
    }
}