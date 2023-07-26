package top.mark.model;

import lombok.Data;

/**
 * 公共返回类
 * 
 * @author shenjunyu
 * @since 2023-07-26
 */
@Data
public class AjaxResult {

    private int code;

    private String msg;

    private Object data;

    public AjaxResult() {

    }

    public AjaxResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public AjaxResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public AjaxResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 操作失败
     * 
     * @param code
     * @param msg
     * @return
     */
    public static AjaxResult failure(int code, String msg) {
        return new AjaxResult(code, msg);
    }

    /**
     * 操作成功
     * 
     * @param code
     * @param data
     * @return
     */
    public static AjaxResult success(int code, Object data) {
        return new AjaxResult(code, data);
    }

    /**
     * 成功
     * 
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static AjaxResult success(int code, String msg, Object data) {
        return new AjaxResult(code, msg, data);
    }

}
