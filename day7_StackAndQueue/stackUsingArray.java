package day7_StackAndQueue;
import java.util.*;

public class stackUsingArray {
    public static void main(String[] args){
        stack st = new stack();
        st.create();
        
        st.push(10);//10
        st.push(5);//10 5
        st.print();
        st.pop();//10
        st.push(3);//10 3 12 11
        st.push(12);
        st.push(11);
        int top = st.peek();
        System.out.println("The top element is:"+top);
        st.pop();
        st.pop();
        st.print();

    }
    
}

class stack{
    int top=-1;
    int[] st;
    int n;
    void create(){
        Scanner sc= new Scanner(System.in);
        n =sc.nextInt();
        st = new int[n];
        sc.close();

    }
    void push(int val){
        if(top==n-1) {
            System.out.println("Stack is full");
            return;
        }
        st[++top]=val;
    }
    int pop(){
        if(top==-1){
            System.out.println("Stack is empty");
        }
        return st[top--];
    }
    int peek(){
        return st[top];
    }
    int size(){
        return top+1;
    }
    void print(){
        for(int i=0;i<=top;i++){
            System.out.println(st[i]);
        }
    }
}