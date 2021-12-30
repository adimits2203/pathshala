package arrays;

import java.util.*;

public class M1H3 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * https://leetcode.com/problems/first-missing-positive/
     * idea is to mark the existance in a bool array if and only if the element is less than size of array , because the least +ve integer can not be more than n+1
     * */
    public static int firstMissingPositive(int[] nums) {
        boolean[] bool = new boolean[nums.length];
        for(int i=0;i< nums.length;i++){
            if(nums[i]<0) continue;;
            if(nums[i] <= nums.length){
                bool[nums[i]-1]=true;
            }
        }

        for(int i=0;i< nums.length;i++){
            if(bool[i]==false)
            {
                return i+1;
            }

        }
        return -1;
    }
    /**
     * https://leetcode.com/problems/array-nesting/
     * Input: nums = [5,4,0,3,1,6,2]
     * Output: 4
     *
     * */
    public static int arrayNesting(int[] nums) {
        int counter,index=0,value, max = Integer.MIN_VALUE;

        for(int i=0;i< nums.length;i++){
            index = i;
            counter=0;
            while(nums[index]>=0){
                value = nums[index];
                nums[index]= -(value+1);
                index = value;
                counter++;
            }
            max= Math.max(max,counter);
        }
        return max;
    }

    /**
     * https://leetcode.com/problems/majority-element-ii/
     * Input: nums = [3,2,3]
     * Output: [3]
     *
     * idea -= using Moore algo
     * */
    public static List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int votes1=0, votes2=0;
        int candidate1=nums[0], candidate2=-1;
        for (int a:nums
             ) {
            if(a==candidate1)
                votes1++;
            else if(a==candidate2)
                votes2++;
            else if(votes1==0){
                candidate1=a;
                votes1=1;
            }
            else if(votes2==0){
                candidate2=a;
                votes2=1;
            }
            else{
                votes1--;
                votes2--;
            }
        }
        votes1=0;votes2=0;
        for (int a :nums
             ) {
            if(a==candidate1)
                votes1++;
            else if(a==candidate2)
                votes2++;


        }
        if(votes1> nums.length/3)
            ans.add(candidate1);
        if(votes2> nums.length/3)
            ans.add(candidate2);




        return ans;
    }

    /**
     * https://leetcode.com/problems/pascals-triangle/
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * */
    public static List<List<Integer>> generate(int numRows) {
       List<List<Integer>> finalList = new ArrayList<>();
       {
            for(int i=1;i<=numRows;i++){
                List<Integer> innerList = new ArrayList<>();
                for(int j=1;j<=i;j++){
                    if(j==1 ||j==i )
                        innerList.add(1);

                    else{
                        innerList.add(finalList.get(i-2).get(j-2).intValue()+ finalList.get(i-2).get(j-1).intValue());
                    }
                }
                finalList.add(innerList);
            }
        }


        return finalList;

    }


    /**
     * idea - Moore algo
     * */
    public static int majorityElement(int[] nums) {
        int votes=0, candidate =-1;
        for(int i=0;i< nums.length;i++){
            if(votes==0){
                candidate = nums[i];
                votes=1;
            }
            else if(nums[i]==candidate){
                votes++;
            }
            else {
                votes--;
            }
        }

        for(int i=0;i< nums.length;i++){
            if(nums[i]==candidate){
                votes++;
            }
        }
        if(votes> nums.length/2){
            return candidate;
        }
        return -1;
    }
}
