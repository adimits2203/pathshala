package Maths;

import java.util.Scanner;

public class A5 {
    public static void main(String[] args) {
        wrapperPrintPrime();

    }




    /**
     *
     Special Contest
     * */
    private static void specialContest() {
        Scanner sc = new Scanner(System.in);
        int numberOfTCs = sc.nextInt();
        String[] inputStringArr = new String[numberOfTCs];
        int index =0;
        sc.nextLine();
        while(true) {
            inputStringArr[index++] = sc.nextLine();
            if (index >= numberOfTCs)
                break;
        }

        for (String inputStr: inputStringArr
             ) {
            String[] inputArr = inputStr.split(" ");
            long N = Long.parseLong(inputArr[0]);
            long A = Long.parseLong(inputArr[1]);
            long B = Long.parseLong(inputArr[2]);
            long K = Long.parseLong(inputArr[3]);
            long count = 0;
            long Bob = N/A;
            long Alice = N/B;
            long common = N/lcm(A,B);
            count = Alice+ Bob - (2 * common);
            if(count >=  K){
                System.out.println("Win");
            }
            else{
                System.out.println("Lose");
            }
        }
    }

    private static long gcd(long a,long b){
        long min = Math.min(a,b);
        long max = Math.max(a,b);
        while(max%min!=0){
            long tmp = max;
            max = min;
            min = tmp%min;
        }
        return min;
    }

    private static long lcm(long a, long b){
        return (long)a * b / (gcd(a,b));
    }



    public static void wrapperPrintPrime(){
        Scanner sc = new Scanner(System.in);
        int numberOfTCs= sc.nextInt();
        sc.nextLine();
        int size = (10*10*10*10*10*10);
        int[] isPrime = preProcess(size);
        int[] preSum = new int[size+1];
        preSum[0] = 0;
        for (int i = 1; i < isPrime.length ; i++) {
            preSum[i] = preSum[i-1]+isPrime[i];
        }
        while(numberOfTCs-- > 0){
            printPrime(sc.nextInt(),preSum);
        }

    }

    private static void printPrime(int n,int[] preSum){
        System.out.println(preSum[n]);
    }


    private static int[] preProcess(int n) {
        int[] isPrime = new int[n+1];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = 1; // mark everything as prime to start with
        }
        isPrime[0] = 0;
        isPrime[1] = 0;
        for(int i = 2; i < isPrime.length ; i++){
            if(isPrime[i]==1){
                for(int j = i; j * i <= n;j++){
                    isPrime[j*i]= 0;
                }
            }
        }
        return isPrime;
    }

    private static void isPrime(boolean[] isIndexChecked, int n) {
        for (int i = 2; i <= n; i++) {
            if(!isIndexChecked[i-2]){// this index is not checked and not multiple of prev prime numbers
                for (int j = i; j * i <= n; j++) {// mark all multiples of this 'i' to true
                    isIndexChecked[(j * i)-2]=true;
                }
            }
        }
    }


}
