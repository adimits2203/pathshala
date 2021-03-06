package hashing;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.Collectors;

public class HashingMain {

    public static void main(String[] args) {
        HashingMain main = new HashingMain();
        //System.out.println(main.palindromePairs(new String[]{"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"}));
        System.out.println(subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0));
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
              if(hash.get(sum)!=null){// sum is repeating, there is sub-array with zero sum
                  result = Math.max(result,i-hash.get(sum));
                  System.out.println("result now is :"+ result);
              }
              else{
                  hash.put(sum,i);
              }
          }
          return result;
      }

      /**
       * https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#_=_
       * *Longest Sub-Array with Sum K*
       * Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.
       *
       *
       *
       * Example 1:
       *
       *
       * Input :
       * A[] = {10, 5, 2, 7, 1, 9}
       * K = 15
       * Output : 4
       * Explanation:
       * The sub-array is {5, 2, 7, 1}.
       * Example 2:
       *
       * Input :
       * A[] = {-1, 2, 3}
       * K = 6
       * Output : 0
       *
       * Your Task:
       * This is a function problem. The input is already taken care of by the driver code. You only need to complete the function smallestSubsegment() that takes an array (A), sizeOfArray (n),  sum (K)and returns the required length of the longest Sub-Array. The driver code takes care of the printing.
       *
       * Expected Time Complexity: O(N).
       * Expected Auxiliary Space: O(N).
       *
       * */
      private static int lenOfLongSubarr (int A[], int N, int K) {
          for (int i:A
               ) {
              System.out.print(i+" , ");
          }
          System.out.println();
          int sum =0, result = 0;
          //get the prefix sum and populate the hashmap
          Map<Integer, Integer> map = new HashMap();
          map.put(0,-1);
          for (int i = 0; i < N; i++) {
              sum+= A[i];
              System.out.println("prefix sum: "+sum + " checking for : "+ (sum-K) +" in map : "+ map);
              if(map.get(sum-K)!=null){
                  System.out.println("got the sum: "+(sum-K) +" at index : "+ map.get(sum-K));
                  result = Math.max(result, i-map.get(sum-K));
                  System.out.println("result is updated to : "+ result);
              }if(map.get(sum)==null){
                  map.put(sum, i);
              }
          }



          return  result;
      }


      /**
       * https://leetcode.com/problems/palindrome-pairs/
       *
       * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.
       *
       *
       *
       * Example 1:
       *
       * Input: words = ["abcd","dcba","lls","s","sssll"]
       * Output: [[0,1],[1,0],[3,2],[2,4]]
       * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
       * Example 2:
       *
       * Input: words = ["bat","tab","cat"]
       * Output: [[0,1],[1,0]]
       * Explanation: The palindromes are ["battab","tabbat"]
       * Example 3:
       *
       * Input: words = ["a",""]
       * Output: [[0,1],[1,0]]
       *
       * Idea is to :
       *  1. put reverse of each word with index in a map m
       *  2. iterate over the list of words and for each word:
       *    2.1. iterate over all the prefixes and for each prefix:
       *        2.1.1. check for empty prefix/suffix all the conditions of 2.1.2.
       *        2.1.2. check if the prefix exists in the m AND if the index is not same as current words index(ie not a self pointer)
       *        AND remaining suffix of this word is palindrome AND this combination is not repeated then
       *        add this i,j into another map(to check duplication) and add this to result list
       *        2.1.3. repeat 2.1.2 for suffix
       *
       *
       * */
      public List<List<Integer>> palindromePairs(String[] words) {
          List<List<Integer>> result = new ArrayList<>();
          Map<String, Integer> reverseWordMap = new HashMap<>();
          int i =0;
          for (String word: words
               ) {
              reverseWordMap.put(reverse(word),i++);
          }
          Map<Pair, Boolean> duplicacyCheckMap = new HashMap();
          for(int j=0;j<words.length;j++){// empty
              if(reverseWordMap.get("")!=null && reverseWordMap.get("")!=j && isPalindrome(words[j])
                      && duplicacyCheckMap.get(new Pair(j,reverseWordMap.get("")))==null){
                    duplicacyCheckMap.put(new Pair(j,reverseWordMap.get("")),true);
                    duplicacyCheckMap.put(new Pair(reverseWordMap.get(""),j),true);
                    List l1 = new ArrayList();
                    l1.add(j);
                    l1.add(reverseWordMap.get(""));
                    List l2 = new ArrayList();
                    l2.add(reverseWordMap.get(""));
                    l2.add(j);
                    result.add(l1);
                    result.add(l2);
              }
          }

          for(int j=0;j<words.length;j++) {// for prefix
              for(int k=0;k<words[j].length();k++){
                  String prefix = words[j].substring(0,k+1);
                  if(reverseWordMap.get(prefix)!=null && isPalindrome(words[j].substring(k, words[j].length()-1))
                          && duplicacyCheckMap.get(new Pair(j, reverseWordMap.get(prefix)))==null
                          && reverseWordMap.get(prefix)!=j){
                      duplicacyCheckMap.put(new Pair(j,reverseWordMap.get(prefix)),true);
                      List l1 = new ArrayList();
                      l1.add(j);
                      l1.add(reverseWordMap.get(prefix));
                      result.add(l1);
                  }
              }
          }

          for(int j=0;j<words.length;j++) {// for suffix
              for(int k=words[j].length()-1;k>=0;k--){
                  String suffix = words[j].substring(k);
                  if(reverseWordMap.get(suffix)!=null && isPalindrome(words[j].substring(0, k))
                          && duplicacyCheckMap.get(new Pair(reverseWordMap.get(suffix),j))==null
                          && reverseWordMap.get(suffix)!=j){
                      duplicacyCheckMap.put(new Pair(reverseWordMap.get(suffix),j),true);
                      List l1 = new ArrayList();
                      l1.add(reverseWordMap.get(suffix));
                      l1.add(j);
                      result.add(l1);
                  }
              }
          }

          return result;
      }

    private boolean isPalindrome(String word) {
          char[] charArr = word.toCharArray();
          int i=0, j=charArr.length-1;
          while(i<j){
              if(charArr[i]!=charArr[j]) return false;
              i++;j--;
          }
          return true;
    }

    class Pair{
           int p;
            int q;

          public Pair(int a,int b){
              p=a;
              q=b;
          }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return p == pair.p && q == pair.q;
        }

        @Override
        public int hashCode() {
            return Objects.hash(p, q);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "p=" + p +
                    ", q=" + q +
                    '}';
        }
    }

    private static String reverse(String word) {
          char[] charArr = word.toCharArray();
          int i=0,j=charArr.length-1;
          while(i<j){
              char c = charArr[i];
              charArr[i] = charArr[j];
              charArr[j] = c;
              i++;
              j--;
          }
          return new String(charArr);
    }


    /**
     * https://leetcode.com/problems/subarray-sum-equals-k/
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     *
     * Idea is to calculate 'prefix sum' since we are looking for contigeous sub array
     * */
     public static int subarraySum(int[] nums, int k) {
         Map<Integer, Integer> prefixMap = new HashMap<>();
         prefixMap.put(0,1);
         int res = 0, sum=0;
         for(int i =0 ;i< nums.length ; i++){
             sum+= nums[i]; // prefix sum
             if(prefixMap.get(sum - k)!=null) {// there exists a sub arr  whose sum is k
                res+=prefixMap.get(sum - k);
             }
             prefixMap.put(sum,prefixMap.getOrDefault(sum,0)+1);

         }
         return res;
     }



     /**
      * https://leetcode.com/problems/subarray-sums-divisible-by-k/
      *
      * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
      *
      * A subarray is a contiguous part of an array.
      *
      *
      *
      * Example 1:
      *
      * Input: nums = [4,5,0,-2,-3,1], k = 5
      * Output: 7
      * Explanation: There are 7 subarrays with a sum divisible by k = 5:
      * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
      * Example 2:
      *
      * Input: nums = [5], k = 9
      * Output: 0
      * Idea is to calculate the prefix sum and chk if its divisible by k if yes increment the result counter
      *
      * */



}
