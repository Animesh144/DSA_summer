package leetcode.StackAndQueue;
import java.util.Stack;
// public class 224_BasicCalculator {
// }
class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        int sum=0;
        int sign=1;
        for(int i=0;i<s.length();i++){
            // String n=""
            // while(i<s.length() && s.charAt(i)>='0' && charAt(i)<='9'){
            //     n+=s.charAt(i);
            //     i++;
            // }
            // int num=Integer.parseInt(n);
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num=0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                num=num*10 + (s.charAt(i) -'0');
                i++;
                }
                num=(num*sign);
                sum=sum+num;
                i--;
            }
            else if(s.charAt(i)=='-') sign = -1;
            else if(s.charAt(i)=='+') sign = 1;
            else if(s.charAt(i)=='(') {
                st.push(sum);
                st.push(sign);
                sum=0;
                sign=1;
            }else if(s.charAt(i)==')'){
                sum = sum*st.pop();
                sum+=st.pop();
            }
            

        }
        return sum;
    }
}
