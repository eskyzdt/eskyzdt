package cn.eskyzdt.modules.test;


public class TestModel {

    public static String getSecretKey() {
        return secretKey;
    }

    public static void setSecretKey(String secretKey) {
        TestModel.secretKey = secretKey;
    }

    public static Integer getTimeout() {
        return timeout;
    }

    public static void setTimeout(Integer timeout) {
        TestModel.timeout = timeout;
    }

    public static Integer getRefreshMillis() {
        return refreshMillis;
    }

    public static void setRefreshMillis(Integer refreshMillis) {
        TestModel.refreshMillis = refreshMillis;
    }

    /**
     * 加密后的key，数据存放在的配置中心
     */
    public static String secretKey;

    /**
     * 超时时间，数据存放在的配置中心
     */
    public static Integer timeout;

    /**
     * 刷新token的预警时间，数据存放在的配置中心
     */
    public static Integer refreshMillis;


}
