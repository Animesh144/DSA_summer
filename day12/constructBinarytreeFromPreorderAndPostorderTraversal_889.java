package day12;
import java.util.*;

public class constructBinarytreeFromPreorderAndPostorderTraversal_889 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int[] preorder = new int[n];
        int[] postorder = new int[n];
        for(int i = 0; i < n; i++) preorder[i] = read.nextInt();
        for(int i = 0; i < n; i++) postorder[i] = read.nextInt();

        TreeNode root = constructBinarytreeFromPreorderAndPostorderTraversalSolution(preorder, postorder);
        printLevelOrder(root);
        read.close();
    }
    static int p1 = 0;
    static int p2 = 0;
    public static TreeNode constructBinarytreeFromPreorderAndPostorderTraversalSolution (int [] preorder, int[] postorder){
        TreeNode curr = new TreeNode(preorder[p1]);
        p1++;
        if(curr.val != postorder[p2]){
            curr.left = constructBinarytreeFromPreorderAndPostorderTraversalSolution(preorder, postorder);
        }
        if(curr.val != postorder[p2]){
            curr.right = constructBinarytreeFromPreorderAndPostorderTraversalSolution(preorder, postorder);
        }
        p2++;
        return curr;
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
    public static void printLevelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
        System.out.println();
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