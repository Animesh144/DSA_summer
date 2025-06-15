package day27;
import java.util.*;

public class TrappingRainWater_42 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int[] height = new int[n];
        int water = TrappingRainWaterSolution(height);
        System.out.println(water);
        read.close();
    }
    public static int TrappingRainWaterSolution(int[] height){
        int water = 0;
        int n = height.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int lm =0,rm =0;
        for(int i=0;i<n;i++){
            if(height[i]>lm) lm = height[i];
            if(height[n-i-1]>rm) rm = height[n-i-1];

            l[i] = lm;
            r[n-i-1] = rm;
        }
        for(int i=0;i<n;i++){
            water+=Math.min(l[i],r[i])-height[i];
        }
        return water;
    }
    
}
