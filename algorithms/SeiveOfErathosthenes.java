package algorithms;
import java.util.*;
import java.util.ArrayList;

public class SeiveOfErathosthenes {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int n = 50;
        ArrayList<Integer> primes = new ArrayList<>();
        primes = sieve(n);
        System.out.print(primes);
        read.close();
    }
    public static ArrayList<Integer> sieve(int n){
        boolean[] arr = new boolean[n+1];
        for(int i=2;i*i<n;i++){
            for(int j=i*i;j<=n;j+=i){
                arr[j] = true;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=2;i<n;i++){
            if (arr[i] == false ) res.add(i);
        }
        return res;
    }
}
