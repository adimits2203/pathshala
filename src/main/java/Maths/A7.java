package Maths;

import java.util.Scanner;

public class A7 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        while(testCases-- > 0){
            String[] strLineArr = sc.nextLine().split(" ");
            int N = Integer.parseInt(strLineArr[0]);
            int M = Integer.parseInt(strLineArr[1]);
            int X = Integer.parseInt(strLineArr[2]);
            System.out.println(getTeamsCount(N,M,X));
        }
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
