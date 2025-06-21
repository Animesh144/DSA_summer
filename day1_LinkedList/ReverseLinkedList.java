package day1_LinkedList;

import java.util.Scanner;

public class ReverseLinkedList {
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
      ll.head = ll.reverse();
      System.out.println();
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
  
  void insert(int val){
    Node newNode = new Node(val);
    if(head==null){
      head = newNode;
      return;
    }
    Node temp = head;
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
  
  Node reverse(){
    if(head==null || head.next==null) return head;
        Node prev = null, curr = head, temp = null;
        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
  }
}
