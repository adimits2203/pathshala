package sorting;

import javafx.util.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SortingMain {

    public static void main(String[] args) {

      /*  Scanner sc = new Scanner(System.in);
        int tcs = sc.nextInt();
        List<Integer[]> list = new ArrayList<>();
        while(tcs-- > 0){
            int size = sc.nextInt();
            Integer[] arr = new Integer[size];
            sc.nextLine();
            String line = sc.nextLine();
            String[] chars = line.split(" ");
            //System.out.println("got the line: "+line);
            int i =0;
            for (String ch: chars) {
                arr[i++] = Integer.valueOf(ch);
            }
            list.add(arr);
         }

        for (Integer[] ip: list
             ) {
         freqSort(ip);
        }*/

        int[][] res = kClosest(new int[][]{{3,3},{5,-1},{-2,4}},2);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();
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
        List<Pair<Pair<Integer, Integer>, Integer>> pairList = new ArrayList<>();
        for(int i =0;i< points.length;i++){
            int d = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pairList.add(new Pair(new Pair(points[i][0],points[i][1]), d));
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
        int[][] res = new int[k][2];
        int i =0;
        while (k-- > 0){
            res[i][0] = pairList.get(i).getKey().getKey();
            res[i][1] = pairList.get(i).getKey().getValue();
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


}
