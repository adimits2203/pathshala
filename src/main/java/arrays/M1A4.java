package arrays;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class M1A4 {
    public static void main(String[] args) {
        System.out.print(permWidth(new int[]{1,4,3}));
    }

    /**
     * i/p 1 4 3 2 6 --> sort - > 1 2 3 4 6( 0 1 2 3 4)
     * o/p
     * idea - sort it then take out contribution of each number
     * */
    private static double permWidth(int[] arr){
        double sum=0.0;
        Arrays.sort(arr);
        for( int i =0; i< arr.length ;i++){
            double negativeContri, positiveContri;
            if(i==0){
                positiveContri = 0;
            }
            else{
                positiveContri = Math.pow(2,i) - 1;
            }
            if(i==arr.length-1){
                negativeContri = 0;
            }
            else{
                negativeContri = Math.pow(2,arr.length-i-1) -1;
            }
            sum+= positiveContri*arr[i] - negativeContri * arr[i];
        }
        return sum;
    }

    private static int myPower(int base, int power){
        if(power==0) return 1;
        int x = myPower(base,power/2);
        if(power%2==0) return x * x;
        return x*x*base;
    }

    /**
     * all possible paths
     * if you  are at last row/column you can only move by 1 value
     * else path distance would be sum of one position right and one position down
     * */
    private  static int getAllPath(int si,int sj, int curri, int currj,int m, int n){
            int distance=0;
            if(curri==m-1 || currj==n-1){// termination condition
                return 1;
            }
            distance =  getAllPath(si,sj,curri+1,currj,m,n)
                    + getAllPath(si,sj,curri,currj+1,m,n);
            return distance;
    }


    /**
     *https://renaissance.programmingpathshala.com/practice/27?sectionId=1&moduleId=1&topicId=2&subtopicId=19&assignmentId=4
     * Find GCD and LCM
     * Input Format
     * Input consists of two space separated integers
     * A
     *  and
     * B
     * .
     *
     * Output Format
     * Print two Integers
     * X
     *  and
     * Y
     * .Example
     * Input
     * 5 10
     * Output
     * 5 10
     * */
    private static int gcd(int a,int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        while(max%min!=0){
            int tmp = max;
            max = min;
            min = tmp%min;
        }
        return min;
    }

    private static int lcm(int a, int b){
            return a * b / (gcd(a,b));
    }

}
