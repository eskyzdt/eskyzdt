package cn.eskyzdt.modules.index.dao;

import cn.eskyzdt.modules.index.entity.IndexMsg;

import java.util.List;

/**
 * <p>
 * 首页留言表 Mapper 接口
 * </p>
 *
 * @author timber
 * @since 2020-03-25
 */
public interface IndexDao {

    List<IndexMsg> showMsg();

}
