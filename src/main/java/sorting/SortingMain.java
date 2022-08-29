package sorting;

import java.util.*;

public class SortingMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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
        }





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
