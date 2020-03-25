package cn.eskyzdt.modules.controller;

import cn.eskyzdt.modules.index.dao.IndexDao;
import cn.eskyzdt.modules.index.entity.IndexMsg;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private IndexDao indexDao;

    /*  @RequestMapping("/")
      public void index(HttpServletResponse response) throws IOException {
          response.sendRedirect("index");
      }*/

    // 在配置文件引用zeus的情况下,这里的值为eee,因为springboot读取配置文件是由上到下的
    // 以下面新出来的为准
    @Value("${fugai.sss}")
    private String value;

    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/index2")
    @ResponseBody
    public String showIndex2() {
        return this.value;
    }

    @RequestMapping("/msg")
    @ResponseBody
    public List<IndexMsg> showMsg() {
        return indexDao.showMsg();
    }
}