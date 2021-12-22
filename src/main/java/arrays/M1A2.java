package arrays;

public class M1A2 {

    public static void main(String[] args) {
        int arr[ ] = {19 ,9};
        System.out.println(minSwap(arr,2    ,18));
    }

    /**
     * https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1#
     *
     * <B>idea</B> is to count the number of elements less than k to get the window size and then find the best window(max size of loegal elements)
     * return the diff of this best window wit the legal element count
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
}
