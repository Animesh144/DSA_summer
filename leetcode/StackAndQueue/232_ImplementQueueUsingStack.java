package leetcode.StackAndQueue;
import java.util.Stack;
// public class 232_ImplementStackUsingQueue {
    
// }
class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1=new Stack<>();
        st2=new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.pop());
            }
            return st2.pop();

        }else{
            return st2.pop();
        }
    }
    
    public int peek() {
        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.pop());
            }
            return st2.peek();

        }else{
            return st2.peek();
        }

        
    }
    
    public boolean empty() {
        if(st1.empty() && st2.empty()){
            return true;
        }else{
            return false;
        }
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */