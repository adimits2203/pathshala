package arrays;

import java.util.Arrays;

public class M1A1 {

    public static void main(String[] args) {
        int[] arr = {1,2};
        rotateNoExtraSpace(arr,3);


    }


    /**
     * int[] arr = {2,4,-9,7,6,121};
     *         int[][] lr = {{1,3},{2,5}};
     *         prefixSum(arr,lr);
     * */
    private static void prefixSum(int[] arr, int[][] lr){
        int[] psum = new int[arr.length];
        psum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
           psum[i]=psum[i-1]+arr[i];
        }

       for(int p=0;p<lr.length;p++){
           int l = lr[p][0];
           int r = lr[p][1];
           int sum = psum[r] - psum[l-1];
           System.out.println("answer to q: "+ (p+1) + " is = "+ sum);
       }

    }


    /**
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * */
    public static int trap(int[] arr) {
        int water=0;
        int[] pmax = new int[arr.length];
        pmax[0]=arr[0];
        for(int i=1;i< arr.length;i++){
            if(arr[i]>pmax[i-1]){
                pmax[i] =  arr[i];
            }
            else{
                pmax[i] = pmax[i-1];
            }
        }
        int[] smax = new int[arr.length];
        smax[smax.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>smax[i+1]){
                smax[i] = arr[i];
            }
            else{
                smax[i] = smax[i+1];
            }
        }

        for(int i=1;i<arr.length-1;i++){
            int waterOnI = 0;
            int leftMax = pmax[i-1] > arr[i] ? pmax[i-1] : -1;
            int rightMax = smax[i+1] > arr[i] ? smax[i+1] : -1;
            if(leftMax!=-1 && rightMax!=-1){
                int totalHeightOnI = leftMax <= rightMax ? leftMax : rightMax;
                if(totalHeightOnI>0){
                    waterOnI = totalHeightOnI - arr[i];
                }
            }


            water+=waterOnI;
            System.out.println(": "+water);
        }


        return  water;
    }

    /**
     *  int[] arr = {120,1,0,0,0,0};
     *         maximizeSum(arr,1,1,0);
     * */
    private static void maximizeSum(int[] arr, int p, int q , int r){
        int[] pmax = new int[arr.length];
        pmax[0]=p * arr[0];
        for(int i=1;i< arr.length;i++){
            if(p * arr[i]>pmax[i-1]){
                pmax[i] = p* arr[i];
            }
            else{
                pmax[i] = pmax[i-1];
            }
        }
        int[] smax = new int[arr.length];
        smax[smax.length-1]=r*arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]*r>smax[i+1]){
                smax[i] = r*arr[i];
            }
            else{
                smax[i] = smax[i+1];
            }
        }
        int a=0,b=0,c=0;
        int max = Integer.MIN_VALUE;
        for(int i=1;i< arr.length-1;i++){
            int m = arr[i]+ pmax[i-1]+ smax[i+1];
            if(m > max){
                a = pmax[i-1];
                b = arr[i];
                c = smax[i+1];
                max = m;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(max);


    }


    /**
     * https://leetcode.com/problems/max-chunks-to-make-sorted/
     * Input: arr = [1,0,2,3,4]
     * Output: 4
     * */
    public static int maxChunksToSorted(int[] arr) {
        int chunk = 0;
        for(int i =0; i < arr.length;){
            for(int j =i;j<arr.length;j++){
               if(isChunkConatinsAllReqDigits(arr,i,j)){
                   chunk++;
                   i=j+1;
               }
            }
        }
        return chunk;
    }

    private static  boolean isChunkConatinsAllReqDigits(int[] arr, int i, int j) {
        int count=0;
        for(int a=i;a<=j;a++){
            if(arr[a] >= i && arr[a]<=j){
                count++;
            }
        }
        if(count == (j-i+1)){
            return true;
        }
        return false;
    }


    /**
     * https://leetcode.com/problems/rotate-array/
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * */
    public static void rotate(int[] nums, int k) {
        int[] rot = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            rot[((i+k)% nums.length)] = nums[i];
        }



    }

    /**
     * https://leetcode.com/problems/rotate-array/
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * */
    public static void rotateNoExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverseArray(nums,0,n-k-1);
        reverseArray(nums,n-k,n-1);
        reverseArray(nums,0,n-1);
        for (int a: nums
             ) {
            System.out.print(a + " ");
        }

    }


    /**
     * [1,2,3]
     * s=1
     * e=2
     *
     * */
    private static void reverseArray(int[] arr, int s, int e){
        for(int i=0;i< (e-s+1)/2;i++){
          int t = arr[e-i];
          arr[e-i] = arr[s+i];
          arr[s+i] = t;
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
}
