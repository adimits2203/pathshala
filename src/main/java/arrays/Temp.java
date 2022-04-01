package arrays;

public class Temp
{

    public static void main(String[] args) {
        together(new int[]{9,9,9,8,9,8});
    }


    /**
     * Bring all the 8s together and 9s together
     * i/p: 898989
     * o/p: 888999
     * solution:
     * idea is to use two pointers to start from both the ends and replace the characters 'wrongly' placed
     * */
    private static void together(int[] arr){
        int l = 0;
        int r = arr.length-1;
        while(l <= r){
            if(arr[l]==8){
                l++;
            }
            if(arr[r]==9){
                r--;
            }
            if(l >= r){
                break;
            }
            if(arr[l]==9 && arr[r]==8){
                int t = arr[r];
                arr[r] = arr[l];
                arr[l] = t;
                l++;
                r--;
            }
        }
        for (int i: arr
             ) {
            System.out.print(i+ " ,");
        }
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
            if(i==0) break;
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
