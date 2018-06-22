package my.ky.test;

import my.ky.test.dal.constant.AppConfig;
import my.ky.test.web.controller.HelloController;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * <ul>
 * <li>应用测试</li>
 * <li>User:ky Date:2018/1/2 Time:14:42</li>
 * </ul>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    private MockMvc mvc;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private AppConfig appConfig;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Hello World!")));
    }

    @Test
    public void testRedis() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testAppConfig() {
        System.out.println(appConfig.getEnv());
        System.out.println(appConfig.getName());
        System.out.println(appConfig.getTitle());
        System.out.println(appConfig.getSecret());
        System.out.println(appConfig.getNumber());
        System.out.println(appConfig.getBignumber());
        System.out.println(appConfig.getUuid());
        System.out.println(appConfig.getNumberLessThanTen());
        System.out.println(appConfig.getNumberInRange());
    }
}
