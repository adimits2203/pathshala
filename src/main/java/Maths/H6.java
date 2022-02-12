package Maths;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class H6 {
    public static void main(String[] args) {
        System.out.println(sumFourDivisors( new int[]{1,2,3,4,5,6,7,8,9,10}));

    }

    public static int sumFourDivisors(int[] n) {
        int sum =0 ;
        boolean[] primes = getPrimes();
        for(int i:n){
            sum+=fourDivisors(i,primes);
        }
        return sum;
    }


    /**
     * You are given an integer     * N     * , output the number of permutations of     * 1     *  to     * N
     * *  so that prime numbers are at prime indices (1-indexed.) Since the answer may be large, return the answer modulo     * 10pow9 + 7
     * idea:
     * get the list of primes
     * get number of primes between two numbers
     * (num of primes)! * ( n - num of primes)!
     * */
    private static void printPrimePermutation(int n) {
       //int[] primes = getPrimes();
        //int countOfPrimes = getCountOfPrimes(n);

    }


    /**
     * https://leetcode.com/problems/four-divisors/
     *
     * 1. Get the list of prime number till 10^5
     * 2. Loop through the list of prime numbers till root n(inclusive)
     * 3. Count the number of divisors
     * 4. if the count ==2 we are good else not good
     * */
     private static int fourDivisors(int n, boolean[] primes){
         int sum=0;
         Set<Integer> set = new HashSet();
         if(primes[n]){
             return 0;
         }
         for (int i=2;i*i <= n;i++) {
            if(primes[i]){
                if(n%i==0){
                    set.add(i);
                    set.add(n/i);
                    if(set.size()>4){
                        return 0;
                    }
                    for (int j = i; j * i <= n ; j++) {
                        if(n % (j*i) == 0){
                            set.add(j*i);
                            if(set.size()>4){
                                return 0;
                            }
                        }
                    }
                    if(set.size()>4){
                        return 0;
                    }
                 }
             }
        }
        set.add(1);
        set.add(n);
        if(set.size()==4){
            Iterator itr = set.stream().iterator();
            while(itr.hasNext()){
                sum+= (Integer)itr.next();
            }
            return sum;
        }
        else{
            return 0;
        }
     }

     private static boolean[] getPrimes(){
         int n = 10000;
         int[] primes = new int[n+1];
         primes[0] = 0;
         primes[1]=0;
         for (int i = 2; i < primes.length ; i++) {
             primes[i] = 1; // consider everything is prime
         }
         for (int i = 2; i * i <= n  ; i++) {
             if(primes[i]==1){
                 for (int j = i; j*i <= n ; j++) {
                        primes[j*i] = 0; // un prime all the multiples of 'i' starting from i*i
                 }
             }
         }

         boolean[] isIsPrime = new boolean[n+1];
         for(int i=0;i<primes.length;i++){
             if(primes[i]==1){
                 isIsPrime[i] = true;
             }
             else{
                 isIsPrime[i] = false;
             }
         }


         return isIsPrime;
     }
}
