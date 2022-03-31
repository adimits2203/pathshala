package BackTracking;

import java.util.*;
import java.util.stream.Collectors;

public class A9 {
    public static void main(String[] args) {
        //char[] str = new char[]{'A','B','A','A'};
        int[] intArr = {1,1,2};
        permuteUnique(intArr);
    }
    /**
     * Permutation of a String
     * i/p: ABC
     * o/p: All the permutations of the String
     * ABC
     * ACB
     * BAC
     * BCA
     * CBA
     * CAB
     *
     */
     private static void  permute(char[] str, int i){
        if(i==str.length){
            System.out.println(str);
            return;
        }
        for(int j=i;j<str.length;j++){
            swap(str, i ,j);
            permute(str,i+1);
            swap(str, i ,j);
        }
     }

     private static void swap(char[] str, int i, int j){
         char t = str[i];
         str[i] = str[j];
         str[j] = t;
     }


     private static void swap(int[] intArr, int i, int j){
        int t = intArr[i];
         intArr[i] = intArr[j];
         intArr[j] = t;
     }

     /**
      * https://leetcode.com/problems/permutations-ii/
      *
      * */
      public static List<List<Integer>>  permuteUnique(int[] nums) {
          List<List<Integer>> resultList = new ArrayList<>();
          permuteUniqueInternal(nums,0,resultList);
          return resultList;
      }

      private static void permuteUniqueInternal(int[] nums, int i,List<List<Integer>> result) {
          if(i== nums.length){
              List<Integer> numList = new ArrayList<>();
              for (int k:nums
                   ) {
                  numList.add(k);
              }
              result.add(numList);
              return;
          }
          Map<Integer, Integer> freqMap = new HashMap<>();
          for(int j=i;j< nums.length;j++){
              if(freqMap.get(nums[j])==null ){
                  swap(nums,i,j);
                  permuteUniqueInternal(nums,i+1,result);
                  swap(nums,i,j);
              }
              if(freqMap.get(nums[j])!=null){
                  freqMap.put(nums[j], freqMap.get(nums[j])+1);
              }
              else{
                  freqMap.put(nums[j],1);
              }
          }
      }
}
