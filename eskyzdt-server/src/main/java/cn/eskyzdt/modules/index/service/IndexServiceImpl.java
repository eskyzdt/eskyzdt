package cn.eskyzdt.modules.index.service;

import cn.eskyzdt.modules.index.dao.IndexDao;
import cn.eskyzdt.modules.index.entity.IndexMsg;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 首页留言表 服务实现类
 * </p>
 *
 * @author timber
 * @since 2020-03-25
 */
public class IndexServiceImpl implements indexService {

    @Resource
    private IndexDao indexDao;

    @Override
    public List<IndexMsg> showMsg() {
        return indexDao.showMsg();
    }
}
