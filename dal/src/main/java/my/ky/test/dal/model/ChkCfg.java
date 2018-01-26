package my.ky.test.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import my.ky.test.dal.model.base.BaseModel;

import java.util.Date;

/**
 * <ul>
 * <li>对账配置表</li>
 * <li>User:蒯越 Date:2016/4/12 Time:09:23</li>
 * </ul>
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ChkCfg extends BaseModel {

    private static final long serialVersionUID = -2689997557196279295L;

    /**
     * 支付通道或商户代码
     */
    private String companyCode;

    /**
     * 支付通道或商户类型
     */
    private String companyType;

    /**
     * 对账类型
     */
    private String chkType;

    /**
     * 对账文件方式
     */
    private String fileMethod;

    /**
     * 对账文件时间
     */
    private String fileTime;

    /**
     * 对账文件模板号
     */
    private String fileTemplateNo;

    /**
     * 对账周期
     */
    private String chkCycle;

    /**
     * FTP主机
     */
    private String ftpHost;

    /**
     * FTP端口
     */
    private Integer ftpPort;

    /**
     * FTP用户
     */
    private String ftpUser;

    /**
     * FTP密码
     */
    private String ftpPwd;

    /**
     * FTP远程目录
     */
    private String ftpRemoteDir;

    /**
     * 操作实现类
     */
    private String operateImplClass;

    /**
     * 退款对账标识
     */
    private String refundCheckFlag;

    /**
     * 依赖银行对账标识
     */
    private String dependOnBankChkFlag;

    /**
     * 状态
     */
    private String status;

    /**
     * 开通时间
     */
    private Date openTime;

    /**
     * 开通人
     */
    private String openBy;

    /**
     * 关闭时间
     */
    private Date closeTime;

    /**
     * 关闭人
     */
    private String closeBy;

    /**
     * 当日支付当日退款对账标识(数据库中无该字段)
     * 0:当日支付当日退款不参与对账,不更新勾兑状态
     * 1:当日支付当日退款参与对账
     */
    private String todayRefundCheckFlag;
}
