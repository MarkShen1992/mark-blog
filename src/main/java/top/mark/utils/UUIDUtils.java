package top.mark.utils;

import cn.hutool.core.lang.UUID;
import top.mark.constant.Constant;

/**
 * UUID工具类
 *
 * @author shenjunyu
 * @since 2023-07-26
 */
public class UUIDUtils {

    /**
     * 生成UUID
     * 
     * @return
     */
    public static String generate() {
        return UUID.fastUUID().toString();
    }

    /**
     * 生成UUID没有中划线
     * 
     * @return
     */
    public static String generateUUIDWithoutHyphen() {
        return generate().replace(Constant.HYPHEN, Constant.EMPTY_STRING);
    }
}
