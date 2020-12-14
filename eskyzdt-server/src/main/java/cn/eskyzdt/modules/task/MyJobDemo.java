package cn.eskyzdt.modules.task;


import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;

/// 作业调度
public class MyJobDemo {

    public static void main(String[] args) {

    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("172.16.0.10:2181", "my-job"));
        regCenter.init();
        return regCenter;
    }

    private static SimpleJobConfiguration createJobConfiguration() {
        MyJob myJob = new MyJob();
        // 创建作业配置
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(
                JobCoreConfiguration.newBuilder(myJob.getClass().getName(), "0/5 * * * * ?", 3)
                        .shardingItemParameters("0=A,1=B,2=C").build(), myJob.getClass().getCanonicalName());
        return simpleJobConfiguration;
    }
}