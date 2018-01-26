package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>退款对账标识</li>
 * <li>User:蒯越 Date:2016/4/13 Time:10:38</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum RefundCheckFlag {

    CHECK_SUCCESS("0", "退款默认对账成功"),
    PARTICIPATE_CHECK("1", "退款参与真实对账"),
    //
    ;

    private String code;
    private String desc;

    public static String getDesc(String code) {
        RefundCheckFlag[] values = RefundCheckFlag.values();
        for (RefundCheckFlag o : values) {
            if (o.getCode().equals(code)) {
                return o.getDesc();
            }
        }
        return null;
    }
}
