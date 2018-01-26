package my.ky.test.commons.exception;

import lombok.Getter;
import my.ky.test.commons.enums.ErrorCode;

/**
 * <ul>
 * <li>业务异常</li>
 * <li>User:蒯越 Date:2016/4/13 Time:9:26</li>
 * </ul>
 */
@Getter
public class BusiException extends RuntimeException {

    private static final long serialVersionUID = -558096351319205573L;

    /**
     * 错误码
     */
    private String code;

    public BusiException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.code = errorCode.getCode();
    }

    public BusiException(String message) {
        super(message);
    }

    public BusiException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusiException(ErrorCode errorCode, Object message) {
        super(errorCode.getDesc() + "-" + message);
        this.code = errorCode.getCode();
    }
}
