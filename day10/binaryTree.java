package day10;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
// types of input in trees
//  1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1 
// 
public class binaryTree {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // for creating the binary tree
        int val = read.nextInt();
        Node root=new Node(val);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            int l=read.nextInt();
            if(l!=-1){
                Node le = new Node(l);
                curr.left=le;
                q.add(le);
            }
            int r=read.nextInt();
            if(r!=-1){
                Node ri = new Node(r);
                curr.right=ri;
                q.add(ri);
            }
        }
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelorder(root);
        read.close();
    }
    // types of traversal 
    // 1 BFT - level order traversal = level by level with precedence order 

    // 2 DFT - preorder traversal  = root -> left  -> right 
    //       - inorder traversal   = left -> root  -> right
    //       - postorder traversal = left -> right -> root
    public static void preorder(Node curr){
        if(curr==null) return;
        System.out.print(curr.data+" ");
        preorder(curr.left);
        preorder(curr.right);
    }
    public static void inorder(Node curr){
        if(curr==null) return;
        inorder(curr.left);
        System.out.print(curr.data+" ");
        inorder(curr.right);

    }
    public static void postorder(Node curr){
        if(curr==null) return;
        postorder(curr.left);
        postorder(curr.right);
        System.out.print(curr.data+" ");

    }
    public static void levelorder (Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }
}


class Node{
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.left=null;
        this.right=null;
        this.data=data;
    }
}

