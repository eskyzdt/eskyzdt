package cn.eskyzdt.modules.junjun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 待处理的数据
        // 君君这里的data改成你从数据库中查出的
        ArrayList<ResponseVo> data = createData();
        // 获取第一级
        LinkedList<Result> results = new LinkedList<>();
        for (ResponseVo var : data) {
            String code = var.getCode();
            String bigType = var.getBigType();
            if (code.endsWith("0000")) {
                Result result = new Result();
                result.setCode(code.substring(0,2));
                result.setType(bigType);
                // 放入结果集
                results.add(result);
            }
        }
        // 递归获取子集
        for (int i = 0; i < results.size(); i++) {
            Result tem = results.get(i);
            getChildren(tem, data, 1);
        }
        // 打印结果
        System.out.println(results);
    }

    private static void getChildren(Result param, ArrayList<ResponseVo> todo, Integer level) {
        // 满足条件才递归
        if (level < 3) {
            // 业务逻辑根据param找出下级
            List<Result> childrenList = new LinkedList<>();
            String code = param.getCode();
            switch (level) {
                case 1:
                    String subVar1 = code.substring(0, 2);
                    for (ResponseVo tem : todo) {
                        String temCode = tem.getCode();
                        // 找到以subVar1开头且结尾为00的, 且不能是他自己
                        if (temCode.startsWith(subVar1) && temCode.endsWith("00") && !temCode.equals(code)) {
                            Result result = new Result();
                            result.setType(tem.getMidType());
                            result.setCode(temCode.substring(0,4));
                            childrenList.add(result);
                        }
                    }
                    break;
                case 2:
                    String subVar2 = code.substring(0, 4);
                    for (ResponseVo tem : todo) {
                        String temCode = tem.getCode();
                        // 找到以subVar1开头, 且不能是他自己的
                        if (temCode.startsWith(subVar2) && !temCode.equals(code)) {
                            Result result = new Result();
                            result.setType(tem.getSmallType());
                            result.setCode(temCode);
                            childrenList.add(result);
                        }
                    }
                    break;
                default:
                    return;
            }
            // 对下级进行循环
            for (Result child : childrenList) {
                getChildren(child, todo, level + 1);
            }
            // 将子集存入对象中
            param.setChildren(childrenList);
        }
        // 不满足直接return
        return;
    }


    public static ArrayList<ResponseVo> createData() {
        ResponseVo poiInfoRes = new ResponseVo();
        poiInfoRes.setCode("010000");
        poiInfoRes.setBigType("汽车服务");
        poiInfoRes.setMidType("汽车服务相关");
        poiInfoRes.setSmallType("汽车服务相关");
        ResponseVo poiInfoRes1 = new ResponseVo();
        poiInfoRes1.setCode("010100");
        poiInfoRes1.setBigType("汽车服务");
        poiInfoRes1.setMidType("汽车服务相关1");
        poiInfoRes1.setSmallType("汽车服务相关1");
        ResponseVo poiInfoRes2 = new ResponseVo();
        poiInfoRes2.setCode("010101");
        poiInfoRes2.setBigType("汽车服务");
        poiInfoRes2.setMidType("汽车服务相关1");
        poiInfoRes2.setSmallType("汽车服务相关2");
        ResponseVo poiInfoRes3 = new ResponseVo();
        poiInfoRes3.setCode("010201");
        poiInfoRes3.setBigType("汽车服务");
        poiInfoRes3.setMidType("汽车服务相1");
        poiInfoRes3.setSmallType("汽车服务相2");
        ResponseVo poiInfoRes4 = new ResponseVo();
        poiInfoRes4.setCode("010301");
        poiInfoRes4.setBigType("汽车服务");
        poiInfoRes4.setMidType("汽车服务关1");
        poiInfoRes4.setSmallType("汽车服务关2");


        ResponseVo poiInfoRes5 = new ResponseVo();
        poiInfoRes5.setCode("020000");
        poiInfoRes5.setBigType("汽车销售");
        poiInfoRes5.setMidType("汽车销售相关");
        poiInfoRes5.setSmallType("汽车销售相关");
        ResponseVo poiInfoRes6 = new ResponseVo();
        poiInfoRes6.setCode("020100");
        poiInfoRes6.setBigType("汽车销售");
        poiInfoRes6.setMidType("汽车销售相关1");
        poiInfoRes6.setSmallType("汽车销售相关1");
        ResponseVo poiInfoRes7 = new ResponseVo();
        poiInfoRes7.setCode("020101");
        poiInfoRes7.setBigType("汽车销售");
        poiInfoRes7.setMidType("汽车销售相关1");
        poiInfoRes7.setSmallType("汽车销售相关2");
        ResponseVo poiInfoRes8 = new ResponseVo();
        poiInfoRes8.setCode("020201");
        poiInfoRes8.setBigType("汽车销售");
        poiInfoRes8.setMidType("汽车销售相1");
        poiInfoRes8.setSmallType("汽车销售相2");
        ResponseVo poiInfoRes9 = new ResponseVo();
        poiInfoRes9.setCode("020301");
        poiInfoRes9.setBigType("汽车销售");
        poiInfoRes9.setMidType("汽车销售关1");
        poiInfoRes9.setSmallType("汽车销售关2");

        ArrayList<ResponseVo> list = new ArrayList<>();
        list.add(poiInfoRes);
        list.add(poiInfoRes1);
        list.add(poiInfoRes2);
        list.add(poiInfoRes3);
        list.add(poiInfoRes4);
        list.add(poiInfoRes5);
        list.add(poiInfoRes6);
        list.add(poiInfoRes7);
        list.add(poiInfoRes8);
        list.add(poiInfoRes9);

        return list;
    }
}
