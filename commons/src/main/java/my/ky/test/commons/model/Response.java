package my.ky.test.commons.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <ul>
 * <li>描述类的作用</li>
 * <li>User:ky Date:2018/1/24 Time:10:10</li>
 * </ul>
 */
@Getter
@Setter
@ToString
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -4193699737024443364L;

    private boolean success;
    private T result;
    private String errorCode;
    private String errorMsg;
    private String url;

    public Response(T result) {
        this.success = true;
        this.result = result;
    }

    public Response(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public void setError(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
