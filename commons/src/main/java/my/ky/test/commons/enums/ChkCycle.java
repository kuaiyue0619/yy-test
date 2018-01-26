package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>对账周期</li>
 * <li>User:蒯越 Date:2016/4/13 Time:10:13</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum ChkCycle {

    T_PLUS_0("0", "T+0日对账"),
    T_PLUS_1("1", "T+1日对账"),
    T_PLUS_2("2", "T+2日对账"),
    //
    ;

    private String code;
    private String desc;

    public static String getDesc(String code) {
        ChkCycle[] values = ChkCycle.values();
        for (ChkCycle o : values) {
            if (o.getCode().equals(code)) {
                return o.getDesc();
            }
        }
        return null;
    }
}
