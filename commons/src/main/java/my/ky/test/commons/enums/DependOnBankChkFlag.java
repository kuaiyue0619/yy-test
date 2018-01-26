package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>依赖银行对账标识</li>
 * <li>User:蒯越 Date:2016/5/30 Time:11:31</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum DependOnBankChkFlag {

    NO("0", "不依赖"),
    YES("1", "依赖"),
    //
    ;

    private String code;
    private String desc;

    public static String getDesc(String code) {
        DependOnBankChkFlag[] values = DependOnBankChkFlag.values();
        for (DependOnBankChkFlag e : values) {
            if (e.getCode().equals(code)) {
                return e.getDesc();
            }
        }
        return null;
    }
}
