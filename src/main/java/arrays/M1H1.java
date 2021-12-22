package arrays;

import java.util.Scanner;

public class M1H1 {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
     *
     * */
    private static int maxProfit3(int[] arr){
        int first_buy = Integer.MIN_VALUE;
        int first_sell = 0;
        int second_buy = Integer.MIN_VALUE;
        int second_sell = 0;

        for(int i = 0; i < arr.length; i++) {

            first_buy = Math.max(first_buy,-arr[i]);
            first_sell = Math.max(first_sell,first_buy+arr[i]);
            second_buy = Math.max(second_buy,first_sell-arr[i]);
            second_sell = Math.max(second_sell,second_buy+arr[i]);

        }
        return second_sell;
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     *
     * */
    private static int maxProfit3_1(int[] arr){
        int n = arr.length;
        int[] pmin = new int[n];
        pmin[0]=arr[0];
        int min=Integer.MIN_VALUE;
        // get the prefix min
        for(int i=1;i<n;i++){
            if(arr[i] < min){
                min = arr[i];
            }

            if(arr[i] < pmin[i-1]){
                pmin[i] = arr[i]-min;
            }
            else {
                pmin[i] = pmin[i-1];
            }
        }

        printArray(pmin);

        int[] smax = new int[n];
        smax[n-1] = arr[n-1];
        int max = Integer.MIN_VALUE;

        for(int i = n-2; i>=0; i --){
            if(arr[i] > max){
                max = arr[i];
            }

            if(arr[i] > smax[i+1]){
                smax[i] = pmin[i] + (max - arr[i]);
            }else{
                smax[i] = smax[i+1];
            }


        }
        printArray(smax);
        return 1;


    }

    private static void printArray(int[] pmin) {
        System.out.println();
        System.out.println(" array: ");
        for (int a: pmin
             ) {
            System.out.print(" a: "+a);
        }
    }

    /**
     *https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] smax = new int[n];
        smax[n-1] = prices[n-1];
        for(int i =n-2;i>=0;i--){
            if(prices[i] > smax[i+1]){
                smax[i] = prices[i];
            }
            else{
                smax[i] = smax[i+1];
            }
        }

        int maxProfit = 0;
        for(int i=0;i<n-1;i++){
            if(smax[i+1] - prices[i]  > maxProfit){
                maxProfit = smax[i+1] - prices[i];
            }
        }
        return maxProfit;
    }


    /**
     * https://codeforces.com/problemset/problem/740/B
     * 5 4
     * 1 -2 1 3 -4
     * 1 2
     * 4 5
     * 3 4
     * 1 4
     * */
    public static int maxHappiness(int numberOfFlowers, int numberOfCombos, int[] emotions, int[][] combos){
        int happiness = 0;
        int[] comboHappiness = new int[numberOfCombos];
        for(int i=0;i<numberOfCombos;i++){
            int sum=0;
            int l = combos[i][0];
            int r = combos[i][1];
            for(int j=l-1;j<r;j++){
                sum+=emotions[j];
            }
            comboHappiness[i] = sum;
        }
        for (int a: comboHappiness
             ) {
            if(a>0){
                happiness+=a;
            }
        }
        return happiness > 0 ? happiness : 0;
    }


    /**
     * https://leetcode.com/problems/rotate-image/
     *
     * */
    public void rotate(int[][] matrix) {
        
    }
}
