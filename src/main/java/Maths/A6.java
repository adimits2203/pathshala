package Maths;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class A6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-- > 0){
            int numOfElements = sc.nextInt();
            sc.nextLine();
            String[] line = sc.nextLine().split(" ");
            int[] arr = new int[numOfElements];
            int i = 0;
            for (String s: line
                 ) {
                arr[i++] = Integer.parseInt(s);
            }
            printDivisiblePairs(arr,4);
        }

    }


    /**
     * get the mod
     * count the freq of each remainder
     * handle zero
     * handle rest of the array of remainders
     * handle middle element if rest of the array count is odd
     * */
    private static void printDivisiblePairs(int[] arr, int divisor) {
        int[] remainderArr = new int[divisor];
        if(arr.length==1){
            System.out.println(0);
            return;
        }
        for (int i = 0; i < remainderArr.length; i++) {
            remainderArr[i] = 0;
        }
        for (int i: arr
             ) {
            remainderArr[i%divisor] = remainderArr[i%divisor]+ 1;
        }
        int result=0;
        result += ((remainderArr[0] * (remainderArr[0]-1)) /2); // handling zero seperatly
        int i = 1;
        for (; i <= ((divisor -1)/2) ; i++) {
            result+= remainderArr[i] * remainderArr[divisor-i];
        }

        if((divisor-1)%2 != 0){// if its odd, that means one element will remain
            result+=  ((remainderArr[i] * (remainderArr[i]-1)) /2);
        }

        System.out.println(result);
    }

    private static void printArr(int[] arr){
        for (int i:arr
             ) {
            System.out.println(i);
        }
    }


}
