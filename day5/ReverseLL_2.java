package day5;

import java.util.Scanner;
// create a dummy and connect to head node
// create a tail and keep it at 
public class ReverseLL_2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        sc.close();
    }
    
}

class LinkedList{
  class Node{
    int data;
    Node next;
    
    Node(int val){
      this.data = val;
      this.next = null;
    }
  }
  Node head = null;
  
  void insert(int val){
    Node newNode = new Node(val);
    if(head==null){
      head = newNode;
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
