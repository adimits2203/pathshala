package sorting;





import java.awt.*;
import java.util.*;
import java.util.List;

public class SortingMain {



    public static void main(String[] args) {

      /*  Scanner sc = new Scanner(System.in);
        int tcs = sc.nextInt();
        while(tcs-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            sc.nextLine();
            String l = sc.nextLine();
            String[] lineArr = l.split(" ");
            for (int i = 0; i < lineArr.length ; i++) {
                arr[i] = Integer.parseInt(lineArr[i]);
            }
            System.out.print(smallestSubArr(arr,k));
            System.out.println();
        }*/
        int[] arr = new int[]{12, 34, 45, 9, 8, 90, 3};
        segregateEvenOdd(arr,arr.length);
        for (int t:arr
             ) {
            System.out.print(t+" ");
        }

    }


    /**
     * https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-numbers4629/1
     * Given an array Arr[], write a program that segregates even and odd numbers.
     * The program should put all even numbers first in sorted order, and then odd numbers in sorted order.
     *
     * Example 1:
     *
     * Input:
     * N = 7
     * Arr[] = {12, 34, 45, 9, 8, 90, 3}
     * Output: 8 12 34 90 3 9 45
     * Explanation: Even numbers are 12, 34,
     * 8 and 90. Rest are odd numbers. After
     * sorting even numbers 8 12 34 90 and
     * after sorting odd numbers 3 9 45. Then
     * concat both.
     * Example 2:
     *
     * Input:
     * N = 5
     * Arr[] = {0, 1, 2, 3, 4}
     * Output: 0 2 4 1 3
     * Explanation: 0 2 4 are even and 1 3
     * are odd numbers.
     * */
     private static void segregateEvenOdd(int arr[], int n) {
         int countOfEven = 0;
         for (int i = 0; i < arr.length ; i++) {
             if(arr[i]%2==0){
                 if(i!=countOfEven){
                     swap(arr,i,countOfEven);
                 }
                 countOfEven++;
             }
         }
         //System.out.println("index of even: "+ countOfEven);
         Arrays.sort(arr,0,countOfEven);
         Arrays.sort(arr,countOfEven,arr.length);
     }


