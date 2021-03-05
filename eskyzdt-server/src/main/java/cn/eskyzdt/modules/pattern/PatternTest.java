package cn.eskyzdt.modules.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    private static final Pattern emailRegex = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    private static final Pattern emailPrefixRegex = Pattern.compile("[^@]+");

    public static void main(String[] args) {
        String email = "xxvzs89@saf.sdf";
        Matcher matcher2 = emailRegex.matcher(email);
        Matcher matcher3 = emailPrefixRegex.matcher(email);
        String prefixEmail;
        boolean b1 = matcher3.find();
        if (b1) {
            prefixEmail = matcher3.group(0);
            int length = prefixEmail.length();
            if (length <= 4) {
                email = email.replaceFirst(prefixEmail, "****");
            } else {
                length = (length - 3) / 2;
                // 替换中间的4个
                String regex = prefixEmail.substring(length, length + 4);
                email = email.replaceFirst(regex, "****");
            }
        }







        Matcher matcher = emailRegex.matcher("234sdfsdf@sinc@fsdf,vs");
        // find 是只要有就行
        boolean b = matcher.find();

        // 如果想要用group, 必须先用find.  或用matches全字匹配,
        // 因为如果是false的话后面用group也会报错,所以都会加个if else
        if (matcher.find()) {
            String group = matcher.group(0);
        }
        // 没能匹配多个的话也会报错
        String group1 = matcher.group(1);
        // 如果是直接这种, 会报错
        //    String group3 = emailRegex.matcher("234sdfsdf@sinc@gsfsg,vs").group(1);


        // matches是全字匹配
        boolean c = emailRegex.matcher("234sdfsdf@sinc@").matches();
        // pattern也有个matches, 也是全字匹配
        boolean matches = Pattern.matches(".+@", "234sdfsdf@sinc@");
        boolean matches2 = Pattern.matches(".+@", "234sdfsdf@sinc@sdffsd");
    }

}
