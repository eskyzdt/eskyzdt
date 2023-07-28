////package cn.eskyzdt.modules.canal.service;
////
////import com.alibaba.otter.canal.client.CanalConnector;
////import com.alibaba.otter.canal.client.CanalConnectors;
////import com.alibaba.otter.canal.protocol.CanalEntry;
////import com.alibaba.otter.canal.protocol.Message;
//import org.apache.commons.collections4.MapUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.net.InetSocketAddress;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//
//
///**
// * canal监控数据
// *
// * @author dongtian
// * @since 2020-01-19
// */
//
//@Component
//public class SynWaybillTask {
//
//  /*  @Resource
//    private SynWaybillToCmsService synWaybillToCmsService;
//    @Resource
//    private ReceiptService receiptService;
//    @Resource
//    private IWaybillOperateRecordsService iWaybillOperateRecordsService;
//    @Resource
//    private QueryWaybillService queryWaybillService;
//
//    *//**
//     * 配置在nacos中
//     *//*
//    @Value("${canal.destination}")
//    private String destination;
//
//    @Value("${canal.host}")
//    private String host;
//
//    @Value("${dubbo.provider.version}")
//    private String version;
//
//    @PostConstruct
//    public void afterPropertiesSet() throws Exception {
//        // 只有线上的版本才执行同步任务,其他的不同步
//        if ("1.0".equals(version)) {
//            new Thread(this::waybillTask, "canalThread").start();
//        }
//
//    }
//*/
//    private void waybillTask() {
//        // 项目启动就会执行这个方法
//        // 创建链接
//      // CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(host, 11111), destination, "canal", "canal");
//       CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("193.168.1.1", 11111), "111", "canal", "canal");
//        // 这里的port是canal的默认端口, destination是canal的实例对象(由服务器上的一份配置文件实例化而成)
//        int batchSize = 500;
//        connector.connect();
//        // connector.subscribe("zeus4\\.waybill,zeus4\\.waybill_payment_info");
//        // 直接用服务器中配置的
//        connector.subscribe();
//        connector.rollback();
//        long batchId = 0;
//        while (true) {
//            try {
//                // 获取指定数量的数据,这个会抛异常,因为如果有多个连接被建立了,当前的batchId会被别的客户端读取,导致读不到的一个异常.
//                Message message = connector.getWithoutAck(batchSize, 10L, TimeUnit.SECONDS);
//                batchId = message.getId();
//                // log.info("batchId是: " + batchId);
//                // entries是获取到的数据集合
//                List<CanalEntry.Entry> entries = message.getEntries();
//                int size = entries.size();
//                if (batchId == -1 || size == 0) {
//                    continue;
//                } else {
//                    // 找出有变化的数据
//                    Map<String, List<String>> waybillIds = resolve(entries);
//                    List<String> update = MapUtils.getObject(waybillIds, "update");
//                    // 用set集合去个重
//                    HashSet<String> updateSet = new HashSet<>(update);
//                    List<String> delete = MapUtils.getObject(waybillIds, "delete");
//                    // 用set集合去个重
//                    HashSet<String> deleteSet = new HashSet<>(delete);
//                    if (!CollectionUtils.isEmpty(updateSet)) {
//                   //     this.synWaybillToCmsService.synWaybill(updateSet);
//                    }
//                    if (!CollectionUtils.isEmpty(deleteSet)) {
//                  //      this.synWaybillToCmsService.deleteWaybill(deleteSet);
//                    }
//                    // 提交确认
//                    connector.ack(batchId);
//                }
//            } catch (Exception e) {
//                // 抛个异常就重新连接
//                connector.disconnect();
//                connector.connect();
//                connector.subscribe();
//                connector.rollback();
//            }
//        }
//    }
//
//    /**
//     * 处理数据
//     *
//     * @param entries 待处理的数据
//     */
//    private Map<String, List<String>> resolve(List<CanalEntry.Entry> entries) {
//        // 存入用于新增和修改的数据
//        List<String> update = new LinkedList<>();
//        // 存放用于删除的数据
//        List<String> delete = new LinkedList<>();
//        // 一个map
//        Map<String, List<String>> result = new HashMap<>();
//
//        for (CanalEntry.Entry entry : entries) {
//            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
//                continue;
//            }
//            try {
//                CanalEntry.RowChange rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
//                // mysql的操作类型
//                CanalEntry.EventType eventType = rowChage.getEventType();
//                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
//                for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
//                    List<CanalEntry.Column> afterColumnsList;
//                    String waybillId;
//                    // 这里获取运单的id,返回map集合后调用一个异步的方法,来对数据进行封装
//                    if (eventType == CanalEntry.EventType.DELETE) {
//                        afterColumnsList = rowData.getBeforeColumnsList();
//                        CanalEntry.Column afterColumns = afterColumnsList.get(1);
//                        waybillId = afterColumns.getValue();
//                        delete.add(waybillId);
//                    } else {
//                        afterColumnsList = rowData.getAfterColumnsList();
//                        CanalEntry.Column afterColumns = afterColumnsList.get(0);
//                        waybillId = afterColumns.getValue();
//                        update.add(waybillId);
//                    }
//                }
//            } catch (Exception e) {
//               // log.info("ERROR ## resolve() error , data:" + entry.toString());
//            }
//        }
//        result.put("update", update);
//        result.put("delete", delete);
//        return result;
//    }
//
//
//
//}