    /**
     * https://leetcode.com/problems/move-zeroes/
     *
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [0]
     *
     *
     * */
    public static void moveZeroes(int[] nums) {
        int countOfNonZeros = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != 0){
               if(i != countOfNonZeros){
                   swap(nums,i,countOfNonZeros);
               }
               countOfNonZeros++;
            }
        }
    }

    /**
     * Quick Sort
     * */
     private static void quickSort(int[] arr,int l,int r){
         if(l==r){
             return;
         }
         if(l<r){
             int pivot = partition(arr,l,r);
             quickSort(arr,l,pivot-1);
             quickSort(arr,pivot+1,r);
         }
     }

     // 4 3 5 8 9 2 1 6
     private static int partition(int[] arr,int l,int r){
        if(l==r) return l;
        int[] lesserArr = new int[arr.length];
        int[] greaterArr = new int[arr.length];
        int lesserIndex=0,greaterIndex=0;
        int pivot = arr[l];
        for (int i = l+1; i <= r; i++) {
            if(arr[i]<=pivot){
                lesserArr[lesserIndex++]=arr[i];
            }
            else{
                greaterArr[greaterIndex++]=arr[i];
            }
        }
        int masterIdx = l;
        for (int i=0;i<lesserIndex;i++ // insert lesser elements
              ) {
             arr[masterIdx++] = lesserArr[i];
        }
        int pivotIdx = masterIdx;
        arr[masterIdx++] = pivot; // insert the pivot
        for (int i=0;i<greaterIndex;i++
              ) {
             arr[masterIdx++] = greaterArr[i];
         }

         return pivotIdx;

     }


    /**
     * Merge Sort
     * */
    public static void merge(int arr[], int l, int m, int r)
    {
        int[] temp = new int[r-l+1];
        int s1=l,e1=m,s2=m+1,e2=r,c=0;
        for(;s1<=e1 && s2<=e2;){
            if(arr[s1]<=arr[s2]){
                temp[c++]=arr[s1++];
            }
            else{
                temp[c++]=arr[s2++];
            }
        }

        for(;s1<=e1;){
            temp[c++]=arr[s1++];
        }

        for(;s2<=e2;){
            temp[c++]=arr[s2++];
        }
        c=0;
        for (int i = l; i <= r; i++,c++) {
            arr[i] = temp[c];
        }

        System.out.println();

    }
    public static  void mergeSort(int arr[], int l, int r)
    {
        if(l==r){// break recurssion when sub arr size is one(1)
            return;
        }
        int m = (l+r)/2;
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
    }

    /**
     * https://practice.geeksforgeeks.org/problems/length-unsorted-subarray3022/1
     *
     * Input:
     * N = 11
     * Arr[] ={10,12,20,30,25,40,32,31,35,50,60}
     * Output: 3 8
     * Explanation: Subarray starting from index
     * 3 and ending at index 8 is required
     * subarray. Initial array: 10 12 20 30 25
     * 40 32 31 35 50 60 Final array: 10 12 20
     * 25 30 31 32 35 40 50 60
     * (After sorting the bold part)
     *
     * Input:
     * N = 9
     * Arr[] = {0, 1, 15, 25, 6, 7, 30, 40, 50}
     * Output: 2 5
     * Explanation: Subarray starting from index
     * 2 and ending at index 5 is required
     * subarray.
     * Initial array: 0 1 15 25 6 7 30 40 50
     * Final array:   0 1 6 7 15 25 30 40 50
     * (After sorting the bold part)
     * */
    int[] printUnsorted(int[] arr, int n) {
        int s=0,e=0;
        int leastElementTillThisPoint = Integer.MAX_VALUE;
        for (int i = arr.length-1; i >=0 ; i--) {
            leastElementTillThisPoint = Math.min(leastElementTillThisPoint,arr[i]);
            if(leastElementTillThisPoint!=arr[i]){
                s = i;
            }
        }

        int maxElementTillThisPoint = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            maxElementTillThisPoint = Math.max(maxElementTillThisPoint,arr[i]);
            if(maxElementTillThisPoint!=arr[i]){
                e = i;
            }
        }

        return new int[]{s,e};
    }

    /**
     * https://leetcode.com/problems/squares-of-a-sorted-array/
     *
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     * Example 2:
     *
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     *
     *
     * Idea = to get it in O(n) approach, merge process can be usedcquik
     * square the elements
     * have two parts(one decreasing and other increasing)
     * merge these two to get final sorted array
     * */
     public static int[] sortedSquares(int[] nums) {
         for (int i = 0; i < nums.length; i++) {// square them
             nums[i] = nums[i]*nums[i];
         }
         if(nums.length==1){
             return nums;
         }
         int poi=-1;
         for (int i = 0; i < nums.length-1; i++) {// find point of inflection
             if(nums[i+1] > nums[i]){
                 poi = i;
                 break;
             }
         }
         int[] res = new int[nums.length];
         if(poi!=-1){
             int f = poi - 1, s = poi, i = 0;
             for (; f >= 0 && s < nums.length; ) {
                 if (nums[f] < nums[s]) {
                     res[i++] = nums[f--];
                 } else {
                     res[i++] = nums[s++];
                 }
             }

             for (; f >= 0; ) {
                 res[i++] = nums[f--];
             }

             for (; s < nums.length; ) {
                 res[i++] = nums[s++];
             }
         }
         else{
             for (int i = 0; i < nums.length; i++) {
                 res[i] = nums[nums.length-1-i];
             }
         }
         return res;

     }

    /**
     *
     * https://leetcode.com/problems/merge-sorted-array/
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     * Example 2:
     *
     * Input: nums1 = [1], m = 1, nums2 = [], n = 0
     * Output: [1]
     * Explanation: The arrays we are merging are [1] and [].
     * The result of the merge is [1].
     * Example 3:
     *
     * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
     * Output: [1]
     * Explanation: The arrays we are merging are [] and [1].
     * The result of the merge is [1].
     * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
     * */
     public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] res = new int[m+n];
            int i=0,j=0,k=0;
            for(;i<m&&j<n;){
                if(nums1[i] < nums2[j]){
                    res[k++] = nums1[i++];
                }
                else{
                    res[k++] = nums2[j++];
                }
            }

             for (; i < m; i++) {
                 res[k++] = nums1[i++];
             }

             for(;j<n;j++){
                 res[k++] = nums2[j++];
             }

         for (int p:res
              ) {
             System.out.print(p+" ");
         }
     }


    /***
     * Smallest SubArr
     * return length of smalled subarray with sum >= k. Given all the elements are +ve
     *
     * i/p:
     * arr: 5 1 4 3 2 9
     * k: 10
     *
     * o/p:
     * 2
     *
     * Idea is - since all the elements are +ve the prefix sum will be monotonous(increasing) and binary search can be applied.So, brute force will be be of N*N where as this
     * approach will be N log N
     */
     private static int smallestSubArr(int[] arr,int k){
         int res = Integer.MAX_VALUE;
         int n = arr.length;
         int[] ps = new int[n];
         int psum = 0;
         for (int i = 0; i < n; i++) {//prefix sum
             psum+=arr[i];
             ps[i] = psum;
         }

         for (int i = 0; i < n ; i++) {
             int l = i, h=n-1;
             while(l<=h){
                 int m = (l+h)/2;
                 int subArrSumTillM = i>0 ? ps[m] - ps[i-1] : ps[m];
                 if(subArrSumTillM < k){
                     l = m+1;
                 }
                 else{
                     int subArrSumTillM_1 =  i>0 ? ps[m-1]-ps[i-1] :ps[m-1];
                     if(subArrSumTillM_1 < k){
                         res = Math.min(res,m-i+1);
                         break;
                     }
                     else{
                         h = m-1;
                     }
                 }
             }
         }

         return res;
     }


    /**
     * https://www.codechef.com/problems/MAXDIFF
     *
     *
     * */
     private static int maxDiff(int[] arr,int k){
         k=Math.min(k,arr.length-k);
         Arrays.sort(arr);
         int sk = 0;
         for (int i = 0; i < k; i++) {
             sk+=arr[i];
         }
         int sr = 0;
         for (int i = k; i < arr.length; i++) {
             sr+=arr[i];
         }

         return Math.abs(sr-sk);
     }


    /**
     * Bubble Sort
     * */
     private static void bubbleSort(int[] arr,int n){
         for (int i = 0; i < n ; i++) {
             for (int j = i+1; j < n ; j++) {
                 if(arr[j]<arr[i]){
                     swap(arr,i,j);
                 }
             }
         }

         for (int i:arr
              ) {
             System.out.print(i+ " ");
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
