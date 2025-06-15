package day27;
import java.util.*;
public class FactorialTrailingZeroes_172 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int res = FactorialTrailingZeroesSolution(n);
        System.out.println(res);
        read.close();
    }
    public static int FactorialTrailingZeroesSolution(int n){
        int res = 0;
        while(n>=5){
            res+=n/5;
            n=n/5;
        }
        return res;
    }
}
