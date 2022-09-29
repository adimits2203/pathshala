package twoPointers;

import java.util.*;
import java.util.stream.Collectors;

public class TwoPointersMain
{

    public static void main(String[] args) {
        System.out.println(findUnion(new int[]{1 ,4, 18 ,19 ,19, 28 ,29 ,32 ,35 ,35, 39, 39, 44 ,49, 49, 50, 50}, new int[]{8,34},17,2));
    }


    /**
     * https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1#_=_
     *
     * Example 1:
     *
     * Input:
     * n = 5, arr1[] = {1, 2, 3, 4, 5}
     * m = 3, arr2 [] = {1, 2, 3}
     * Output: 1 2 3 4 5
     * Explanation: Distinct elements including
     * both the arrays are: 1 2 3 4 5.
     *
     *
     * Example 2:
     *
     * Input:
     * n = 5, arr1[] = {2, 2, 3, 4, 5}
     * m = 5, arr2[] = {1, 1, 2, 3, 4}
     * Output: 1 2 3 4 5
     * Explanation: Distinct elements including
     * both the arrays are: 1 2 3 4 5.
     *
     * */
     public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
     {
        ArrayList<Integer> list = new ArrayList<>();
        int fp=0,sp=0,i=-1;
        while(sp<m && fp<n){
            if(arr1[fp] <= arr2[sp]){
                if(list.isEmpty() || !list.get(i).equals(arr1[fp])){
                    list.add(arr1[fp]);
                    i++;
                }
                if(arr1[fp] == arr2[sp]){
                    sp++;
                }
                fp++;
            }
            else if(arr1[fp] > arr2[sp]){
                if(list.isEmpty() || !list.get(i).equals(arr2[sp])){
                    list.add(arr2[sp]);
                    i++;
                }
               sp++;

                }
         }
         while(fp<n){
             if(list.isEmpty() || !list.get(i).equals(arr1[fp])){
                 list.add(arr1[fp]);
                 i++;
             }
             fp++;

         }
         while(sp<m){
             if(list.isEmpty() || !list.get(i).equals(arr2[sp])){
                 list.add(arr2[sp]);
                 i++;
             }
             sp++;
         }

         return list;
     }

    /**
     * https://practice.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1
     *
     *
     * IDea is to use map to store the elements and then search for corresponding item
     * */
    public static int TotalPairs(int[] nums, int k)
    {
        int ans =0;
        Arrays.sort(nums);
        for (int i=0;i< nums.length;i++
             ) {
            if(binarySearchFound(nums,i+1, nums.length-1,Math.abs(nums[i]+k) )){
                System.out.println(nums[i]);
                ans++;
            }
        }

        return ans;

    }


    /**
     *
     * https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1#_=_
     *
     * Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N.
     *
     * Example 1:
     *
     * Input:
     * L = 6, N = 78
     * arr[] = {5, 20, 3, 2, 5, 80}
     * Output: 1
     * Explanation: (2, 80) have difference of 78.
     * Example 2:
     *
     * Input:
     * L = 5, N = 45
     * arr[] = {90, 70, 20, 80, 50}
     * Output: -1
     * Explanation: There is no pair with difference of 45.
     *
     * Idea is to sort and then do a binary search
     * */
    public static boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        for (int i=0;i<size;i++
             ) {
            if(binarySearchFound(arr,i+1,size-1,Math.abs(arr[i]+n))){
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearchFound(int[] arr, int s, int e,int t) {
        int l=s,r=e;
        while(l<=r){
            int m = (l+r)/2;
            if(arr[m]==t){
                return true;
            }
            else if(arr[m]<t){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return false;
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
