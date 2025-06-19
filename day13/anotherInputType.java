package day13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class anotherInputType {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        Queue<Node> q = new LinkedList<>();
        int val = read.nextInt();
        Node root = new Node(val);
        q.add(root);
        for(int i = 1; i < n; i = i + 2){
            Node curr = q.poll();
            String l = read.next();
            if(!l.equals("N")){
                int ln = Integer.parseInt(l);
                Node leftNode = new Node(ln);
                curr.left = leftNode;
                q.add(leftNode);
            }
            if(i==n-1) break;
            String r = read.next();
            if(!r.equals("N")){
                int rn = Integer.parseInt(r);
                Node rightNode = new Node(rn);
                curr.right = rightNode;
                q.add(rightNode);
            }
        }
        read.close();
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node (int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
