package my.ky.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <ul>
 * <li>测试父类</li>
 * <li>User:蒯越 Date:2016/4/12 Time:13:51</li>
 * </ul>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class BaseSpringTest {

}
