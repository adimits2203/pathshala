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
        findFirstOne(arr,1);
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

}
