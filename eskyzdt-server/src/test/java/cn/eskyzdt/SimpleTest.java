package cn.eskyzdt;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTest {

    @Test
    public void test0429() {
        assert true;
        System.out.println("断言1没有问题，Go！");

        System.out.println("\n-----------------\n");

        //断言2结果为false,程序终止
        assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题，Go！");

    }

    @Test
    public void test0428() {
        int a = 1;
        byte b = 127;
        short c = 32767;
        System.out.println(b);


    }

    @Test
    public void test042302() {
        boolean b = false;
        int count = 0;

            new Thread(() -> {
                while (true){
                    if(b == !b){
                        System.out.println(new Date()+":"+count);
                    }
                }
            }).start();
            new Thread(() -> {
                while (true)
                {
                 //   b=!b;
                }
            }
            ).start();
    }

    @Test
    public void test042301() {
        String imageObj = "http://cn-cms.oss-cn-beijing.aliyuncs.com/images/202004231056/tmp_bdcc73027c6c04e34af83bb78c6b1e8d28f0249ad8873941.jpg,http://cn-cms.oss-cn-beijing.aliyuncs.com/images/202004231056/tmp_0a9d2800915f1cf2d95cec04da5d46a2c038673b94122b80.jpg,http://cn-cms.oss-cn-beijing.aliyuncs.com/images/202004231056/tmp_6d371083bfec63be788b17beca111adf2e7d7d4cf63575d6.jpg,http://cn-cms.oss-cn-beijing.aliyuncs.com/images/202004231056/tmp_43ec30c864249fe9690ca673c1724e8d5dff20d36f29daf4.jpg";
        imageObj = imageObj.replaceAll(",", "@-@");
        System.out.println(imageObj);
    }

    /**
     * java8的 forEach语法糖
     *
     */
    @Test
    public void test041302() {
        Map<String, Object> keyMap = new LinkedHashMap<>();
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 12; i++) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
            keyMap.put(date.format(dateTimeFormatter) , "0");
            date = date.minusMonths(1);
        }
        keyMap.forEach( (x,y) -> {
            System.out.print(x);
            System.out.print(":");
            System.out.print(y);
            System.out.println();
        });

        TreeSet<String> strings = new TreeSet<>();
        strings.add("1");
        strings.add("2");
        // 这两个效果一样
        strings.forEach(System.out::println);
        strings.forEach(x -> System.out.println(x));

        // System.out.println(keyMap);

    }


    @Test
    public void test0413() {
        LinkedList<Map<String, Object>> keyList = new LinkedList<>();
        Map<String, Object> keyMap = new HashMap<>();
        keyMap.put("count", "0");
        List<Map<String, Object>> firstMem = new LinkedList<>();
        List<Map<String, Object>> secondMem = new LinkedList<>();
        List<Map<String, Object>> customer = new LinkedList<>();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 12; i++) {
            keyMap.put("date", date.format(dateTimeFormatter));
            date = date.minusMonths(1);
            keyList.add(new HashMap<>(keyMap));
        }
        System.out.println(keyList);
    }

    @Test
    public void test0408() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("account", "sss");
        map.put("sign", "ssadgdsfg");
        map.put("encrypt", "sdfsdfsdf");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE));
        HttpEntity<Object> strEntity = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.postForObject("dffsdf", strEntity, JSONObject.class);
    }


    @Test
    public void test0402() {
        List a = new LinkedList();
        List b = new ArrayList();
        boolean b1 = a instanceof List;

    }

    @Test
    public void test0318() {
        String loadTime = "2020-12-11 12:11:11";
        String substring = loadTime.substring(0, loadTime.length() - 2);
        System.out.println(substring);

        List<String> s = new LinkedList<>();
        s.add(0, "sa");
        s.set(0, "sb");
        System.out.println(s);
    }

    @Test
    public void test120602() {
        String match = "^.{0,100}$";
        Pattern pattern = Pattern.compile(match);
        Matcher matcher = pattern.matcher("221222222222122222");
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
        String match = "\\d{11}";
        Pattern pattern = Pattern.compile(match);
/*        Matcher matcher = pattern.matcher("222222222222");
        boolean matches = matcher.matches();
        System.out.println(matches);
         matches = Pattern.compile(match).matcher("222222222222").matches();*/

 /*       String match2 = "^([\\u4E00-\\u9FA5]|[.]|\\s){0,20}$";
        Pattern pattern2 = Pattern.compile(match2);
        Matcher matcher2 = pattern2.matcher("是是是是是 x     是是是.");
        System.out.println(matcher2.matches());
*/
        /*
        String match3 = "^.{0,20}$";
        Pattern pattern3 = Pattern.compile(match3);
        Matcher matcher3 = pattern3.matcher("是是是是是是是是是是是是是是");
        System.out.println(matcher3.matches());*/

       /* String match4 = "^.*[A-Za-z]+.*$";
        Pattern pattern4 = Pattern.compile(match4);
        Matcher matcher4 = pattern4.matcher("在的的");
        System.out.println(matcher4.matches());*/

  /*      String match5 = "^1[3-9]\\d{9}$";
        Pattern pattern5 = Pattern.compile(match5);
        Matcher matcher5 = pattern5.matcher("03999999999");
        System.out.println(matcher5.matches());*/

        String match2 = "[1-9][0-9]{0,6}";
        Pattern pattern2 = Pattern.compile(match2);
        Matcher matcher2 = pattern2.matcher("1122222");
        System.out.println(matcher2.matches());

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
    public void test1114() throws InterruptedException {
        Instant now = Instant.now();
        System.out.println(now);
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.of("+8"));
        System.out.println(offsetDateTime);
        int hour = offsetDateTime.getHour();
        System.out.println(hour);
        long t1 = now.getEpochSecond();
        Thread.sleep(1000);
        ZoneOffset offset = offsetDateTime.getOffset();
        System.out.println(t1);
        System.out.println(offset);

        OffsetDateTime offsetDateTime2 = Instant.now().atOffset(ZoneOffset.of("+8"));
        long t2 = offsetDateTime2.toEpochSecond();
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

    @Test
    public void test0224() {
        String a = new String("3.33");
        Integer integer = Integer.valueOf(a);
        System.out.println(integer);

    }
}
