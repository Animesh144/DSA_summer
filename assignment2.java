import java.util.*;

public class assignment2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        MyLinkedList l1 = new MyLinkedList();
        MyLinkedList l2 = new MyLinkedList();

        int n = read.nextInt();
        for (int i = 0; i < n; i++) {
            int val = read.nextInt();
            l1.insert(val);
        }
        int m = read.nextInt();
        for (int i = 0; i < m; i++) {
            int val = read.nextInt();
            l2.insert(val);
        }

        printIntersection(l1, l2);
        read.close();
    }

    public static void printIntersection(MyLinkedList l1, MyLinkedList l2) {
        MyLinkedList.Node head1 = l1.head;
        HashSet<Integer> set = new HashSet<>();

        MyLinkedList.Node temp2 = l2.head;
        while (temp2 != null) {
            set.add(temp2.val);
            temp2 = temp2.next;
        }

        while (head1 != null) {
            if (set.contains(head1.val)) {
                System.out.print(head1.val + " ");
                set.remove(head1.val); // Prevent duplicates in output
            }
            head1 = head1.next;
        }
    }
}

class MyLinkedList {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head = null;

    void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
}
