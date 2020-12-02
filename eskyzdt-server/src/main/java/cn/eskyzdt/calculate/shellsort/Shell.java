package cn.eskyzdt.calculate.shellsort;

public class Shell {

    public static void main(String[] args) {
        int[] arr = {234,534,7,867,563,2,534521,14};
        ShellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    private static int[] ShellSort(int[] arr) {
        int len = arr.length;
        int gap = len >>> 1;

        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                change(arr, i, gap + i);
            }
            gap = gap >>> 1;
        }
        return arr;
    }

    private static void change(int[] arr,int a, int b) {
        if (arr[a] > arr[b]) {
            int tem = arr[a];
            arr[a] = arr[b];
            arr[b] = tem;
        }
    }
}
