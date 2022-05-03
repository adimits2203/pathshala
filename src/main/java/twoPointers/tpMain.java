package twoPointers;

import java.util.Arrays;

public class tpMain {

    public static void main(String[] args) {
        System.out.println(hasArrayTwoCandidates(new int[]{1, 4, 45, 6, 10, 8}, 16) ? "Yes" : "No");

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
