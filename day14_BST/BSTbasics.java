package day14_BST;

import java.util.*;

public class BSTbasics {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Node root = null;
        System.out.println("Enter elements (-1 to stop):");
        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            root = insert(root, val);
        }

        System.out.println("Inorder Traversal:");
        inorder(root);
        System.out.println("\nPreorder Traversal:");
        preorder(root);
        System.out.println("\nPostorder Traversal:");
        postorder(root);
        System.out.println("\nLevel Order Traversal:");
        levelOrder(root);

        System.out.println("\nEnter value to search:");
        int key = read.nextInt();
        System.out.println(search(root, key) ? "Found" : "Not Found");

        System.out.println("Enter value to delete:");
        int del = read.nextInt();
        root = delete(root, del);

        System.out.println("Inorder after deletion:");
        inorder(root);

        read.close();
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.val == key)
            return true;
        if (key < root.val)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static Node delete(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            Node minNode = minValue(root.right);
            root.val = minNode.val;
            root.right = delete(root.right, minNode.val);
        }
        return root;
    }

    public static Node minValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
