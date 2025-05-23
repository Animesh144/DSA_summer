package day1;

import java.util.Scanner;

public class creationLinkedList {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      LinkedList ll = new LinkedList();
      
      int val;
      while(true){
        val = sc.nextInt();
        if(val==-1) break;
        else ll.insert(val);
      }
      ll.print();
      sc.close();
  }
}

class LinkedList{
  //blueprint
  class Node{
    int data;
    Node next;// pointer
    
    Node(int val){
      this.data = val;
      this.next = null;
    }
  }
  Node head = null;//pointer
  //Node tail = null;//pointer
  
  void insert(int val){
    Node newNode = new Node(val);
    if(head==null){
      head = newNode;
      //tail = newNode;
      return;
    }
    // tail.next = newNode;
    // tail = newNode;
    Node temp = head;//temp=400
    while(temp.next!=null){
      temp = temp.next;
    }
    temp.next = newNode;
    
  }
  void print(){
    if(head==null){
      System.out.print("LL is empty");
      return;
    } 
    Node temp = head;
    while(temp!=null){
      System.out.print(temp.data+"->");
      temp = temp.next;
    }
    System.out.print("NULL");
  }
}
