package day8;
import java.util.*;

// rule - to perform infix to prefix
// we check for the precedence order of the operator before pushing it into the stack
// when we have a operand is there type as it is no need to push is 
// when we have operator 
// when stack is empty = push it into the stack 
// when stack is not empty - check if current > top element = push
//                         - when current <= top element = pop until stack is empty or precedence rule becomes true 
// when open bracket is there - push it 
// when closing bracket is ther - pop all operator until opening bracket

public class infixToPostfix {
    // precedence order 
    public static int precedence(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    public static void main(String[] args){
        Scanner read= new Scanner(System.in);
        Stack <Character> st=new Stack<>();
        String s=read.next();
        String res="";

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            // Character.isDigit(ch) - to check for digit 
            // character.isLetterOrDigit(ch) - to check for letter or digit 
            if((ch>='0' && ch<='9') || (ch>='a'&&ch<='z') || (ch>='A' && ch<='Z')){
                res+=ch;
            }else if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                while(!st.empty() && st.peek()!='('){
                    res+=st.pop();
                }
                if(!st.empty() && st.peek()=='('){
                    st.pop();
                }
            }else{
                while(!st.empty() && st.peek()!='(' && (precedence(ch)<=precedence(st.peek()))){
                    res+=st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.empty()){
            res+=st.pop();
        }
        System.out.println(res);
        read.close();
    }
    
}
