package hashing;

import java.util.HashMap;
import java.util.Map;

public class HashingMain {

    public static void main(String[] args) {
        System.out.println(findsum(new int[]{4,2,-3,6}, 5));
    }


    /**
     * https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
     * Input:
     * 5
     * 4 2 -3 1 6
     *
     * Output:
     * Yes
     *
     * Explanation:
     * 2, -3, 1 is the subarray
     * with sum 0.
     *
     * idea is to store prefix sum in the hashtable. If the prefix sum repeats it means the sum is zero
     *
     * */
     private static boolean findsum(int arr[],int n)
     {
         Map<Integer, Integer> hash = new HashMap<>();
         int sum=0;
         for (int i = 0; i < arr.length ; i++) {
             sum+=arr[i];
             if(sum==0){
                 return true;
             }
             if(hash.get(sum)!=null){// sum is repeating, there is subarray wit zero sum
                 return true;
             }
             else{
                 hash.put(sum,0);
             }
         }
         return false;
      }
}
