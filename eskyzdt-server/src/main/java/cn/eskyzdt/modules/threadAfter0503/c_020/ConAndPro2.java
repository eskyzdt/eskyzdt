package cn.eskyzdt.modules.threadAfter0503.c_020;

public class ConAndPro2 {

    private Integer[] list = new Integer[10];

    Integer getList() {
        synchronized (this) {
            if (size == -1) {
                System.out.println("已经取完了");
            } else {
                size--;
            }
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return list[size];
        }
    }

    private int size = 0;

    private void putList(int num) {
        synchronized (this) {
            if (size == 10) {
                System.out.println("已经满了");
            } else {
                size++;
                list[size] = num;
            }
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        int i = 1, j =2, k;
        k = i / j ;

        System.out.println("%d" +  k);

    }

}
