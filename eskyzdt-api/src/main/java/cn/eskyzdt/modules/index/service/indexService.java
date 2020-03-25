package cn.eskyzdt.modules.index.service;

import cn.eskyzdt.modules.index.entity.IndexMsg;

import java.util.List;

/**
 * <p>
 * 首页留言表 服务类
 * </p>
 *
 * @author timber
 * @since 2020-03-25
 */
public interface indexService {

    /**
     * 展示首页信息
     * @return
     */
    List<IndexMsg> showMsg();
}
