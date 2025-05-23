package day4;
import java.util.*;

public class ReversePrintingLL {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList li = new LinkedList();
      
        int val;
        while(true){
            val = sc.nextInt();
            if(val==-1) break;
            else li.insert(val);
        }
        li.recursivePrint(li.head);

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
    Node temp = head;
    while(temp.next!=null){
      temp = temp.next;
    }
    temp.next = newNode;
    
  }
    void recursivePrint(Node h){
    if (h==null) return;
    recursivePrint(h.next);
    System.out.print(h.data+" ");
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
