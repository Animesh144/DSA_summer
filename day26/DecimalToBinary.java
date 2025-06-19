package day26;
import java.util.*;

public class DecimalToBinary {
    static int res = 0;
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int n = 13;
        bin(n);
        System.out.print(res);
        read.close();
    }
    public static void bin(int n){
        if(n == 0) return;
        bin(n/2);
        res = res*10+(n%2);
    }
}
