package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>对账类型</li>
 * <li>User:蒯越 Date:2016/4/13 Time:9:59</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum ChkType {

    AUTONOMOUSLY("01", "自主对账(推送对账文件)"),
    NOT_AUTONOMOUSLY("02", "非自主对账(获取对账文件)"),
    FORCE_CHECK_SUCCESS("03", "强制对账成功"),
    AUTONOMOUSLY_ENTRUST_SETTLE("04", "自主对账(委托清算,推送对账文件)"),
    NOT_AUTONOMOUSLY_EPCC_BATCH("05", "非自主对账(网联批次,获取对账文件)"),
    //
    ;

    private String code;
    private String desc;

    public static String getDesc(String code) {
        ChkType[] values = ChkType.values();
        for (ChkType o : values) {
            if (o.getCode().equals(code)) {
                return o.getDesc();
            }
        }
        return null;
    }
}
