package cn.eskyzdt;

import cn.eskyzdt.english.HighMath;
import cn.eskyzdt.modules.test.TestModel;
import cn.eskyzdt.modules.user.entity.User;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static cn.hutool.core.util.NumberUtil.add;

public class SimpleTest {


    @Test
    public void test0628() {
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal1.toString());
        System.out.println(bigDecimal.toString());


        System.out.println( 5 / 2);
        System.out.println(  5 / 3);

    }

    @Test
    public void test0620() {
        // 加入总进度
        BigDecimal progressMath = new BigDecimal("9.95");
    // 计算一下平均下载进度 eg. 20 50  100
    // 先乘100
        BigDecimal multiply = progressMath.multiply(new BigDecimal(100));
        BigDecimal divide = multiply
                // 再除以数量
                .divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_UP);
        String totalProgressAverage = divide.toString();
        System.out.println(totalProgressAverage);
    }

    @Test
    public void test0529() {
        int coreSize =10;
        ThreadPoolExecutor initTaskExecutor = new ThreadPoolExecutor(coreSize, coreSize, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(128));
            initTaskExecutor.execute(() -> HttpUtil.downloadFile("https://d90.gdl.netease.com/publish/green/yjwj_2023-04-28-15-20.zip", "D:\\"));
            initTaskExecutor.execute(() -> HttpUtil.downloadFile("https://d90.gdl.netease.com/publish/green/yjwj_2023-04-28-15-20.zip", "D:\\1"));
            initTaskExecutor.execute(() -> HttpUtil.downloadFile("https://d90.gdl.netease.com/publish/green/yjwj_2023-04-28-15-20.zip", "D:\\2"));
            initTaskExecutor.execute(() -> HttpUtil.downloadFile("https://d90.gdl.netease.com/publish/green/yjwj_2023-04-28-15-20.zip", "D:\\3"));
            initTaskExecutor.execute(() -> HttpUtil.downloadFile("https://d90.gdl.netease.com/publish/green/yjwj_2023-04-28-15-20.zip", "D:\\4"));
            initTaskExecutor.execute(() -> HttpUtil.downloadFile("https://d90.gdl.netease.com/publish/green/yjwj_2023-04-28-15-20.zip", "D:\\5"));
            initTaskExecutor.execute(() -> HttpUtil.downloadFile("https://d90.gdl.netease.com/publish/green/yjwj_2023-04-28-15-20.zip", "D:\\6"));
            initTaskExecutor.execute(() -> HttpUtil.downloadFile("https://d90.gdl.netease.com/publish/green/yjwj_2023-04-28-15-20.zip", "D:\\7"));

        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                System.out.println(ipt);
            }
        }
    }

    @Test
    public void test0510() {
        double a = 1;
        String s = String.valueOf(a);
        String format = String.format("%.2f", a);
        System.out.println(s);
        System.out.println(format);
        BigDecimal totalProgress = BigDecimal.ZERO;

        BigDecimal progressMath = new BigDecimal(1);
        BigDecimal progressMath2 = new BigDecimal(1);
        totalProgress = totalProgress.add(progressMath);
        totalProgress = totalProgress.add(progressMath2);
        String totalProgressAverage = totalProgress.multiply(new BigDecimal(100))
                // 再除以数量
                .divide(BigDecimal.valueOf(2), 0, RoundingMode.HALF_UP).toString();
        System.out.println(totalProgressAverage);
    }

    /**
     * 数字的正则^[0-9]*\.*[0-9]*$
     *
     */
    @Test
    public void test0315() {
        LocalDate localDate = LocalDate.of(2011, 12, 2);
        LocalDate now = LocalDate.now();
        boolean equal = localDate.isEqual(now);
        System.out.println(equal);
    }

    @Test
    public void test0309() {
        LocalTime a = LocalTime.of(23,34);
        int hour = a.getHour();
        int minute = a.getMinute();

        System.out.println("" + hour + minute);
        LocalTime b = LocalTime.of(0, 13);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("," +now);
        String s = "2021-3-19 23:59:59";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-M-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, df);

        System.out.println(parse);
        Duration between = Duration.between(a, b);
        long l = between.toMinutes();
        System.out.println(l);
    }

    @Test
    public void test0120() {
        BigDecimal bigDecimal = new BigDecimal("0.0006");
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal1);

        HashMap<String, Object> map = new HashMap<>();
        map.put("key", "4");
        Integer accountTypeTem = MapUtils.getInteger(map, "key");
        System.out.println(accountTypeTem);
    }


    private volatile char[] chars = new char[3];

    class TestObj {
        private String var;

        public String getVar() {
            return var;
        }

        public void setVar(String var) {
            this.var = var;
        }
    }

    @Test
    public void test210120() {
        TestObj obj = new TestObj();
        resolve(obj);
        System.out.println(obj.var);
    }

    public void resolve(TestObj a) {
        a.var = "333";
    }

    @Test
    public void test1218() {
        ArrayList<User> objects = new ArrayList<>();
        // 出来的不为null
        Map<String, List<User>> collect = objects.stream().collect(Collectors.groupingBy(User::getEmail));
        System.out.println(
        );
        collect.forEach((k,v)->{
            System.out.println();
        });
    }

    @Test
    public void test1211() {
            String[] split1 = "q131213,234234,12321".split(",");
            List<String> split = Arrays.asList(split1);

            String remove = split.remove(1);

            System.out.println(split.toString());

            // java 8之后可能用removeif
        // list.removeIf(next -> !isEmail(next));

    }

    @Test
    public void test1209() {
//        System.out.println(HighMath.BAOHAOXING.getKey());
        System.out.println(HighMath.ss);
    }

    /**
     * http返回值
     */
    @Test
    public void test1207(){
        ResponseEntity<String> s = new ResponseEntity<>("ssssssss", HttpStatus.NOT_FOUND);
        System.out.println(s);
        String body = s.getBody();
        System.out.println(body);
        HttpHeaders headers = s.getHeaders();
        HttpStatus statusCode = s.getStatusCode();
        int statusCodeValue = s.getStatusCodeValue();
        boolean b = s.hasBody();
        System.out.println(headers);
        System.out.println(statusCode);
        System.out.println(statusCodeValue);
        System.out.println(b);
    }

    @Test
    public void test1204(){
//        assert false;
//        System.out.println("a");

        TestModel.timeout = 1;
        TestModel.refreshMillis = 2;

        System.out.println(TestModel.getRefreshMillis());
    }

    @Test
    public void test071302() {
        int a = -3;
        a = a >> 1;
        System.out.println(a);
    }

    @Test
    public void test0713() {
        int arr[] = {3,234,23423,2314,-1,2,234,546,98,345,24,76,5678,67,587};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    void quickSort(int ar[], int left, int right){
        if (left >= right) {
            return;
        }
        int key = ar[left];
        int leftTem = left;
        int rightTem = right;
        while (leftTem < rightTem) {
            while (ar[rightTem] >= key && rightTem > leftTem) {
                rightTem--;
            }
            ar[leftTem] = ar[rightTem];
            while (ar[leftTem] <= key && leftTem < rightTem) {
                leftTem++;
            }
            ar[rightTem] = ar[leftTem];
        }
        ar[leftTem] = key;
        quickSort(ar, left, leftTem - 1);
        quickSort(ar, leftTem + 1, right);
    }

    @Test
    public void test0711(){
        System.out.println("dfsfe: %d" + 33);
    }

    @Test
    public void test061301() {
        // 打印数组时如果有个单独的\r,那么会导致打印时只打出一个\r,即回车
        chars[1] = '在';
        System.out.print(chars);
        // 加上\r会打印不出来
        chars[0] = '\r';
        chars[2] = '\n';
        System.out.println(chars);
        // 控制台会在打印下面语句运行结束后才打印数组.
        System.out.println("222222222222222222222222222222222222");
        System.out.println('\r');
    }

    @Test
    public void test051202() {
        System.out.println();


        String lfwsrxsj1K1F11024 = "LFWSRXSJ1K1F11024";
        int i = lfwsrxsj1K1F11024.hashCode();
        System.out.println(i);
    }

    @Test
    public void test051201() {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        String a = date.toString();
        Map m = new HashMap();
        m.put("d", date);
        System.out.println(m);
    }

    /**
     * 正则的知识点,如果加上^和$说明是匹配整个字符串是否符合,如果不加^和$那么会匹配字符串中的每一个
     */
    @Test
    public void test0512() {
        String load_weight = "43.234KGsdf";
        String regEx = "[0-9]*\\.[0-9]*|[0-9]*";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(load_weight);
        // 获取数字后的单位
        String unit = matcher.replaceAll("");
        // 把单位替换掉
        load_weight = load_weight.replace(unit, "");
    }

    @Test
    public void test050901() {
        try {
            System.out.println(File.createTempFile("df", "dd"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test0509() {
        String path = "";
        File test0509 = new File(path, "test0509.jpg22");
        String absolutePath = test0509.getAbsolutePath();
        System.out.println(absolutePath);
        try {
            test0509.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

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
            while (true) {
                if (b == !b) {
                    System.out.println(new Date() + ":" + count);
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
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
     */
    @Test
    public void test041302() {
        Map<String, Object> keyMap = new LinkedHashMap<>();
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 12; i++) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
            keyMap.put(date.format(dateTimeFormatter), "0");
            date = date.minusMonths(1);
        }
        keyMap.forEach((x, y) -> {
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
     /*   String match = "^.{0,100}$";
        Pattern pattern = Pattern.compile(match);
        Matcher matcher = pattern.matcher("221222222222122222");
        boolean matches = matcher.matches();
        System.out.println(matches);

        match = "^[0-9]{0,6}\\.[0-9]{0,2}|[0-9]{0,6}$";
        Pattern pattern2 = Pattern.compile(match);
        Matcher matcher2 = pattern2.matcher("123456.22");
        boolean matches2 = matcher2.matches();
        System.out.println(matches2);*/

        String fiftyWords = "^[()a-zA-Z\\u4e00-\\u9fa5]{0,50}$";
        Pattern pattern3 = Pattern.compile(fiftyWords);
        Matcher matcher3 = pattern3.matcher("jd(是在");
        boolean matches3 = matcher3.matches();
        System.out.println(matches3);

        String fiftyWords4 = "^.{0,50}$";
        Pattern pattern4 = Pattern.compile(fiftyWords4);
        Matcher matcher4 = pattern4.matcher("jd(是在afdacdc21d23d23d23d23f3123");
        boolean matches4 = matcher4.matches();
        System.out.println(matches4);


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
    public void test20201210() throws InterruptedException {

        Duration duration = Duration.between(null,LocalDateTime.now());
        System.out.println(duration.toMillis());

    }

        @Test
    public void test1114() throws InterruptedException {

        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.of("+8"));

        LocalDateTime before = LocalDateTime.of(2020,12,10,10,16);

            Period between = Period.between(before.toLocalDate(), offsetDateTime.toLocalDate());
            int years = between.getYears();
            System.out.println("period获取相差的年数"+ years);

            Duration duration = Duration.between(before,offsetDateTime);
        long days = duration.toDays(); //相差的天数
        long hours = duration.toHours();//相差的小时数
        long minutes = duration.toMinutes();//相差的分钟数
        long millis = duration.toMillis();//相差毫秒数
        long nanos = duration.toNanos();//相差的纳秒数
        System.out.println("计算两个时间的差：");
        System.out.println("起始时间："+ before);
        System.out.println("结束时间："+ offsetDateTime);
        System.out.println("相差天数" +days);
        System.out.println("相差小时" + hours);
        System.out.println("相差分钟" + minutes);




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

    @Test
    public void testFromInternet() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("系统当前日期+时间:" + localDateTime);
        LocalDate localDate = LocalDate.now();
        System.out.println("系统当期日期：" + localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println("系统当前时间：" + localTime);
        System.out.println("系统当前时间,去除毫秒：" + localTime.withNano(0));//0 为去除毫秒

        System.out.println("指定年、月、日、时、分、秒：" + LocalDateTime.of(2016, 11, 23, 9, 07, 59));//返回一个指定年、月、日、时、分、秒的时间，不可变
        System.out.println("指定年数的时间：" + localDateTime.withDayOfYear(1));//返回一个指定“一年中的天数,the day-of-year  ”的时间，不可变
        System.out.println("指定天数的时间：" + localDateTime.withDayOfMonth(1));//返回一个指定“一月中的天数,day-of-month ”的时间，不可变
        System.out.println("指定小时数的时间：" + localTime.withHour(1));//返回一个指定“一天中的小时数,the hour-of-day ”的时间，不可变
        System.out.println("指定分钟数的时间：" + localTime.withMinute(1));//返回一个指定“一小时的分钟数,the minute-of-hour ”的时间，不可变
        System.out.println("指定秒数的时间：" + localTime.withSecond(1));//返回一个指定“一分钟的秒数,the second-of-minute ”的时间，不可变
        System.out.println("the hour-of-day, from 0 to 23：" + localTime.getHour());//取得一天中的小时数
        System.out.println("minute-of-hour, from 0 to 59:" + localTime.getMinute());//取得一小时中的分钟数
        System.out.println("the second-of-minute, from 0 to 59:" + localTime.getSecond());//取的一分钟的秒数
        System.out.println("the nano-of-second, from 0 to 999,999,999:" + localTime.getNano());//取得一秒钟的纳秒数

        //日期运算
        System.out.println("系统当前时间减去1年：" + (localDate.minusYears(1)));
        //看看闰年和平年的区别
        LocalDateTime localDateTime1 = LocalDateTime.of(2016, 02, 29, 00, 00, 00);
        System.out.println("闰年减去一年：" + localDateTime1.minusYears(1));//减去一年后是平年，注意结果
        System.out.println("系统当前时间减去1天：" + (localDate.minusDays(1)));
        System.out.println("系统当前时间减去23天：" + (localDate.minusDays(23)));
        System.out.println("系统当前时间加上1年：" + (localDate.plusYears(1)));
        System.out.println("系统当前时间加上1天：" + (localDate.plusDays(1)));
        System.out.println("系统当前时间加上1分钟：" + (localDateTime.plusMinutes(1)));
        System.out.println("系统当前时间加上1纳秒：" + (localDateTime.plusNanos(1)));
        System.out.println("系统当前时间加上1周：" + (localDateTime.plusWeeks(1)));
        System.out.println("localDateTime 转 localDate:" + localDateTime.toLocalDate());

        LocalDateTime now2 = LocalDateTime.now();
        LocalDate localDate1 = now2.toLocalDate();
        System.out.println(localDate1);
        System.out.println("是否相等?");
        System.out.println(localDate1.isEqual(LocalDate.now()));

        System.out.println("localDateTime 转 localTime:" + localDateTime.toLocalTime());
        //格式器
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        System.out.println(LocalDateTime.parse("20111123 00:00:00", dateTimeFormatter));
        System.out.println(LocalDateTime.MIN);//支持的最小时间
        System.out.println(LocalDateTime.MAX);//支持的最大时间
        System.out.println(  LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));//把时间转为秒


        /**
         * 时间的调整器 TemporalAdjusters
         */
        LocalDate now = LocalDate.now();
        // 获取上周四
        TemporalAdjuster adjuster = TemporalAdjusters.previous(DayOfWeek.THURSDAY);
        LocalDate lastThursday = now.with(adjuster);
        LocalTime hourAndMinutes = LocalTime.of(9, 30);
        LocalDateTime fromTime = LocalDateTime.of(lastThursday, hourAndMinutes);
        LocalDateTime toTime = fromTime.plusWeeks(1);
    }

}
