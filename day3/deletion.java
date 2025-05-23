package day3;

import java.util.*;

public class deletion{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Linkedlist li =new Linkedlist();

        while(true){
            int val=sc.nextInt();
            if(val==-1){
                break;
            }
            li.insert(val);

        }
        // while(sc.hasNextInt()){
        //     int val=sc.nextInt();
        //     li.insert(val);

        // }
        int position=sc.nextInt();
        System.out.println("Before Deletion");
        li.print();
        System.out.println();
        li.deleteAtPosition(position);
        System.out.println("After Deletion");
        li.print();
        sc.close();
    }
}


class Linkedlist{
    class Node{
        int data;
        Node next;

        public Node(int val){
            data=val;
            next=null;
        }
    }
    Node head=null;
    void insert(int data){
        Node newNode=new Node(data);
        if (head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void deleteAtHead(){
        if(head==null){
            return;
        }
        head=head.next;

    }
    void deleteAtEnd(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }

    void deleteAtPosition(int position){
        if(position==1){
            deleteAtHead();
        }
        Node temp=head;
        int n=1;
        while(n<position-1){
            temp=temp.next;
            n++;
        }
        temp.next=temp.next.next;
    }

    void print(){
        Node temp=head;
        while(temp!=null){
            System.err.print(temp.data+" ");
            temp=temp.next;
        }
    }
}