package day2;

import java.util.Scanner;

public class CyclicLinkedList {
    public static void main(String[] args){
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
        Node next;
        public Node(int data){
            this.data=data;
            next=null;
        }
    }
    Node head=null;
    Node tail=null;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        newNode.next=head;
    }
    void print(){
        Node temp=head;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
            
        }while(temp!=head);
    }
}