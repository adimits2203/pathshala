package arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class M1H2 {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrixBlockSum(mat,1));
    }


    /**
     * https://leetcode.com/problems/matrix-block-sum/
     * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
     * Output: [[12,21,16],[27,45,33],[24,39,28]]
     **/
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        for(int i=0;i<mat.length;i++){
            for (int j = 0;j<mat[0].length;j++){
                if(j !=0){
                    mat[i][j] = mat[i][j-1] + mat[i][j];
                }
             }
        }
        for(int j=0;j<mat[0].length;j++) {
            for (int i = 0; i < mat.length; i++) {
                if(i != 0 ){
                    mat[i][j] = mat[i-1][j] + mat[i][j];
                }
            }
        }
        int[][] answer = new int[mat.length][mat[0].length];
        int val,rMin,rMax,cMin,cMax = 0;
        for(int i=0;i< mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                rMin = i - k >0 ? i-k : 0;
                rMax = i + k < mat.length? i+k : mat.length-1;
                cMin = j - k >0 ? j-k: 0;
                cMax = j + k < mat[0].length? j+k : mat[0].length-1;
                val = mat[rMax][cMax];
                if(cMin>0){
                    val-= mat[rMax][cMin-1];
                }
                if(rMin>0){
                    val-= mat[rMin-1][cMax];
                }
                if(rMin>0 && cMin>0){
                    val+=mat[rMin-1][cMin-1];
                }
                answer[i][j] =val;
            }
        }
        return answer;
    }


    /**
     * https://leetcode.com/problems/permutation-in-string/
     *Input: s1 = "ab", s2 = "eidbaooo"
     * Output: true
     * Explanation: s2 contains one permutation of s1 ("ba").
     *
     * */
    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        int[] s1Map = new int[26];
        for (char ch: s1.toCharArray()
             ) {
            s1Map[ch-97] = s1Map[ch-97]+1;
        }
        int[] s2Map = new int[26];
        for(int i=0;i<s1.length();i++){
            char[] s2Arr = s2.toCharArray();
            s2Map[s2Arr[i]-97] =  s2Map[s2Arr[i]-97] +1;
        }
        if (isCountSame(s1Map, s2Map)) return true;
        char[] s2Arr = s2.toCharArray();
        for(int i =s1.length();i< s2.length();i++){
            s2Map[s2Arr[i] -97] = s2Map[s2Arr[i] -97] + 1;
            if( s2Map[s2Arr[i-s1.length()]-97] > 0){
                s2Map[s2Arr[i-s1.length()]-97] = s2Map[s2Arr[i-s1.length()]-97] -1;
            }

            if (isCountSame(s1Map, s2Map)) return true;
        }


        return false;
    }

    private static boolean isCountSame(int[] s1Map, int[] s2Map) {
        boolean flag = true ;
        for(int i=0;i<26;i++){
            if(s1Map[i]!= s2Map[i]){
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }
        return flag;
    }

    private static void printArr(int[] arr){
        for (int a:arr
             ) {
            System.out.println(a);
        }
    }


    /**
     * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
     * idea is to keep maxLength and start from zero to search the substring having only vowel
     * Input: s = "abciiidef", k = 3
     * Output: 3
     * */
    public static int maxVowels(String s, int k) {
        char[] strArr = s.toCharArray();
        int maxVowelCounter;
        int currVowelCounter = 0;
        for(int i =0;i<k;i++){
            if(isVowel(strArr[i])){
                currVowelCounter++;
            }
        }
        maxVowelCounter = currVowelCounter;
        for(int i=k;i<s.length();i++){
            if(isVowel(strArr[i-k])){
                currVowelCounter--;
            }
            if(isVowel(strArr[i])){
                currVowelCounter++;
            }
            if(currVowelCounter > maxVowelCounter){
                maxVowelCounter = currVowelCounter;
            }
        }

        return maxVowelCounter;
    }

    private static boolean isVowel(char c) {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }
}
