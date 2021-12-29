package arrays;

import java.util.EnumSet;

public class M1A3 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 2};
        rearrangeNaive(nums, nums.length);
    }

    /**
     * https://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
     * Example 1:
     * Input: arr[]  = {1, 3, 0, 2};
     * Output: arr[] = {2, 0, 3, 1};
     * Explanation for the above output.
     * Since arr[0] is 1, arr[1] is changed to 0
     * Since arr[1] is 3, arr[3] is changed to 1
     * Since arr[2] is 0, arr[0] is changed to 2
     * Since arr[3] is 2, arr[2] is changed to 3
     *
     * Idea - idea is to run cycles  rather than going through full array
     *
     * */
    private static void rearrangeNaive(int arr[], int n){
        for(int i=0;i<n;i++){
           if(arr[i] < 0){
               continue;
           }
           int index = arr[i];
           int val = i;
           while(index!=i){
               int temp = arr[index];
               arr[index] = -(val+1);
               val = index;
               index = temp;
           }
           arr[index]=-(val+1);
        }
        for(int i=0;i<n;i++){
            arr[i]= (arr[i]*-1) - 1 ;
        }
        M1H2.printArr(arr);
    }


    /**
     * https://leetcode.com/problems/maximum-gap/
     * Input: nums = [3,6,9,1]
     * Output: 3
     * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
     *
     * idea : bucketing
     * 1. get the max and min values
     * 2. get the gap max-min/n-1
     * 3. if max-min%n-1 !=0 -> gap++
     * 4.
     * */
     public static int maximumGap(int[] nums) {
         {

             int maxGap = Integer.MIN_VALUE;
             int n = nums.length;;
             if(n==1)
                 return 0;
             int min=Integer.MAX_VALUE, max= Integer.MIN_VALUE;
             for (int a: nums
             ) {
                 max = a > max ? a : max;
                 min = a < min ? a : min;
             }
             if(min==max)
                 return 0;
             int gap = (max-min)/(n-1);

             if((max-min)%(n-1)!=0){
                 gap++;
             }
             int minArr[] = new int[n];
             int maxArr[] = new int[n];
             for(int i= 0;i<n;i++){
                 minArr[i]=0;
                 maxArr[i]=0;
             }


             for(int i=0;i<n;i++){
                 int bucket = (nums[i] - min)/gap;
                 minArr[bucket] = nums[i] < minArr[bucket] ? nums[i] :  minArr[bucket]==0? nums[i]  : minArr[bucket] ;
                 maxArr[bucket] = nums[i] > maxArr[bucket] ? nums[i] :  maxArr[bucket] ==0 ? nums[i] : maxArr[bucket] ;

             }
             int prev = -1;
             for (int i =0; i<n;i++){
                 if(minArr[i]==0){
                     continue;
                 }

                 if(prev!=-1)
                     maxGap = Math.max(minArr[i] - maxArr[prev], maxGap);
                 prev=i;
             }


             return maxGap;

         }
     }

}
