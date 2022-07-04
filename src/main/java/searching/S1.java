package searching;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class S1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        sc.nextLine();
        String s = sc.nextLine();
        String[] chars = s.split(" ");
        for (int i = 0; i <  size; i++) {
            arr[i] = Integer.parseInt(chars[i]);
        }
        int k = sc.nextInt();
        System.out.println(findKthSmallest(arr,k));
     }


     /**
      * Square Root
      * Input Format
      *
      * The first line of input contains
      * T
      * , number of testcases
      * Each testcase contains a positive integer
      * N
      *
      * Sample Input 0
      *
      * 6
      * 4
      * 8
      * 16
      * 0
      * 9
      * 2
      *
      * Sample Output 0
      *
      * 2
      * 2
      * 4
      * 0
      * 3
      * 1
      *
      * */
      private static int sqrt(int n){
            int l = 0, h = n;
            while (l<=h){
                int m = (l+h)/2;
                if(m*m > n){
                    h = m-1;
                }
                else{
                    if(m*m == n || (m+1)*(m+1) > n)
                        return m;
                    else{
                        l = m + 1;
                    }
                }
            }
            return -1;
      }



     /**
      * Pair Sum Sorted
      * Given a 1-indexed array of integers
      * nums that is already sorted in non-decreasing order, find two numbers such that they add up to a specific
      * target  number. Let these two numbers be
      * numsindex1[]  and numsindex2[] where 1 <= first <= second <= nums.length
      *
      * The tests are generated such that there is exactly one solution. You may not use the same element twice.
      *
      * You must write an algorithm with
      * O(nlog(n))
      *  runtime complexity.
      *
      *  Sample Input 0
      *
      * 4
      * 2 7 11 15
      * 9
      *
      * Sample Output 0
      *
      * 1 2
      *
      * Sample Input 1
      *
      * 3
      * 2 3 4
      * 6
      *
      * Sample Output 1
      *
      * 1 3
      *
      * Sample Input 2
      *
      * 2
      * -1 0
      * -1
      *
      * Sample Output 2
      *
      * 1 2
      *
      * Explanation
      *

      *
      * */
      private static void findPairSumSorted(int[] arr, int k){
          for (int i=0;i< arr.length;i++
               ) {
              int s = binarySearch(arr, k-arr[i],i+1);
              if(s!=-1){
                  System.out.println(i+1 + " " + (s+1));
              }
          }
      }


     /**
      *
      * First 1 in Array
      * Given a sorted array consisting of 0s and 1s
      * . The task is to print the index of first 1
      *  in the given array. You must write an algorithm with O(log(n))runtime complexity.
      *
      *  Sample Input 0
      *
      * 5
      * 0 0 0 1 1
      *
      * Sample Output 0
      *
      * 4
      * */
      private static void findFirstOne(int[] arr, int key){
          int low = 0, high = arr.length - 1;
          while(low <= high){
              int mid = (low + high) / 2;
              if(arr[mid] == key){
                  if(arr[mid-1] != key || mid == 0 ){
                      System.out.println(++mid+ " ");
                      return;
                  }
                  else{
                      high = mid - 1;
                  }
              }
              else if(arr[mid]<key){
                  low = mid + 1;
              }
              else{
                  high = mid - 1;
              }
          }
          System.out.println(-1);
      }

     /**
      *
      * First and Last Position
      * Given an array of integers
      * nums
      *  sorted in ascending order, find the starting and ending position of a given
      * target  value.
      *
      * Sample Input
      *
      * 5
      * 1 3 3 4 5
      * 2
      * 3
      * 2
      *
      * Sample Output
      *
      * 2 3
      * -1
      *
      * */
     private static void findFirstAndLastIndex(int[] arr, int key){
         int low = 0, high = arr.length - 1;
         while(low <= high){
             int mid = (low + high) / 2;
             if(arr[mid] == key){
                 if(arr[mid-1] != key || mid == 0 ){
                     System.out.println(++mid+ " ");
                     break;
                 }
                 else{
                     high = mid - 1;
                 }
             }
             else if(arr[mid]<key){
                 low = mid + 1;
             }
             else{
                 high = mid - 1;
             }
         }
         low = 0; high = arr.length-1;
         while(low <= high){
             int mid = (low + high) / 2;
             if(arr[mid] == key){
                 if(arr[mid+1] != key || mid == arr.length - 1 ){
                     System.out.print(++mid);
                     return;
                 }
                 else{
                     low = mid + 1;
                 }
             }
             else if(arr[mid]<key){
                 low = mid + 1;
             }
             else{
                 high = mid - 1;
             }
         }
         System.out.println((-1) );
     }

    /**
     * Search a key
     *
     * Given an array nums of N integers which is sorted in ascending order, and an integer target,
     * write a program to search target in nums. If target exists, then print its index. Otherwise, print
     * −1. You must write an algorithm with runtime complexity. log(2)N
     *
     *
     * @param arr
     * @param key*/
     private static int binarySearch(int[] arr, int key){
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid]<key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
     }

    private static int binarySearch(int[] arr, int key, int low){
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid]<key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

     /**
      * Given a sorted array of distinct integers nums and a target value,
      * print the index if the target is found. If not, print the index where it would be
      * if it were inserted in order.
      * You must write an algorithm with O(log(n)) runtime complexity.
      *
      *
      *
      * */
      private static int binarySearchAndSuggestIndex(int[] arr, int key){
          int low = 0, high = arr.length - 1;
          while(low <= high){
              int mid = (low + high) / 2;
              if(arr[mid] == key){
                  return mid;
              }
              else if(arr[mid]<key){
                  low = mid + 1;
              }
              else{
                  high = mid - 1;
              }
          }
          return low;

      }

      /**
       *       K-th Smallest in Array       *
       *
       *Given an array arr[] of size N having no duplicates and an integer K, the task is to find the Kth smallest element from the array in constant extra space and the array can’t be modified.
       *
       * Input Format
       *
       * The first line contains        N        , total number of elements
       * The second line contains  N  space-separated integers
       * The third line contains K
       *
       * Output Format
       *
       * Print the k-smallest element
       *
       *
       * Sample Input 1
       *
       * 6
       * 7 10 4 3 20 15
       * 4
       *
       * Sample Output 1
       *
       * 10
       *
       * Explanation
       *
       * 4 th  smallest element in the array is 10
       *
       * Idea is to use binary search.
       *  Since the count of elements less than 'e' is a monotonic function, binary search can be used to find the number at kth position
       *  find low(est) and high(est) elements in the array
       *  find mid(l+h/2)
       *  for each mid apply the function(count of elements less than m) func(mid)
       *    if the count is less than k move the low to mid +1
       *    else if the count is more than k then either we are at desired number or ahead of it
       *        check the func(mid-1) if >= k make high = mid - 1
       *        else if func(mid-1) < k return this number
       *
       * */
       private  static int findKthSmallest(int[] arr, int k){
            int res=0;
            int low=arr[0], high = arr[0];
           for (int a: arr
                ) {
               if(a<low) low = a;
               if(a>high) high =a;
           }
           while(low<=high){
               int m = (high+low)/2;
               int c = countLessOrEquals(arr, m);
               if(c < k) {
                   low=m+1;
               }
               else {
                   int c1=countLessOrEquals(arr,m-1);
                   if(c1 < k) {
                       return m;
                   }
                   else{
                        high = m -1;
                   }
               }
           }
           return res;

       }

       private static int countLessOrEquals(int[] arr, int e){
           int counter = 0;
           for (int a:arr
                ) {
               if(a<=e) counter++;
           }
           return counter;
       }


}
