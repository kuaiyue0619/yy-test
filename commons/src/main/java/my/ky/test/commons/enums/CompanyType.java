package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>商户或支付通道类型</li>
 * <li>User:蒯越 Date:2016/4/13 Time:9:53</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum CompanyType {

    PAY_ORG("01", "支付通道"),
//    BUSI_ORG("02", "业务机构"),
    MCHNT("03", "商户"),
    //
    ;

    private String code;
    private String desc;

    public static String getDesc(String code) {
        CompanyType[] values = CompanyType.values();
        for (CompanyType o : values) {
            if (o.getCode().equals(code)) {
                return o.getDesc();
            }
        }
        return null;
    }
}
