package my.ky.test.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li>状态</li>
 * <li>User:蒯越 Date:2016/4/13 Time:10:42</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum Status {

    /**
     * 对账配置状态
     */
    CHK_CFG_OPEN("1", "开通"),
    CHK_CFG_CLOSE("0", "关闭"),

    /**
     * 对账文件信息状态
     */
    CHK_FILE_INFO_ORG_DOWNLOADING("10", "下载中"),
    CHK_FILE_INFO_ORG_DOWNLOAD_SUCCESS("11", "下载成功"),
    CHK_FILE_INFO_ORG_DOWNLOAD_FAILURE("12", "下载失败"),
    CHK_FILE_INFO_MCHNT_CREATING("20", "生成中"),
    CHK_FILE_INFO_MCHNT_CREATE_SUCCESS("21", "生成成功"),
    CHK_FILE_INFO_MCHNT_CREATE_FAILURE("22", "生成失败"),
    CHK_FILE_INFO_MCHNT_PUSH_SUCCESS("23", "推送成功"),
    CHK_FILE_INFO_MCHNT_PUSH_FAILURE("24", "推送失败"),
    CHK_FILE_INFO_DELETE("99", "文件作废"),

    /**
     * 对账结果状态
     */
    CHK_RESULT_CHECKING("A", "对账中"),
    CHK_RESULT_CHECK_SUCCESS("B", "对账成功"),
    CHK_RESULT_CHECK_FAILURE("C", "对账失败"),
    //
    ;

    private String code;
    private String desc;

    public static String getChkCfgStatusDesc(String code) {
        Status[] values = Status.values();
        for (Status o : values) {
            if (o.name().startsWith("CHK_CFG") && o.getCode().equals(code)) {
                return o.getDesc();
            }
        }
        return null;
    }

    public static String getChkFileInfoStatusDesc(String code) {
        Status[] values = Status.values();
        for (Status o : values) {
            if (o.name().startsWith("CHK_FILE_INFO") && o.getCode().equals(code)) {
                return o.getDesc();
            }
        }
        return null;
    }

    public static String getChkResultStatusDesc(String code) {
        Status[] values = Status.values();
        for (Status o : values) {
            if (o.name().startsWith("CHK_RESULT") && o.getCode().equals(code)) {
                return o.getDesc();
            }
        }
        return null;
    }
}
