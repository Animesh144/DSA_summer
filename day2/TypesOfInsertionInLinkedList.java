package day2;

import java.util.Scanner;

public class TypesOfInsertionInLinkedList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList li = new LinkedList();

        System.out.println("Enter the number of elements you want to insert:");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            li.insert(val);
        }

        System.out.println("Enter the value and position to insert:");
        int value = sc.nextInt();
        int position = sc.nextInt();

        System.out.println("Linked list before insertion:");
        li.print();

        li.InsertAtPosition(value, position);

        System.out.println("Linked list after insertion:");
        li.print();

        sc.close();
    }
}

class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
            next = null;
        }
    }

    Node head = null;
    Node tail = null;

    void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    void insertAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void InsertAtPosition(int val, int position) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            insertAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        int count = 1;
        Node currNode = head;

        while (count < position - 1 && currNode != null) {
            currNode = currNode.next;
            count++;
        }

        if (currNode == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = currNode.next;
        currNode.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }
}
