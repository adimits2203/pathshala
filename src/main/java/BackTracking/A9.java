package BackTracking;

public class A9 {
    public static void main(String[] args) {
        char[] str = new char[]{'A','B','C'};
        permute(str,0);
    }
    /**
     * Permutation of a String
     * i/p: ABC
     * o/p: All the permutations of the String
     * ABC
     * ACB
     * BAC
     * BCA
     * CBA
     * CAB
     *
     */
     private static void  permute(char[] str, int i){
        if(i==str.length){
            System.out.println(str);
            return;
        }
        for(int j=i;j<str.length;j++){
            swap(str, i ,j);
            permute(str,i+1);
            swap(str, i ,j);
        }
     }

     private static void swap(char[] str, int i, int j){
         char t = str[i];
         str[i] = str[j];
         str[j] = t;
     }
}
