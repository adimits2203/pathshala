package recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A8 {

    static int count =0;
    public static void main(String[] args) {
        int[] set = new int[]{1,2,3,0};
        subsetSum(set,0,set.length-1,3);
    }


    /**
     * https://leetcode.com/problems/subsets/
     *  statrt with an empty set and recusivley decide whether you want to keep or leave the current element, starting from 0th location
     *  end once you see the end of given set
     * */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        int[] sub = new int[nums.length];
         getAllSubsets(nums,0,0,sub);
        return null;
    }


    private static void getAllSubsets( int[] nums,int size, int elementIndex, int[] subset){
        if(elementIndex == nums.length){
            printArr(subset,size);
            return;
        }
        // keep this element
        subset[size] = nums[elementIndex];
        getAllSubsets(nums,size+1,elementIndex+1,subset);
        // leave this element
        getAllSubsets(nums,size,elementIndex+1,subset);
    }

    private static void printArr(int[] subset,int size) {
        for (int i=0;i<size;i++) {
            System.out.print(subset[i]+ ", ");
        }
        System.out.println();
    }


    /**
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     *
     * 1. Create a map of all the numbers - digitMap
     * 2. recusively call the method for all the combinations
     * */

    public static List<String> letterCombinations(String digits) {
        List<List<String>> digitMap = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        digitMap.add(list);
        List<String> list1 = new ArrayList<>();
        list1.add("d");
        list1.add("e");
        list1.add("f");
        digitMap.add(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("g");
        list2.add("h");
        list2.add("i");
        digitMap.add(list2);
        List<String> list3 = new ArrayList<>();
        list3.add("j");
        list3.add("k");
        list3.add("l");
        digitMap.add(list3);
        List<String> list4 = new ArrayList<>();
        list4.add("m");
        list4.add("n");
        list4.add("o");
        digitMap.add(list4);
        List<String> list5 = new ArrayList<>();
        list5.add("p");
        list5.add("q");
        list5.add("r");
        list5.add("s");
        digitMap.add(list5);
        List<String> list6 = new ArrayList<>();
        list6.add("t");
        list6.add("u");
        list6.add("v");
        digitMap.add(list6);
        List<String> list7 = new ArrayList<>();
        list7.add("w");
        list7.add("x");
        list7.add("y");
        list7.add("z");
        digitMap.add(list7);
        List<String> ans = new ArrayList<>();
        getAllCombinations(digitMap, digits, 0, "",ans);


    return ans;












    }

    private static List<String> getAllCombinations(List<List<String>> digitMap, String inputString, int position, String theString, List<String> answer){
        if(position >= inputString.length()){
             answer.add(theString);
             return answer;
        }
        char ch = inputString.charAt(position);
        for (int i = 0; i < digitMap.get(ch - '2').size() ; i++) {
            getAllCombinations(digitMap,inputString,position+1,theString+digitMap.get(ch-'2').get(i), answer);
        }
        return answer;
    }

    /**
     * sum of subsets
     * ip: {1,2,3} & 3(desired sum)
     * op: {1,2} {3}
     *
     * */
     private static void subsetSum(int[] set, int start, int end,int sum){
         if(start>=set.length){
             if(sum==0){
                 count++;
                 System.out.println(count);
             }
             return;
         }

         subsetSum(set,start+1, end,sum-set[start]);
         subsetSum(set,start+1,end,sum );

     }

}
