package cn.eskyzdt;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTest {

    @Test
    public void test1111() {
        int row = 0;
        int count = 0;
        for (int i = 0; i < 100; i++) {
            System.out.print(i + 1 + " ");        //打印每一个
            count++;
            if (count > row) {
                System.out.println();
                row++;
                count = 0;
            }
        }
    }
}
