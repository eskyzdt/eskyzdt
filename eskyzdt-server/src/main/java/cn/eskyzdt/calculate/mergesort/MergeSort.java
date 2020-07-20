package cn.eskyzdt.calculate.mergesort;

public class MergeSort {

    public static void main(String[] args) {
        int[]  arr= {234, 546, 23423, 574, 534, 2375,453,34,2345,3,3262,23,234,234,253,67,35,32,23,89,3,23,2,4,564,4};
        int[] result = new int[arr.length];
        sort(arr, result, 0, arr.length - 1);
        // 打印排序的结果数组即可
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start;
        // >>>是无序号右移
        int mid = (len >>> 1) + start;

        // 把数字分为一左一右两个区间
        int start1 = start;
        int start2 = mid + 1;

        // 对子区间也进行分割,直到上面的start>=end条件生效
        sort(arr, result, start, mid);
        sort(arr, result, start2, end);

        // 这里需要从start开始,因为是递归的小循环
        int tem = start;
        while (start1 <= mid && start2 <= end) {
            // 注意这里是把arr的数据往result中放
            result[tem++] = arr[start1] <= arr[start2] ? arr[start1++] : arr[start2++];
        }
        // 上面的小循环结束后存在有start1没放完或者start2没放完,所以需要下面的循环
        while (start1 <= mid) {
            result[tem++] = arr[start1++];
        }
        while (start2 <= end) {
            result[tem++] = arr[start2++];
        }
        // 上面都是对result进行排序,排序完需要把arr按照result改变
        // result只是一个暂存数组,用于把当前循环的数字排序好存入
        // 存入后则从下标start到下标end是已排序好的
        // 故只需要把原数组的这几个数改变即可
        for (int i = start; i <= end; i++) {
            arr[i] = result[i];
        }

    }
}
