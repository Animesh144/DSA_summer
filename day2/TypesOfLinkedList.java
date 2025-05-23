package day2;

import java.util.*;

class TypesOfLInkedList {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        LinkedList li =new LinkedList();

        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            li.insert(val);
        }
        li.print();
        sc.close();
    }
}

class LinkedList{
    class Node{
        int data;
        Node prev;
        Node next;
        
        Node(int val){
            this.data=val;
            prev=null;//in java by default it will be null 
            next=null;
        }
    }
    Node head=null;
    Node tail=null;
    void insert(int val){
        Node newNode = new Node(val);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }

    void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}