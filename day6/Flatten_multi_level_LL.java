import java.util.Scanner;

public class Flatten_multi_level_LL {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        LinkedList li =new LinkedList();
        while(true){
            int data=sc.nextInt();
            if(data==-1) break;
            li.insert(data);
        }
        li.print(li.head);
        sc.close();
    }
    
}
class LinkedList{
    class Node{
        int data;
        Node next;

        Node(int val){
            data=val;
            next=null;
        }
    }
    Node head=null;
    void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void print(Node head){
        if(head==null) return;
        print(head.next);
        System.out.print(head.data+" ");
    }

}