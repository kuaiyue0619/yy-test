package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>事件</li>
 * <li>User:ky Date:2018/2/22 Time:9:32</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum Events {

    PAY("PAY", "支付"),
    RECEIVE("RECEIVE", "收货"),
    //
    ;

    private String code;
    private String desc;
}
