package Maths;

import java.util.Scanner;

public class A7 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        while(testCases-- > 0){
            int N = sc.nextInt();
            if(N%2!=0) System.out.println("-1");
            else System.out.println(getBracketCombinationCount(N/2));
        }
    }

    /**
     * You are given a non-negative number N, find the number of valid parentheses expressions of that length. If the answer exists, print the answer modulo 10^9 + 7, otherwise print -1.
     *
     * Input Format
     *
     * The first line of the input contains a single integer T denoting the number of test cases.
     * Each test case contains a single integer N.
     * Constraints
     *
     * 1 <= T <= 10^3
     * 1 <= N <= 10^3
     * Output Format
     *
     * For each test case, output the number  of valid parentheses expressions of length N, on a seperate line.
     * Example
     * Input
     * 2
     * 4
     * 5
     * Output
     * 2
     * -1
     *
     * solution(catalan)
     * 1. loop through i = 0 to n-1
     * 2. for each i, loop through j = 0 to i-1
     * 3. calculate the catalan number
     * Sum[i=0 to n-1] C(i) + c(i-1)
     * */
     private static int getBracketCombinationCount(int n){
         int[] catalan = new int[n+1];
         catalan[0] = 1;
         catalan[1] = 1;
         int m = 1000000000+7;
         for (int i = 2; i <=n; i++) {
             catalan[i] = 0;
             for (int j = 0; j < i ; j++) {
                 catalan[i] += (catalan[j]%m) * (catalan[i-1-j]%m);
                 catalan[i]%=m;
             }
             //System.out.printf("\n catalan of %d  = %d",i, catalan[i]);
         }
         return catalan[n];
     }


    /**
     * There are
     * N
     *  boys and
     * M
     *  girls attending a class.
     *
     * The teacher needs to choose a group containing exactly
     * X
     *  students containing no less than
     * 4
     *  boys and no less than one girl for an project.
     *
     * How many ways are there to choose a group?
     *
     * Solution
     * get total number of ways of choosing x out of (m+n) then deduce the number of negative cases
     * use pascal triangle to calculate nCr values
     * */
    private static long getTeamsCount(int n, int m, int x) {
        long res = 0;
        long[][] pascal = getPascal();
        res+= pascal[n+m][x]; // m+nCx
        if(x<=m) res-= pascal[m][x];
        if(x-1<=m) res-= pascal[n][1]*pascal[m][x-1];
        if(x-2<=m) res-= pascal[n][2]*pascal[m][x-2];
        if(x-3<=m) res-= pascal[n][3]*pascal[m][x-3];
        if(x<=n) res-= pascal[n][x];
        return res;
    }

    private static long[][] getPascal() {
        long[][] pascal = new long[61][61];
        for (int i = 0; i < 61 ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(j==0 || j==i) pascal[i][j] = 1;
                else pascal[i][j] = pascal[i-1][j]+pascal[i-1][j-1];
            }
        }
        return pascal;
    }
}
