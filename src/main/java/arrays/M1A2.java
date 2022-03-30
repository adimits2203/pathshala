package arrays;

import com.sun.media.sound.SF2InstrumentRegion;

public class M1A2 {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};

    }




    /**
     * https://leetcode.com/problems/search-a-2d-matrix-ii/
     * idea is to remove either row or column in each pass
     *
     */
    public static boolean searchMatrix(int[][] matrix,int row, int col, int target) {
        int i = 0;
        int j = col - 1;
        while(i<row && j >=0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(target < matrix[i][j]  || i == row -1){
                if(j -1 >=0 )
                    j--;
            }
            else if(target > matrix[i][j]  || j == 0){
                if(i+1<row)
                    i++;
            }
            if(row-i==0 && j==0){
                if(matrix[i][j]==target)
                    return true;
                else
                    return false;
            }


        }



       /*for(int j=col-1,i=0;j>=0 && i < row;) {

            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target && i + 1 < row || j==0) {
                i++;
            } else if (j - 1 >= 0 || i==0) {
                j--;
            }
           if ((i == row - 1 && j == 0) || (i == 0 &&  j == 0)) {
               if (matrix[i][j] == target) {
                   return true;
               }
               return false;
           }

        }*/
        return false;
    }



    /**
     * https://leetcode.com/problems/range-sum-query-2d-immutable/
     * idea is to have prefix sum of all sub matrices
     * i/p: int arr[][] = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
     *
     * */
    public static  int sumRegion(int[][] arr,int row, int col,int row1, int col1, int row2, int col2) {
        int[][] sumArr = new int[row][col];
        for(int i=0;i<row;i++){
            for( int j=0;j<col;j++){
                if(j>0){
                    sumArr[i][j] = sumArr[i][j-1] + arr[i][j];
                }
                else{
                    sumArr[i][j] = arr[i][j];
                }
            }
        }
         for(int j=0;j<col;j++){
            for(int i=0;i<row;i++){
                if(i>0){
                    sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j];
                }

            }
        }


        return sumArr[row2][col2] - sumArr[row1-1][col2] - sumArr[row2][col1-1] +sumArr[row1-1][col1-1] ;
    }


    /**
     * https://www.geeksforgeeks.org/sum-of-all-submatrices-of-a-given-matrix/
     * idea is to get the contribution of each element in all possible sub arrays
     * */
    public static long subMatricesSum( int arr[][], int row, int col) {
        int sum = 0;
        for(int i =0; i< row;i++){
            for(int j=0;j<col;j++){
                    sum+= arr[i][j] * ( (i+1) * (j+1) * (row-i)*(col-j));
            }
        }

        return sum;

    }

    /**
     * https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1#
     *
     * <B>idea</B> is to count the number of elements less than k to get the window size and then find the best window(max size of legal elements)
     * return the diff of this best window with the legal element count
     *
     * Input :
     * arr[ ] = {8, 13, 7 ,6, 4, 8, 5, 15 ,11, 13, 18}
     * K = 9
     * Output :
     * 2
     *
     * */

    public static int minSwap (int arr[], int n, int k) {
        int countOfLegalElements = 0;
        int maxWindow=0;
        for(int i =0;i< n;i++){
            if(arr[i]<=k){
                countOfLegalElements++;
            }
        }

        int l = 0;
        int r = l;
        int counter=0;
        while(r<countOfLegalElements){
            if(arr[r] <= k){
                counter++;
            }
            r++;
        }
        maxWindow = Math.max(maxWindow, counter);
        while(r<n){

            l++;
            if(arr[l-1] <= k){
                counter--;
            }
            if(arr[r] <= k){
                counter++;
            }
            maxWindow = Math.max(maxWindow, counter);
            r++;
        }



        return maxWindow < countOfLegalElements ? countOfLegalElements - maxWindow : 0;

    }

    /**
     * https://practice.geeksforgeeks.org/problems/sum-of-subarrays2229/1
     * N = 3
     * A[] = {1, 2, 3}
     * Output: 20
     *6, 5 ,11 ,4 ,9 ,11, 8 ,2 ,6, 4, 5
     * idea is to calculate contribution of each element
     * */
    public static long subarraySum( long a[], long n) {

        long sum=0;
        for(int i =0;i<n;i++){
            sum+= (((i+1)*(n-i) * a[i]) % (Double.doubleToLongBits (Math.pow(10,9) +7)));

        }
        return sum % Double.doubleToLongBits (Math.pow(10,9) +7);
    }





}
