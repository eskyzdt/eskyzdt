package cn.eskyzdt;

import cn.eskyzdt.modules.pic.entity.Pic;
import cn.eskyzdt.modules.user.dao.UserDao;
import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.entity.UserDto;
import cn.eskyzdt.modules.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)

@SpringBootTest
public class TimTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void Test01() {
        Pic byId = userDao.findById2(1);
        //   User byId = userService.findById(1);
        System.out.println(byId);

    }

    @Test
    public void InstanceOfTest() {
        Object a = new LinkedHashMap();
        boolean b = a instanceof Map;
        System.out.println(b);
    }

    @Test
    public void ByteTest() {
        byte a = 127;
        a += 1;
        System.out.println(
                a
        );
        int b = 2124224242;
        //byte是8位,int是32位,强制转换后会只取int的后面8位
        a = (byte) b;
        System.out.println(b);
        System.out.println(a);
    }

    @Test
    public void IteratorTest() {
        //java采用迭代器模式能在不暴露集合对象内部元素的情况下，对元素进行访问
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);
        Iterator<Integer> iterator = a.iterator();
        for (Iterator b = a.iterator(); b.hasNext(); ) {
            Object next = b.next();
            System.out.println(next);
        }
    }

    @Test
    public void MApTEst() {
        Map m = new HashMap();
        m.put("1", "1");
        m.put("2", "2");
        m.put("3", "3");
        m.put("4", "4");
        Set set = m.entrySet();
        System.out.println(set);
    }

    @Test
    public void TimeTEst() {
        LocalDateTime l1 = LocalDateTime.now();
        System.out.println(l1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //java8的时间类要用下面这个新的格式化器才行
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = d.format(l1);

        System.out.println(format);

        System.out.println(LocalDateTime.MIN);//支持的最小时间
        System.out.println(LocalDateTime.MAX);//支持的最大时间
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
        System.out.println("localDateTime 转 localTime:" + localDateTime.toLocalTime());
        //格式器
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        System.out.println(LocalDateTime.parse("20111123 00:00:00", dateTimeFormatter));
        System.out.println(LocalDateTime.MIN);//支持的最小时间
        System.out.println(LocalDateTime.MAX);//支持的最大时间
    }


    @Test
    public void Test1028(){
        User user = new User();
        user.setUsername("sss");
        user.setPassword("ddd");
        user.setPhone("15155555555");
        user.setEmail("xcv@sdgsd");

        User user2 = new User();
        user2.setUsername("sss");
        user2.setPassword("ddd");
        user2.setPhone("15155555555");
        user2.setEmail("xcv@sdgsd");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        boolean b = userService.batchInsertUser(users);
        System.out.println(b);

    }

    @Test
    public void test1029 (){
        Map<String, Object> params = new HashMap<>();
        String[] pa = new String[]{"1","2","3"};
        params.put("id", pa);
        List<User> users = userService.queryUser(params);
        System.out.println(users);
    }

    @Test
    public void test1029a(){
        LocalDateTime birth = LocalDateTime.of(1994, 12, 13, 20, 10, 0);
        System.out.println(birth);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dtf.format(birth);
        System.out.println(format);

        System.out.println(LocalDateTime.MIN);
        System.out.println(LocalDateTime.MAX);

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = birth.atZone(zone);
        System.out.println(zonedDateTime);
        Instant instant = birth.atZone(zone).toInstant();
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());

        Year s = Year.now();
        System.out.println(s);
    }


    @Test
    public void test1031() {
        UserDto u = new UserDto();
        u.setId(1);
        UserDto user = userService.findUser(u);
        Date createTime = user.getCreateTime();

    }

}
