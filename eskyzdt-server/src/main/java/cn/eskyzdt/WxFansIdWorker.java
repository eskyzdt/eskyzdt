package cn.eskyzdt;

/**
 * 雪花算法, 用于生成公众号粉丝的昵称后缀.
 *
 * @author dongtian.zhang
 * @since 2023-11-02
 */
public class WxFansIdWorker {
    // 初始时间戳(纪年)，可用雪花算法服务上线时间戳的值
    // 1650789964886：2022-04-24 16:45:59
    private static final long INIT_EPOCH = 0;
    // 记录最后使用的毫秒时间戳，主要用于判断是否同一毫秒，以及用于服务器时钟回拨判断
    private long lastTimeMillis = -1L;
    // 最后12位，代表每毫秒内可产生最大序列号，即 2^12 - 1 = 4095
    private static final long SEQUENCE_BITS = 12L;
    // 掩码（最低12位为1，高位都为0），主要用于与自增后的序列号进行位与，如果值为0，则代表自增后的序列号超过了4095
    // 0000000000000000000000000000000000000000000000000000111111111111
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);
    // 同一毫秒内的最新序号，最大值可为 2^12 - 1 = 4095
    private long sequence;
    /**
     * 通过该方法生成分布式ID
     *   整个算法的流程：
     *     1.先获取当前时间戳到毫秒。
     *     2.当前时间戳-INIT_EPOCH时间（防止41位空间浪费）
     *     3.查看当前日期是否同一毫秒。是统一毫秒直接相加。不是同一毫秒的话直接新增。
     *     4.如果当前时间戳内生成的ID超过了4095，那么可以循环阻塞等待下一1毫秒在生成。
     *     5.如果服务器时间出现问题，回退了，这抛出异常。（时间回拨的问题）
     *  dataCenterId  机器中心ID
     * workerId      服务器ID
     * @return
     */
    public synchronized String getNextId() {
        long dataCenterId = 1L;
        long workerId = 1L;
        // 获取当前毫秒
        long currentTimeMillis = System.currentTimeMillis();
        // 5.如果服务器时间出现问题，回退了，这抛出异常。（时间回拨的问题）
        if (currentTimeMillis < lastTimeMillis) {
            throw new RuntimeException(
                    String.format("可能出现服务器时钟回拨问题，请检查服务器时间。当前服务器时间戳：%d，上一次使用时间戳：%d", currentTimeMillis,
                            lastTimeMillis));
        }
        if (currentTimeMillis == lastTimeMillis) {
            //4095+1 和 SEQUENCE_MASK & 得出的结果是0。
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                //4.如果当前时间戳内生成的ID超过了4095，那么可以循环阻塞等待下一1毫秒在生成。
                currentTimeMillis = getNextMillis(lastTimeMillis);
            }
        } else { // 不在同一毫秒内，则序列号重新从0开始，序列号最大值为4095
            sequence = 0;
        }
        // 记录最后一次使用的毫秒时间戳
        lastTimeMillis = currentTimeMillis;
        // 时间戳部分，currentTimeMillis - INIT_EPOCH 和 因为什么要左移，具体原因可以看我的上一篇Redis生成ID中有详细的解释
        long nextIdLong = ((currentTimeMillis - INIT_EPOCH) << 22)
                // 数据中心部分
                | (dataCenterId << 17)
                // 机器表示部分
                | (workerId << 12)
                // 序列号部分
                | sequence;
        String res = String.valueOf(nextIdLong);
        int length = res.length();
        if (length < 14) {
            return res;
        }
        return res.substring(length - 13 , length);
    }

    /**
     * 获取指定时间戳的接下来的时间戳，也可以说是下一毫秒
     * @param lastTimeMillis 指定毫秒时间戳
     * @return 时间戳
     */
    private long getNextMillis(long lastTimeMillis) {
        long currentTimeMillis = System.currentTimeMillis();
        while (currentTimeMillis <= lastTimeMillis) {
            currentTimeMillis = System.currentTimeMillis();
        }
        return currentTimeMillis;
    }

}
