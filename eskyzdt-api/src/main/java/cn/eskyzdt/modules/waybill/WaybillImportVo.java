package cn.eskyzdt.modules.waybill;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 批量创建时模板视图
 * </p>
 *
 * @author dongtian
 * @since 2019-12-05
 */

@Data
public class WaybillImportVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * node
     */
    private String node;

    /**
     * uid
     */
    private String uid;

    /**
     * 会员类型
     */
    private String type;

    /**
     * 当前用户
     */
    private String operator;

    /**
     * 失败原因
     */
    @Excel(name = "错误原因", width = 20)
    private String reason;

    /**
     * 计划发车时间
     */
    @Excel(name = "计划发车时间(必填)", width = 20, format = "yyyy/MM/dd HH:mm")
    private LocalDateTime planDispatchTime;

    /**
     * 组织机构名
     */
    @Excel(name = "组织机构(必填)", width = 20)
    private String organizationName;

    /**
     * 项目名
     */
    @Excel(name = "项目(必填)", width = 20)
    private String projectName;

    /**
     * 线路名
     */
    @Excel(name = "线路", width = 20)
    private String lineName;

    /**
     * 自定义运单编号
     */
    @Excel(name = "自定义单号", width = 20)
    private String customizedNo;

    /**
     * 发货人
     */
    @Excel(name = "发货人", width = 20)
    private String senderName;

    /**
     * 发货公司
     */
    @Excel(name = "发货公司", width = 20)
    private String senderCompany;

    /**
     * 发货联系人
     */
    @Excel(name = "发货联系人", width = 20)
    private String senderContactName;

    /**
     * 发货联系人电话
     */
    @Excel(name = "发货方电话(必填)", width = 20)
    private String senderContactPhone;

    /**
     * 发货市
     */
    @Excel(name = "始发城市(必填)", width = 20)
    private String senderCity;

    /**
     * 发货区
     */
    @Excel(name = "始发区县(必填)", width = 20)
    private String senderDistrict;

    /**
     * 发货方详细地址
     */
    @Excel(name = "发货方详细地址", width = 20)
    private String senderDetail;

    /**
     * 收货人
     */
    @Excel(name = "收货人", width = 20)
    private String receiverName;

    /**
     * 收货公司
     */
    @Excel(name = "收货公司", width = 20)
    private String receiverCompany;

    /**
     * 收货联系人
     */
    @Excel(name = "收货联系人", width = 20)
    private String receiverContactName;

    /**
     * 收货联系人电话
     */
    @Excel(name = "收货方电话(必填)", width = 20)
    private String receiverContactPhone;

    /**
     * 收货市
     */
    @Excel(name = "到达城市(必填)", width = 20)
    private String receiverCity;

    /**
     * 收货区
     */
    @Excel(name = "到达区县(必填)", width = 20)
    private String receiverDistrict;

    /**
     * 收货方详细地址
     */
    @Excel(name = "收货方详细地址", width = 20)
    private String receiverDetail;

    /**
     * 是否有回单
     */
    @Excel(name = "有无回单(必填)", width = 20)
    private String isReceipt;

    /**
     * 关联司机姓名
     */
    @Excel(name = "承运司机(必填)", width = 20)
    private String driverName;

    /**
     * 关联司机电话
     */
    @Excel(name = "司机手机号(必填)", width = 20)
    private String driverPhone;

    /**
     * 车辆车牌号
     */
    @Excel(name = "承运车辆(必填)", width = 20)
    private String carNumber;

    /**
     * 派车方式
     * 1=直接2=车队长
     */
    @Excel(name = "派车方式", width = 20)
    private String dispatchType;

    /**
     * 车队长手机号
     */
    @Excel(name = "车队长手机号", width = 20)
    private String driverLeaderPhone;


    /**
     * 司机总运费
     */
    @Excel(name = "司机总运费(必填)", width = 20)
    private String totalFreightAmount;

    /**
     * 现付金额
     */
    @Excel(name = "现付金额", width = 20)
    private String spotAmount;

    /**
     * 到付金额
     */
    @Excel(name = "到付金额", width = 20)
    private String arriveAmount;
    /**
     * 尾款金额
     */
    @Excel(name = "尾款金额", width = 20)
    private String restAmount;

    /**
     * 备注
     */
    @Excel(name = "备注", width = 20)
    private String remark;

    /**
     * 货物名称(必填)
     */
    @Excel(name = "货物名称(必填)", width = 20)
    private String cargoName;

    /**
     * 备注
     */
    @Excel(name = "货物重量(KG)(必填)", width = 20)
    private String weight;

    /**
     * 备注
     */
    @Excel(name = "货物体积(方)(必填)", width = 20)
    private String volume;

    /**
     * 备注
     */
    @Excel(name = "货物数量", width = 20)
    private String quantity;

    /**
     * 货物单位
     */
    @Excel(name = "货物单位", width = 20)
    private String unit;

    /**
     * 货物价值(元)
     */
    @Excel(name = "货物价值(元)", width = 20)
    private String bigDecimal;

}
