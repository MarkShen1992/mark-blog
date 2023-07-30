package top.mark.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import cn.hutool.core.lang.Assert;
import top.mark.entity.UserEntity;
import top.mark.repository.UserRepository;
import top.mark.utils.AESUtils;
import top.mark.utils.UUIDUtils;

@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    void testCreateUser() {
        UserEntity user = new UserEntity();
        String userId = UUIDUtils.generate();
        user.setId(userId);
        user.setUsername("zhangsan");
        user.setRealName("张三");
        user.setPassword("asfasff");
        user.setEmail("test@163.com");
        LocalDateTime now = LocalDateTime.now();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        user.setCreateUserId(userId);
        user.setUpdateUserId(userId);
        user.setDeleted(false);
        UserEntity result = userRepository.save(user);
        Assert.notNull(result);
    }

    /**
     * 更新的时候要把原来的数据拿出来，把要更新的数据set完后，再调用save方法
     */
    @Test
    void testUpdateUserEntity() throws Exception {
        UserEntity user = new UserEntity();
        String userId = "c651a099-bb84-4214-9d99-8286628b0992";
        user.setId(userId);
        user.setUsername("zhangsan");
        user.setRealName("张三");
        // 更新密码
        user.setPassword(AESUtils.encrypt("123456abc"));
        user.setEmail("test@163.com");
        LocalDateTime now = LocalDateTime.now();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        user.setCreateUserId(userId);
        user.setUpdateUserId(userId);
        user.setDeleted(false);
        UserEntity result = userRepository.save(user);
        Assert.notNull(result);
    }

    @Test
    void testGetRepositoryById() {
        UserEntity user = userRepository.getReferenceById("c651a099-bb84-4214-9d99-8286628b0992");
        Assert.notNull(user);
    }

    @Test
    void testFindAll() {
        List<UserEntity> all = userRepository.findAll();
        Assert.notEmpty(all);
    }

    @Test
    void testFindAll02() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        List<UserEntity> all = userRepository.findAll(sort);
        Assert.notEmpty(all);
    }

    @Test
    void testFindAll03() {
        UserEntity user = new UserEntity();
        user.setUsername("zhangsan");

        // 创建ExampleMatcher，用于指定匹配规则
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("username",
            ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        // 根据Example对象和ExampleMatcher进行查询
        Example<UserEntity> condition = Example.of(user, exampleMatcher);

        List<UserEntity> all = userRepository.findAll(condition);
        Assert.notEmpty(all);
    }

    @Test
    void testFindAll04() {
        // 创建分页请求对象
        // page = (curPage - 1) * size
        // size = 页面上有多少条数据
        Pageable pageable = PageRequest.of(0, 10);
        Page<UserEntity> data = userRepository.findAll(pageable);
        Assert.notEmpty(data.getContent());
    }

    @Test
    void testFindAll05() {
        UserEntity user = new UserEntity();
        user.setUsername("zhangsan");

        // 创建ExampleMatcher，用于指定匹配规则
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("username",
            ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        // 根据Example对象和ExampleMatcher进行查询
        Example<UserEntity> condition = Example.of(user, exampleMatcher);

        // 创建分页请求对象
        // page = (curPage - 1) * size
        // size = 页面上有多少条数据
        Pageable pageable = PageRequest.of(0, 10);
        Page<UserEntity> data = userRepository.findAll(condition, pageable);
        Assert.notEmpty(data.getContent());
    }

    @Test
    void testFindAll06() {
        UserEntity user = new UserEntity();
        user.setUsername("zhangsan");

        // 创建ExampleMatcher，用于指定匹配规则
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("username",
            ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        // 根据Example对象和ExampleMatcher进行查询
        Example<UserEntity> condition = Example.of(user, exampleMatcher);

        // 创建分页请求对象
        // page = (curPage - 1) * size
        // size = 页面上有多少条数据
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "createTime"));
        Page<UserEntity> data = userRepository.findAll(condition, pageable);
        Assert.notEmpty(data.getContent());
    }
}
