package algorithms;

import java.util.*;

public class Euclidean_Algorithm_GCD {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[] arr = new int[2];
        arr[0] = lcm(a, b);
        arr[1] = gcd(a, b);
        System.out.println(arr);
        read.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
