package my.ky.test.simulation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <ul>
 * <li>排序测试</li>
 * <li>User:ky Date:2018/8/16 Time:10:29</li>
 * </ul>
 */
public class SortTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("q");
        list.add("w");
        list.add("e");
        list.add("r");
        list.add("ac");
        list.add("ab");
        list.add("s");
        list.add("d");
        list.add("f");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
