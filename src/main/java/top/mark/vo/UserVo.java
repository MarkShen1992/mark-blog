package top.mark.vo;

import lombok.Data;

@Data
public class UserVo {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String checkCode;
}
