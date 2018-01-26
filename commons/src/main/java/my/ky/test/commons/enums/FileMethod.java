package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>对账文件方式</li>
 * <li>User:蒯越 Date:2016/4/13 Time:10:06</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum FileMethod {

    FTP("01", "FTP"),
    SFTP("02", "SFTP"),
    HTTP("03", "HTTP接口"),
    HTTPS("04", "HTTPS接口"),
    WEB_SERVICE("05", "webSerice接口"),
    ORG_PUSH("06", "支付通道主动推送"),
    NO_CHK_FILE("07", "无对账文件"),
    //
    ;

    private String code;
    private String desc;

    public static String getDesc(String code) {
        FileMethod[] values = FileMethod.values();
        for (FileMethod o : values) {
            if (o.getCode().equals(code)) {
                return o.getDesc();
            }
        }
        return null;
    }
}
