package twoPointers;

import java.util.*;

public class TwoPointersMain
{

    public static void main(String[] args) {
        int[] arr = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        for (int i :arr
             ) {
            System.out.print(i + " ");
        }
    }

    /**
     * https://practice.geeksforgeeks.org/problems/key-pair5616/1
     * Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.
     * Example 1:
     *
     * Input:
     * N = 6, X = 16
     * Arr[] = {1, 4, 45, 6, 10, 8}
     * Output: Yes
     * Explanation: Arr[3] + Arr[4] = 6 + 10 = 16
     *
     *
     * Example 2:
     *
     * Input:
     * N = 5, X = 10
     * Arr[] = {1, 2, 4, 3, 6}
     * Output: Yes
     * Explanation: Arr[2] + Arr[4] = 4 + 6 = 10
     *
     *
     * */
     private static boolean hasArrayTwoCandidates(int[] arr, int sum){
         int l = 0, r = arr.length-1;
         Arrays.sort(arr);
         while(l<r){
             int target = sum - arr[l];
             if(arr[r] == target){
                 System.out.println(arr[l]+ " + "+ arr[r] + " = "+ sum);
                 return true;
             }
             else if(arr[r] > target){
                 r--;
             }
             else {
                 l++;
             }
         }

         return false;
     }

     /**
      * Count pairs with given sum[https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1]
      * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
      *
      * Example 1:
      *
      * Input:
      * N = 4, K = 6
      * arr[] = {1, 5, 7, 1}
      * Output: 2
      * Explanation:
      * arr[0] + arr[1] = 1 + 5 = 6
      * and arr[1] + arr[3] = 5 + 1 = 6.
      *
      * Example 2:
      *
      * Input:
      * N = 4, K = 2
      * arr[] = {1, 1, 1, 1}
      * Output: 6
      * Explanation:
      * Each 1 will produce sum 2 with any 1.
      * */
      private static int getPairsCount(int[] arr, int sum){
          int count = 0;
          int l = 0, r = arr.length-1;
          Arrays.sort(arr);
          while(l<r){
              int target = sum - arr[l];
              if(arr[r] == target){
                  if(arr[r] == arr[l]){
                      int v1= arr[l], v2=arr[r], cnt1=0, cnt2=0;
                      while(arr[l]==v1){
                          l++;
                          cnt1++;
                      }
                      while(arr[r]==v2){
                          r--;
                          cnt2++;
                      }
                    //  count +=
                  }
                  else{
                      l++;
                      r--;
                  }
              }
              else if(arr[r] > target){
                  r--;
              }
              else {
                  l++;
              }
          }
          return count;
      }


      /**
       * https://leetcode.com/problems/3sum/
       * triplet sum
       * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
       *
       * Notice that the solution set must not contain duplicate triplets.
       * Example 1:
       *
       * Input: nums = [-1,0,1,2,-1,-4]
       * Output: [[-1,-1,2],[-1,0,1]]
       * Example 2:
       *
       * Input: nums = []
       * Output: []
       *
       * Example 3:
       *
       * Input: nums = [0]
       * Output: []
       *[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
       * Idea is for a+b+c=0, if a is fixes find b & c such that b+c = -a using two pointers pos sorting
       *
       * */
      public static List<List<Integer>> threeSum(int[] nums) {
          List<List<Integer>> result = new ArrayList<>();
          Arrays.sort(nums);
          for(int i=0;i< nums.length-1;i++){
              if(i>0 && nums[i-1]==nums[i]) continue;
              int a = nums[i];
              int t = -1 * (a);
              int p1= i+1, p2=nums.length-1;
              while(p1<p2) {
                  if (nums[p1] + nums[p2] < t) p1++;
                  else if (nums[p1] + nums[p2] > t) p2--;
                  else {// sum is equal
                      List<Integer> list = new ArrayList<>();
                      list.add(nums[p1]);
                      list.add(nums[p2]);
                      list.add(a);
                      result.add(list);
                      if (nums[p1] == nums[p2]) {
                          break;
                      }
                      int x = nums[p1], y = nums[p2];
                      while (nums[p1] == x) p1++ ;
                      while (nums[p2] == y) p2--;
                  }
              }
          }
          return result;

      }



      /**
       * https://leetcode.com/problems/intersection-of-two-arrays/
       *
       * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
       *
       *
       *
       * Example 1:
       *
       * Input: nums1 = [1,2,2,1], nums2 = [2,2]
       * Output: [2]
       * Example 2:
       *
       * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
       * Output: [9,4]
       * Explanation: [4,9] is also accepted.
       *
       *
       * Idea is to
       * */
      public static int[] intersection(int[] nums1, int[] nums2) {
          Set set1 = new HashSet<>();
          Set<Integer> set2 = new HashSet();
          for (int i : nums1) {
              set1.add(i);
          }

          for (int i : nums2) {
              if (set1.contains(i)) {
                  set2.add(i);
              }
          }

          return set2.stream().mapToInt(Integer::intValue).toArray();

      }
}
