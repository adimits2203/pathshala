package hashing;

import java.util.HashMap;
import java.util.Map;

public class HashingMain {

    public static void main(String[] args) {
        System.out.println(findLargestSubArrayWithZeroSum(new int[]{0,0,0}, 5));
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
             if(hash.get(sum)!=null){// sum is repeating, there is sub-array wit zero sum
                 return true;
             }
             else{
                 hash.put(sum,0);
             }
         }
         return false;
      }

      /**
       *https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
       *
       * Given an array of integers, find the length of the longest sub-array with a sum that equals 0.
       *
       * Examples:
       *
       * Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
       * Output: 5
       * Explanation: The longest sub-array with
       * elements summing up-to 0 is {-2, 2, -8, 1, 7}
       *
       * Input: arr[] = {1, 2, 3}
       * Output: 0
       * Explanation:There is no sub-array with 0 sum
       *
       * Input:  arr[] = {1, 0, 3}
       * Output:  1
       * Explanation: The longest sub-array with
       * elements summing up-to 0 is {0}
       * */
      private static int findLargestSubArrayWithZeroSum(int arr[],int n)
      {
          Map<Integer, Integer> hash = new HashMap<>();
          int sum=0, result=0;
          hash.put(0,-1);
          for (int i = 0; i < arr.length ; i++) {
              sum+=arr[i];
              if(hash.get(sum)!=null){// sum is repeating, there is sub-array wit zero sum
                  result = Math.max(result,i-hash.get(sum));
                  System.out.println("result now is :"+ result);
              }
              else{
                  hash.put(sum,i);
              }
          }
          return result;
      }



}
