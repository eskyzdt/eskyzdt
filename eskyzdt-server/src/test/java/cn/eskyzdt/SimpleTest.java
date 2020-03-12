package cn.eskyzdt;

import org.apache.tomcat.jni.Local;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTest {
    class Base {

        private String baseName = "base";

        public Base() {

            callName();

        }

        public void callName() {

            System.out.println(baseName);

        }

    }


    class Sub extends Base {

        private String baseName = "sub";


        public void callName() {

            System.out.println(baseName);

        }

    }

    @Test
    public void test20200312() {
        LocalDateTime localDateTime = LocalDateTime.of(2020,3,12, 0,0,0);
        long l = localDateTime.toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(localDateTime);
        System.out.println(l);
    }


    @Test
    public void test20200311() {
        double random = Math.random();
        int radom = (int) ((Math.random() * 9 + 1) * 100000);
        System.out.println(random);
        System.out.println(radom);
    }


    @Test
    public void test20200305() {
        final DateFormat df = new SimpleDateFormat("yyyyMMdd,HHmmss");
        ExecutorService ts = Executors.newFixedThreadPool(100);
        for (; ; ) {
            ts.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //生成随机数，格式化日期
                        long l = new Random().nextLong();
                        Date date = new Date(Math.abs(l));
                        String format = df.format(date);
                        System.out.println(format);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            });
        }

    }


    @Test
    public void test120602() {
        String match = "^.{0,50}$";
        Pattern pattern = Pattern.compile(match);
        Matcher matcher = pattern.matcher("222dsfdsbDFADF222222222D222222");
        boolean matches = matcher.matches();
        System.out.println(matches);

        match = "^[0-9]{0,6}\\.[0-9]{0,2}|[0-9]{0,6}$";
        Pattern pattern2 = Pattern.compile(match);
        Matcher matcher2 = pattern2.matcher("123456.22");
        boolean matches2 = matcher2.matches();
        System.out.println(matches2);

    }

    @Test
    public void test120601() {
        String match = "^[A-Za-z0-9]{1,30}";
        Pattern pattern = Pattern.compile(match);
        Matcher matcher = pattern.matcher("222dsfdsbDFADF222222222D222222");
        boolean matches = matcher.matches();
        System.out.println(matches);
    }

    @Test
    public void test120501() {
        String match = "[0-9]{0,7}^9{7}|[0-9]{0,7}\\.[0-9]{0,9}";
        Pattern pattern = Pattern.compile(match);
        Matcher matcher = pattern.matcher("9999998");
        boolean matches = matcher.matches();
        System.out.println(matches);

        matches = Pattern.compile(match).matcher("222222222222").matches();
        System.out.println(matches);
    }

    @Test
    public void test120402() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }

    }

    @Test
    public void test120401() {
        int num = 2147483647;
        long temp = num + 2L;
        System.out.println(num);
    }

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
        System.out.println("两个时间相减为: " + (t2 - t1));
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
