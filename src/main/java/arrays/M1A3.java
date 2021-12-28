package arrays;

public class M1A3 {

    public static void main(String[] args) {
        int[] nums = {100,3,2,1};
        System.out.println(maximumGap(nums));
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
