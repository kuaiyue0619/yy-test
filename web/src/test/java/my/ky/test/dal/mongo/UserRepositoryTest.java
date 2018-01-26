package my.ky.test.dal.mongo;

import my.ky.test.BaseSpringTest;
import my.ky.test.dal.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <ul>
 * <li>用户持久服务</li>
 * <li>User:ky Date:2018/1/24 Time:15:31</li>
 * </ul>
 */
public class UserRepositoryTest extends BaseSpringTest {

    /*@Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() throws Exception {
        // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "didi", 30));
        userRepository.save(new User(2L, "mama", 40));
        userRepository.save(new User(3L, "kaka", 50));
        Assert.assertEquals(3, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        User u = userRepository.findOne(1L);
        userRepository.delete(u);
        Assert.assertEquals(2, userRepository.findAll().size());

        // 删除一个User，再验证User总数
        u = userRepository.findByName("mama");
        userRepository.delete(u);
        Assert.assertEquals(1, userRepository.findAll().size());
    }*/
}
