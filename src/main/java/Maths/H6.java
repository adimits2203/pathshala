package Maths;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class H6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sherlockGirlfriend(n);

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


     /**
      * Bob have given a integer
      * N
      *  he have to find a triplet
      * X
      * ,
      * Y
      *  and
      * Z
      *  where each of them are less than or equal to
      * N
      *  and their LCM is maximum.
      *
      * Input Format
      * A single Integer
      * N
      *
      * Output Format
      * A single integer, the maximum LCM Bob can achieve.
      *
      * Example
      * Input
      * 7
      * Output
      * 210
      *
      * */
      private static long lcmChallenge(long i){
            if(i<=2){
                return i;
            }
            else if(i%2!=0){
                return i * (i-1) * (i-2);
            }
            else if(i%3!=0){
                return i * (i-1) * (i-3);
            }
            else{
                return (i-1) * (i-2) *(i-3);
            }


      }



    private static long lcm(long a, long b){
        return a * b / (gcd(a,b));
    }

    private static long gcd(long a, long b){
          long min = Math.min(a,b);
          long max = Math.max(a,b);
          while(max%min!=0){
              long t = max;
              max = min;
              min = t%min;
          }
          return min;
    }


    /***
     * https://codeforces.com/contest/776/problem/B
     *
     *
     * idea is to check is to start from last and assign 'i'(start from 1)
     * and change if the number is prime divisor of nth number
     */
     private static void sherlockGirlfriend(int n){
         int[] color = new int[n];
         boolean[] primes = getPrimes();
         int count = 1;
         for (int i = 2; i-2 < n; i++) {
             if (primes[i]) {
                 color[i-2]=1;
             }
             else {
                 count =2;
                 color[i-2] = 2;
             }
         }
         System.out.println(count);
         for (int i:color
              ) {
             System.out.print(i+" ");
         }
     }


}
