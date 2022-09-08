package sorting;




import com.sun.xml.internal.ws.util.StringUtils;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SortingMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tcs = sc.nextInt();
        while(tcs-- > 0){
            int s = sc.nextInt();
            int[] arr = new int[s];
            sc.nextLine();
            String l = sc.nextLine();
            String[] lineArr = l.split(" ");
            for (int i = 0; i < lineArr.length ; i++) {
                arr[i] = Integer.parseInt(lineArr[i]);
            }
            int[] res = insertionSort(arr,arr.length);
            for (int i:res
                 ) {
                System.out.print(i+" ");
            }
        }

    }


    /***
     * Insertion Sort
     *
     */
     private static int[] insertionSort(int[] arr,int n){
         for (int i = 0; i < n; i++) {
             int j = i;
             while(j >0){
                 if(arr[j]<arr[j-1]){
                     swap(arr,j,j-1);
                 }
                 j--;
             }
         }
         return arr;
     }

    private static void swap(int[] arr, int j, int i) {
         int t = arr[j];
         arr[j] = arr[i];
         arr[i] = t;
    }

    /**
     * https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0
     *
     * Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.
     *
     * Input:
     * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
     *
     * Output:
     * For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.
     *
     * Constraints:
     * 1 ≤ T ≤ 70
     * 1 ≤ N ≤ 130
     * 1 ≤ Ai ≤ 60
     *
     * Example:
     * Input:
     * 2
     * 5
     * 5 5 4 6 4
     * 5
     * 9 9 9 2 5
     *
     * Output:
     * 4 4 5 5 6
     * 9 9 9 2 5
     * */
     public static void sortByFreq(int[] arr) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int i:arr
              ) {
             freqMap.put(i, freqMap.getOrDefault(i,0)+1);
        }
        List<Pair> pairList = new ArrayList<>();
        for (int i:arr
              ) {
             Pair p = new Pair(i,freqMap.get(i));
             pairList.add(p);
        }
        Collections.sort(pairList, (o1, o2) -> {
            if(o1.getValue() > o2.getValue()){
                return -1;
            }
            else if(o1.getValue() < o2.getValue()){
                return  1;
            }
            else {
                if(o1.getKey() > o2.getKey()){
                    return 1;
                }
                else if(o1.getKey() < o2.getKey()){
                    return -1;
                }
                return 0;
            }
         });
         for (Pair p:pairList
              ) {
             System.out.print(p.getKey()+" ");
         }

     }

    /**
     * https://leetcode.com/problems/largest-number/
     *
     * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
     *
     * Since the result may be very large, so you need to return a string instead of an integer.
     *
     * Example 1:
     *
     * Input: nums = [10,2]
     * Output: "210"
     * Example 2:
     *
     * Input: nums = [3,30,34,5,9]
     * Output: "9534330"
     *
     * Idea is to compare the numbers index-wise
     * */
     public static String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i:nums
              ) {
             list.add(i);
         }
         Collections.sort(list, (o1, o2) -> {
             String s1= o1  + ""+ o2;
             String s2 = o2  + ""+ o1;
             Long s1Int = Long.valueOf(s1);
             Long s2Int = Long.valueOf(s2);
             if(s1Int > s2Int){
                 return -1;
             }
             else if(s1Int < s2Int){
                 return 1;
             }
             return 0;
         });

         StringBuilder sb = new StringBuilder();
         for (int i:list
              ) {
             sb.append(i);
         }
         String r = sb.toString();
         if(r.startsWith("0")  ){
             int lidx = r.lastIndexOf("0");
             return r.substring(lidx);
         }
         return r;
     }


    /**
     * https://www.spoj.com/problems/ADAUSORT/
     *
     * sort but make sure repeated elements are always moved from their original position
     *
     * Example Input
     * 4
     * 1 2 3 4
     * Example Output
     * 1 2 3 4
     * Example Input
     * 3
     * 3 2 1
     * Example Output
     * 3 2 1
     * Example Input
     * 6
     * 6 6 6 6 6 6
     * Example Output
     * 6 5 4 3 2 1
     * Example Input
     * 5
     * 5 5 2 2 3
     * Example Output
     * 4 3 5 2 1
     * Example Input
     * 6
     * 1 2 1 2 1 2
     * Example Output
     * 5 3 1 6 4 2
     * */
    private static void unstableSort(int[] arr){
        List<Pair> pairList = new ArrayList();
        for (int i = 0; i < arr.length; i++) {// all elements with thier indexes are stored in the list
            Pair pair = new Pair(arr[i],i+1);
            pairList.add(pair);
        }

        Collections.sort(pairList, (o1, o2) -> {
            if(o1.getKey() > o2.getKey()){
                return 1;
            }
            else if(o1.getKey()<o2.getKey()){
                return -1;
            }
            else{// two elements are equal
                if(o1.getValue() > o2.getValue()){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.print(pairList.get(i).getValue()+" ");
        }


    }


    private static class Pair{
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }





    /**
     * https://leetcode.com/problems/k-closest-points-to-origin/
     *
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
     *
     * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
     *
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     *
     *Input: points = [[1,3],[-2,2]], k = 1
     * Output: [[-2,2]]
     * Explanation:
     * The distance between (1, 3) and the origin is sqrt(10).
     * The distance between (-2, 2) and the origin is sqrt(8).
     * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
     *
     * Idea is to use sorting to sort the 'points' by the distance d = x2+y2
     * */
    public static int[][] kClosest(int[][] points, int k) {
        List<Point> pointList = new ArrayList();
        for(int i =0;i< points.length;i++){
            pointList.add(new Point(points[i][0],points[i][1]));
        }
        Collections.sort(pointList, (o1, o2) -> {
            int d1 = o1.x * o1.x + o1.y * o1.y;
            int d2 = o2.x * o2.x + o2.y * o2.y;
            if(d1<d2){
                return -1;
            }
            else if(d1 > d2){
                return 1;
            }
            return 0;
        });
        int[][] res = new int[k][2];
        int i =0;
        while (k-- > 0){
            res[i][0] = pointList.get(i).x;
            res[i][1] = pointList.get(i).y;
            i++;
        }

        return res;
    }

    /**
     * https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0
     *
     * Sorting Elements of an Array by Frequency
     *
     * Example:
     * Input:
     * 2
     * 5
     * 5 5 4 6 4
     * 5
     * 9 9 9 2 5
     *
     * Output:
     * 4 4 5 5 6
     * 9 9 9 2 5
     *
     * Explanation:
     * Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6.
     * The output is 4 4 5 5 6.
     * */
     private static void freqSort(Integer[] arr){
         Map<Integer, Integer> freqMap = new HashMap<>();
         for (int i:arr
              ) {
             freqMap.put(i,freqMap.getOrDefault(i,0)+1);
         }
         Iterator<Integer> itr = freqMap.keySet().iterator();
         List<Data> dataList = new ArrayList<>();
         for (Iterator it = itr; it.hasNext(); ) {
             Integer key = (Integer) it.next();
             Data data = new Data(key, freqMap.get(key));
             dataList.add(data);
         }

         Collections.sort(dataList, new Comparator<Data>() {
             @Override
             public int compare(Data o1, Data o2) {
                 if(o1.getFreq() < o2.getFreq()){
                     return 1;
                 }
                 else if(o1.freq > o2.freq){
                     return -1;
                 }
                 else{
                     if(o1.data > o2.data){
                         return 1;
                     }
                     else{
                         return -1;
                     }
                 }

             }
         });

         dataList.stream().forEach(System.out::println);
         System.out.println();
     }

     private static class Data {
         int data;
         int freq;

         @Override
         public String toString() {
             return "Data{" +
                     "data=" + data +
                     ", freq=" + freq +
                     '}';
         }

         public Data(Integer key, Integer integer) {
             data = key;
             freq = integer;
         }



         public int getData() {
             return data;
         }

         public void setData(int data) {
             this.data = data;
         }

         public int getFreq() {
             return freq;
         }

         public void setFreq(int freq) {
             this.freq = freq;
         }


     }

     /**
      * https://leetcode.com/problems/custom-sort-string/
      * You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
      *
      * Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
      *
      * Return any permutation of s that satisfies this property.
      *
      *
      *
      * Example 1:
      *
      * Input: order = "cba", s = "abcd"
      * Output: "cbad"
      * Explanation:
      * "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
      * Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
      * Example 2:
      *
      * Input: order = "cbafg", s = "abcd"
      * Output: "cbad"
      *
      * */
      public static String customSortString(String order, String s) {
          int[] rank = new int[26];
          for (int i = 0; i < 26; i++) {// initialize the rank array
              rank[i] = Integer.MIN_VALUE;
          }

          for (int i = 0; i < order.length(); i++) {// fill the rank of the characters of 'order' string
              rank[order.charAt(i)-'a'] = i;
          }

          List<Pair> pairList = new ArrayList<>(); // Pair of character and its rank for the given string

          for (int i = 0; i < s.length(); i++) {// put the pairs of all the chars with their rank in the list
              Pair p = new Pair(s.charAt(i), rank[s.charAt(i)-'a']);
              pairList.add(p);
          }

          Collections.sort(pairList, (o1, o2) -> {
              if(o1.getValue() < o2.getValue()){
                  return -1;
              }
              else if(o1.getValue() > o2.getValue()){
                  return 1;
              }
              return 0;
          });

          StringBuilder sb = new StringBuilder();
          for (Pair p:pairList
               ) {
              sb.append(p.getKey());
          }

          return sb.toString();
      }





}
