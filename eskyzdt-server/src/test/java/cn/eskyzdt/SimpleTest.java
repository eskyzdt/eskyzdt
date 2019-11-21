package cn.eskyzdt;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class SimpleTest {

    @Test
    public void test1121() {
        ZoneId of = ZoneId.of("+8");
        ZoneId of2 = ZoneId.of("-2");
        ZoneId mit = ZoneId.of("Asia/Ho_Chi_Minh");
        System.out.println(of + "ddd" + of2 + "ddd" + mit);

        OffsetDateTime now = OffsetDateTime.now(of);
        OffsetDateTime now2 = OffsetDateTime.now(of2);
        OffsetDateTime now3 = OffsetDateTime.now(mit);
        System.out.println(now);
        System.out.println(now2);
        System.out.println(now3);
    }

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
