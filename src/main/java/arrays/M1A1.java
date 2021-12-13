package arrays;

import java.util.Arrays;

public class M1A1 {

    public static void main(String[] args) {
        int[] arr = {2,4,-9,7,6,121};
        int[][] lr = {{1,3},{2,5}};
        prefixSum(arr,lr);
    }

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
}
