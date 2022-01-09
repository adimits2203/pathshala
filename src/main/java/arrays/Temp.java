package arrays;

public class Temp
{

    public static void main(String[] args) {
        int[] arr = new int[]{6,3,2,5,11,7};
      quickSort(arr,0,5);
        System.out.println(arr);
    }


    /**
     * quick sort
     * idea is to partition the array based in pivot and put all elements lesser than pivot on the left and all the elements greater than pivot to the right of the pivot
     * */
    private static void quickSort(int[] arr, int left, int right){
        if(left==right) return;
        if(left < right){
            int pivotIndex = partition(arr, left, right);
            quickSort(arr,left,pivotIndex-1);
            quickSort(arr,pivotIndex+1, right);
        }
        return;
    }

    private static int partition(int[] arr, int left, int right){
        if(left==right) return left;
        int pivotIndex = -1;
        int[] lesserArr = new int[arr.length];
        int[] greaterArr = new int[arr.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int pivot = arr[left];
        for(int i =left+1;i<=right;i++){
            if(arr[i]<=arr[left]){
                lesserArr[leftIndex++] = arr[i];
            }
            else{
                greaterArr[rightIndex++] = arr[i];
            }
        }
        int masterIndex = left;
        for(int i:lesserArr){
            if(i==0) break;;
            arr[masterIndex++] = i;
        }
        pivotIndex = masterIndex;
        arr[masterIndex++] = pivot;
        for (int i:greaterArr
             ) {
            if(i==0) break;
            arr[masterIndex++]=i;
        }
        return pivotIndex;
    }
}
