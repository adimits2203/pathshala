package Maths;

import java.util.*;
import java.util.stream.Collectors;

public class H5
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputCount = sc.nextInt();
        int[] spf=getSmallestPrimeFactors();// pre processing
        while(inputCount-- > 0){
            almostPrime(sc.nextInt(),spf);
        }
    }


    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
                  if(i==0){
                      if(nums[i+1] > nums[i]+1){
                          list.add(nums[i] );
                      }
                  }
                  else if(i==nums.length-1){
                      if(nums[i-1] < nums[i]-1){
                          list.add(nums[i] );
                      }
                  }
                  else{
                      if((nums[i-1] < nums[i] -1) && (nums[i+1] > nums[i] +1)){
                          list.add(nums[i]);
                      }
                  }
        }
        return list;

    }

    /**
     * A number is called Happy Prime if there are exactly 2 distinct prime divisors of it. Find the number of Happy Prime numbers between 1 and N, both inclusive.
     *  find the siev of prime numbers from 1 to 10^6
     *   for each number N loop through 2 to N
     *    for each nth number
     *          loop through siev of prime numbers till root of N
     *            if that number is 1 return the count
     *            else return count +1
     *
     * */
    private static void almostPrime(int n,int[] spf){
        int happyPrimeCount = 0;


        for (int i = 1; i <= n ; i++) {
            if(isHappyPrime(i,spf)){
                happyPrimeCount++;
            }
        }
        System.out.println(happyPrimeCount);
    }

    private static boolean isHappyPrime(int n,int[] spf){
        int t = n;
        int happyPrimeCount = 0;
        for (int i=spf[n];i*i<=t;i++)
        {
            boolean flag = true;
            while(n%i==0){
                n= n/i;
                if(flag) {
                    happyPrimeCount++;
                    flag= false;
                }
                if(happyPrimeCount>2){
                    return false;
                }
            }
        }
        if(n!=1){
            happyPrimeCount++;
        }

        if(happyPrimeCount==2){
            return true;
        }
        else{
            return false;
        }
    }


    private static int[] getSmallestPrimeFactors(){
        int[] spf = new int[1000000+1];
        for (int i = 0; i < 1000000; i++) {
            spf[i] = -1;
        }

        for (int i = 2; i <= 1000000 ; i++) {
            if(spf[i]<0){
                spf[i] = i;
                for(int j=i;i*j > 0 && i*j<=1000000;j++){
                    spf[j*i] = i;
                }
            }

        }

        return spf;
    }



    private static int[] getPrimes() {
        int[] primes = new int[1000000+1];
        boolean[] isPrime = new boolean[1000000+1];
        isPrime[1] = false;

        for (int i=2;i< isPrime.length;i++
             ) {
            isPrime[i] =true;
        }

        for(int i=2;i<isPrime.length;i++){
            if(isPrime[i]){
                for(int j=i;j*i> 0 && j*i<=1000000;j++){
                    isPrime[j*i] = false;
                }
            }
        }
        int j=0;
        for (int i=2;i< isPrime.length;i++) {
            if(isPrime[i]){
                primes[j++] = i;
            }
        }
        return primes;

    }

    /**
     * Equally Distributed Groups
     * 1. Count the frequencies
     * 2. calculate gcd of freq as this will give a number that divides them(frequencies) all
     *
     */
    private static void equalGroups(){
        Scanner sc = new Scanner(System.in);
        int numberOfTc = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> inputList = new ArrayList<>();
        while(numberOfTc-->0){
              int sizeOfArr = sc.nextInt();
              sc.nextLine();
              String inputStr = sc.nextLine();
              List<Integer> listOfInt = Arrays.stream(inputStr.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
              inputList.add(listOfInt);
        }
        
        
        for (List<Integer> intList: inputList
             ) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int i:intList
                 ) {
                if(freqMap.containsKey(i)){
                    freqMap.put(i,freqMap.get(i)+1);
                }
                else{
                    freqMap.put(i,1);
                }
            }
            int gcd=Integer.MIN_VALUE;
            for (int i: freqMap.values()
                 ) {
                if(gcd==Integer.MIN_VALUE)
                    gcd = i;
                gcd = gcd(i,gcd);
            }
            if(gcd>=2){
                System.out.println("true");
            }
            else{
                System.out.println("false");
            }
            
        }


    }

    private static int gcd(int a,int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        while(max%min!=0){
            int tmp = max;
            max = min;
            min = tmp%min;
        }
        return min;
    }

    private static int lcm(int a, int b){
        return (int)a * b / (gcd(a,b));
    }

}
