package cn.eskyzdt.modules.waybill;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * <p>
 * 批量运单功能模块
 * </p>
 *
 * @author dongtian
 * @since 2019-11-25
 */
@RestController
@RequestMapping("/iWaybill")
public class IWaybillBatchController {

    @RequestMapping("/createWaybillBatch")
    public String createWaybillBatch(@RequestParam("file") MultipartFile fileVo) {
        // easyPoi导入文件
        ImportParams params = new ImportParams();
        // 多读取一行,如果超过就提醒
        params.setReadRows(3001);
        try {
            InputStream ins = fileVo.getInputStream();
            List<WaybillImportVo> list = ExcelImportUtil.importExcel(ins, WaybillImportVo.class, params);
            if (list.size() > 3000) {
                return new String("最多只支持3000条");
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (checkFieldAllNull(list.get(i))) {
                    list.remove(i);
                    continue;
                }
            }
            System.out.println(list);
        } catch (Exception e) {
            return new String("系统繁忙,请稍后再试" + e.toString());
        }
        return new String("ddd");
    }

    private boolean checkFieldAllNull(Object object) throws IllegalAccessException {
        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (Modifier.isFinal(f.getModifiers()) && Modifier.isStatic(f.getModifiers())) {
                continue;
            }
            if (!isEmpty(f.get(object))) {
                return false;
            }
            f.setAccessible(false);
        }
        return true;
    }

    private static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String && (object.toString().equals(""))) {
            return true;
        }
        if (object instanceof Object[] && ((Object[]) object).length == 0) {
            return true;
        }
        return false;
    }
}

