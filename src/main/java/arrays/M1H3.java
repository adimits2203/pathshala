package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M1H3 {
    public static void main(String[] args) {
        System.out.println(generate(2));
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
