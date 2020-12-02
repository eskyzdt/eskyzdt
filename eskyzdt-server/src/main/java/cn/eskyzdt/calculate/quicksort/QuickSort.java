package cn.eskyzdt.calculate.quicksort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {123,2,54,2415,215,12,154,364};
        quick(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void quick(int[] arr, int start, int end){
        if (start >= end) {
            return;
        }
        int midVal = arr[start];

        int left = start;
        int right = end;
        while(left < right) {
            while (arr[right] >= midVal && right > left) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] < midVal && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = midVal;

        // 中间下标,最终为left和right相等的位置
        int mid = left;

        quick(arr, start, mid - 1);
        quick(arr, mid + 1, end);


    }

}
