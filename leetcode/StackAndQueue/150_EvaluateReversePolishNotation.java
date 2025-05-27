package leetcode.StackAndQueue;
import java.util.Stack;

// public class 150_EvaluateReversePolishNotation {
    
// }
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            if(s.equals("+")){
                int res=st.pop()+st.pop();
                st.push(res);
            }else if(s.equals("-")){
                int v2=st.pop();
                int v1=st.pop();
                int res=v1-v2;
                st.push(res);
            }else if(s.equals("*")){
                int res=st.pop()*st.pop();
                st.push(res);

            }else if(s.equals("/")){
                int v2=st.pop();
                int v1=st.pop();
                int res=v1/v2;
                st.push(res);

            }else{
                int res=Integer.parseInt(s);
                st.push(res);
            }
        }
        return st.pop();
    }
}