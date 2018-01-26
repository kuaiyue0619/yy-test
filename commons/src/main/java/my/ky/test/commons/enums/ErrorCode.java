package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>错误码枚举</li>
 * <li>User:蒯越 Date:2016/4/13 Time:9:29</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    /**
     * 重复性校验错误
     */
    COMPANY_EXISTED("COMPANY_EXISTED", "商户或支付通道已配置"),

    /**
     * 空校验异常
     */

    /**
     * 值校验异常
     */

    /**
     * 配置错误
     */

    /**
     * 查询异常
     */

    /**
     * 对账文件下载异常
     */

    /**
     * 差错处理异常
     */

    /**
     * 系统异常
     */
    SYS_BUSY("SYS_BUSY", "系统繁忙"),
    RPC_TIMEOUT("RPC_TIMEOUT", "外部系统超时"),
    //
    ;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String desc;
}
