package top.mark.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cn.hutool.core.lang.Assert;

@SpringBootTest
public class UUIDUtilsTest {

    @Test
    void testGenerate() {
        String uuid = UUIDUtils.generate();
        Assert.equals(36, uuid.length());
    }

    @Test
    void testGenerateUUIDWithoutHyphen() {
        String uuid = UUIDUtils.generateUUIDWithoutHyphen();
        Assert.equals(32, uuid.length());
    }
}
