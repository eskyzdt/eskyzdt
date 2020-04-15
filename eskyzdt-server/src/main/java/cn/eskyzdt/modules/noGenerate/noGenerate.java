package cn.eskyzdt.modules.noGenerate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * 随机数生成类
 */
public class noGenerate implements Runnable {

    private volatile Set<String> noList = new HashSet<>();
    private SnowflakeDistributeId snowflakeDistributeId = new SnowflakeDistributeId(1,2);

    public static void main(String[] args) {
       noGenerate noGenerate = new noGenerate();
        for (int i = 0; i < 100; i++) {
            new Thread(noGenerate).start();
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            StringBuffer id = new StringBuffer("F");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String format = dateTimeFormatter.format(LocalDateTime.now());
            int random = (int) snowflakeDistributeId.nextId();
            String s1 = String.valueOf(random);
            String substring = s1.substring(s1.length() - 6, s1.length());
            // System.out.println(substring);
            // 日期14位
            id.append(format);
            // 随机6位小数
            id.append(substring);
            String s = id.toString();
            noList.add(s);
        }
        System.out.println(noList.size());
    }
}
