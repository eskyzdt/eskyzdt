package cn.eskyzdt.kaoyan.table;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 顺序表的操作
 */
public class Table {

    public static int[] arrays = {10, 20, 30, 40, 50, 60, 70, 80};

    public static void main(String[] args) {
        System.out.println("输入一个数:");
        String i = null;
        do {
            i = scanStart();
        } while (!matchPatter("[\\d]+"));
        System.out.println("当前输入的数字为: " + i);
        // 位置设置为最后一位
        int tem = arrays.length;
        for (int j = 0; j < arrays.length; j++) {
            if (arrays[j] > Integer.valueOf(i)) {
                tem = j;
                break;
            }
        }
        System.out.println("数组中有" + arrays.length + "个数,输入数字的位置在" + tem);
        System.out.print("插入前数组:");
        for (int array : arrays) {
            System.out.print(array + " ");
        }
        System.out.println();
        System.out.print("插入后数组:");
        // 第一种移位方法
        // int[] input = input(arrays, tem, Integer.valueOf(i));
        // 第二种移位方法
        // int[] input = inputTwo(arrays, tem, Integer.valueOf(i));
        // 第三种
        int[] input = inputThree(arrays, tem, Integer.valueOf(i));
        for (int i1 : input) {
            System.out.print(i1 + " ");
        }
    }

    /**
     * 重新排序的方法1
     *
     * @param array
     * @param location
     * @param num
     * @return
     */
    static int[] input(int[] array, int location, int num) {
        int newLength = array.length + 1;
        int[] newArray = new int[newLength];
        for (int i = 0; i < location; i++) {
            newArray[i] = array[i];
        }
        newArray[location] = num;
        for (int i = location + 1; i < newLength; i++) {
            newArray[i] = array[i - 1];
        }
        return newArray;
    }

    /**
     * 重新排序的方法2
     *
     * @param array
     * @param location
     * @param num
     * @return
     */
    static int[] inputTwo(int[] array, int location, int num) {
        int length = array.length;
        int newLength = length + 1;
        int[] newArray = new int[newLength];
        // 复制数组
        System.arraycopy(array, 0, newArray, 0, length);

        for (int i = newLength - 1; i >= 0; i--) {
            if (i == location) {
                newArray[i] = num;
                break;
            }
            newArray[i] = newArray[i - 1];
        }
        return newArray;
    }

    // 方法3
    static int[] inputThree(int[] array, int location, int num) {
        int length = array.length;
        int newLength = length + 1;
        int[] newArray = new int[newLength];
        // 复制数组
        System.arraycopy(array, 0, newArray, 0, length);

        // 优化的部分,省去了判断,只移动从最末到location的位置
        for (int i = newLength - 1; i > location; i--) {
            newArray[i] = newArray[i - 1];
            /**
            if (i == location) {
                newArray[i] = num;
                break;
            }
            newArray[i] = newArray[i - 1];
             **/
        }
        newArray[location] = num;
        return newArray;
    }


    static boolean matchPatter(String rule) {
        String toBeCompare = scanStart();
        boolean matches = Pattern.matches(rule, toBeCompare);
        return matches;
    }

    static String scanStart() {
        Scanner scanner = new Scanner(System.in);
        String i = scanner.next();
        return i;
    }

}
