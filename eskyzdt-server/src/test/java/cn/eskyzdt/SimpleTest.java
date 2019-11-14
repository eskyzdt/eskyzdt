package cn.eskyzdt;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class SimpleTest {

    @Test
    public void test1114() {
        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.of("+8"));
        System.out.println(offsetDateTime);
        int hour = offsetDateTime.getHour();
        System.out.println(hour);
        long t1 = now.getEpochSecond();
        ZoneOffset offset = offsetDateTime.getOffset();
        System.out.println(t1);
        System.out.println(offset);

        long t2 = offsetDateTime.toEpochSecond();
        System.out.println(t2);
        System.out.println("两个时间相减为: " + (t2-t1));
        System.out.println("不同时区的时间转换为epochsecond时,这两个数是相等的");
    }

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
