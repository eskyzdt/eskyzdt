package cn.eskyzdt.modules.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class MyJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        int shardingItem = context.getShardingItem();
        switch (shardingItem) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                // do something by sharding item 1
                System.out.println("1");
                break;
            case 2:
                // do something by sharding item 2
                System.out.println("2");
                break;
            // case n: ...
            default:
                break;
        }
    }


}
