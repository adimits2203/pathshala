package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tpMain {

    public static void main(String[] args) {
        System.out.println(hasArrayTwoCandidates(new int[]{1, 4, 45, 6, 10, 8}, 16) ? "Yes" : "No");

    }


    /**
     * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
     * Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.
     *
     * In case of multiple subarrays, return the subarray which comes first on moving from left to right.
     *
     * Example 1:
     *
     * Input:
     * N = 5, S = 12
     * A[] = {1,2,3,7,5}
     * Output: 2 4
     * Explanation: The sum of elements
     * from 2nd position to 4th position
     * is 12.
     * */
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s){
        ArrayList resultList = new ArrayList<Integer>();
        int l=0,r=0;
        while (l<r){
            r=l+1;
            int currSum = 0;
            currSum=arr[l]+arr[r];
            if(currSum==s){
                break;
            }
            else if(currSum < s){
                r++;
            }

        }

        return resultList;
    }

    /**
     * https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
     * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
     *
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
     * */
    static int  getPairsCount(int[] arr, int n, int k) {
            return 0;
    }
    /**
     * https://practice.geeksforgeeks.org/problems/key-pair5616/1
     * Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.
     *
     * Example 1:
     *
     * Input:
     * N = 6, X = 16
     * Arr[] = {1, 4, 45, 6, 10, 8}
     * Output: Yes
     * Explanation: Arr[3] + Arr[4] = 6 + 10 = 16
     * */
     private static boolean hasArrayTwoCandidates(int[] arr, int x){
         Arrays.sort(arr);
         int l=0, r=arr.length -1;

         while(l < r){
             int n = x - arr[l];
             if(arr[r]==n){
                 return true;
             }
             else if(arr[r]<n){
                 l++;
             }
             else{
                 r--;
             }
         }
         return false;

     }

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * 3. Longest Substring Without Repeating Characters
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * idea:
     * is to use two pointers starting from index zero. and move forward till the 2nd pointer reaches the
     * end of the array. Also keep the freq of the all the elements in the substring in a separate int array.
     * We add the next element in string to the current substring only when its not duplicate.
     *
     *
     *
     * */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int l=0,r=0;
        int resultLength = 1;
        int[] freq = new int[256];
        freq[s.charAt(l)] = 1;
        while(r < s.length() - 1){
            if(freq[s.charAt(r+1)]>0){
                freq[s.charAt(l)]--;
                l++;
                resultLength = Math.max(r-l+1, resultLength);
            }
            else{
                freq[s.charAt(r+1)]++;
                r++;
                resultLength = Math.max(r-l+1, resultLength);
            }
        }
        return resultLength;
    }



}
