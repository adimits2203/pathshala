package arrays;

import java.util.Arrays;

public class M1A1 {

    public static void main(String[] args) {
        int[] arr = {120,1,0,0,0,0};
        maximizeSum(arr,1,1,0);

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
}
