package cn.eskyzdt;

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
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimTest {

    //第一次提交

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void test0623() {
        for (int i = 0; i < 200; i++) {
            userService.threadTest();
        }
        try {
            TimeUnit.SECONDS.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test112601() {
        String a = (String) null;
        System.out.println(a);
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
     /*   Date createTime = user.getCreateTime();*/
    }


}
