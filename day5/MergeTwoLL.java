package day5;

import java.util.Scanner;
// initailise the head with a dummy node 
// initialise tail to the dummy node
// compare the l1 and l2 pointer 
// add lesser node to tail and increment lesser node and tail
// if one 
public class MergeTwoLL {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    
        LinkedList list1 = new LinkedList();
        while(true){
            int data = sc.nextInt();
            if(data == -1) break;
            list1.insert(data);
        }

        LinkedList list2 = new LinkedList();
        while(true){
            int data = sc.nextInt();
            if(data == -1) break;
            list2.insert(data);
        }

        LinkedList merged = new LinkedList();
        merged.head = merged.mergeSorted(list1.head, list2.head);
        merged.print(merged.head);

        sc.close();
    }
}

class LinkedList {
    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void print(Node head){
        if(head == null) return;
        System.out.print(head.data + " ");
        print(head.next);
    }

    Node mergeSorted(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Append remaining nodes
        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;

        return dummy.next;
    }
}
