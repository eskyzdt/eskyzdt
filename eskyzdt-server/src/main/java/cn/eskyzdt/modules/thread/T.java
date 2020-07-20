package cn.eskyzdt.modules.thread;

import com.alibaba.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class T {
    //volatile static Person t =new Person();
    ThreadFactory threadFactory = new ThreadFactoryBuilder().build();

    ExecutorService poolExecutor = Executors.newSingleThreadExecutor();

/*    private ExecutorService executor = new ThreadPoolExecutor(
            20,
            200,
            60,
            TimeUnit.SECONDS,
            ArrayBlockingQueue.class,
            new ArrayBlockingQueue<T>()
            );*/

    static ThreadLocal<Person> t = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Person p1 = new Person();
                p1.name = "zhangsan";
                t.set(p1);
                TimeUnit.SECONDS.sleep(5);
                //这里虽然睡了很久,如果不用ThreadLocal,那么会变为lisi
                //但实际上打印依然为zhangsan
                //说明这里每个线程中所用的变量,都是自己用的
                //要注意的地方是
                //ThreadLocal有可能会产生内存溢出的问题
                //### Error updating database.  Cause: java.sql.SQLException: Column count doesn't match value count at row 1### The error may exist in URL [jar:file:/zeus/waybill-server/waybill-server.jar!/BOOT-INF/classes!/v4/waybill/IWaybillDao.xml]### The error may involve defaultParameterMap### The error occurred while setting parameters### SQL: INSERT INTO waybill (                       id,             waybillNo,             customizedNo,             projectId,             lineId,             customerId,             uid,             node,             driverLeaderId,             driverId,             driverName,             carId,             carNumber,             status,             createUser,             createTime,             planDispatchTime,             loadTime,             unloadTime,             distance,             payMethod,             isReceipt,             remark,             receiptRemark,             dispatchType,             loadTimeConfirm,             loadTimeSource,             unloadTimeConfirm,             unloadTimeSource,             senderId,             senderCompany,             senderName,             senderProvinceId,             senderProvince,             senderCityId,             senderCity,             senderDistrictId,             senderDistrict,             senderDetail,             senderContactName,             senderContactPhone,             receiverId,             receiverCompany,             receiverName,             receiverProvinceId,             receiverProvince,             receiverCityId,             receiverCity,             receiverDistrictId,             receiverDistrict,             receiverDetail,             receiverContactName,             receiverContactPhone,             `type`               )         VALUES                        (             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?,             ?             )### Cause: java.sql.SQLException: Column count doesn't match value count at row 1; bad SQL grammar []; nested exception is java.sql.SQLException: Column count doesn't match value count at row 1
                System.out.println(t.get().name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.set(new Person());
            System.out.println(t.get().name);
        }).start();
    }


    static class Person {
        String name = "lisi";
    }
}
