package my.ky.test.simulation;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>递归测试</li>
 * <li>User:ky Date:2019/4/25 Time:14:17</li>
 * </ul>
 */
public class RecursionTest {

    private Map<Integer, Integer> CASE_COUNT_MAP = new HashMap<>();

    /**
     * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
     * 如果有 7 个台阶，你可以 2，2，2，1 这样子上去，也可以 1，2，1，1，2 这样子上去，
     * 总之走法有很多，那如何用编程求得总共有多少种走法呢？
     * <p>
     * 斐波那契数列
     */
    @Test
    public void testStepProblem() {
        Assert.assertEquals(1, this.calCaseCount(1));
        Assert.assertEquals(2, this.calCaseCount(2));
        Assert.assertEquals(3, this.calCaseCount(3));
        Assert.assertEquals(5, this.calCaseCount(4));
        Assert.assertEquals(8, this.calCaseCount(5));
        Assert.assertEquals(13, this.calCaseCount(6));
        Assert.assertEquals(21, this.calCaseCount(7));
    }

    private int calCaseCount(int stepNum) {
        if (stepNum == 1) {
            return 1;
        }
        if (stepNum == 2) {
            return 2;
        }
        if (CASE_COUNT_MAP.containsKey(stepNum)) {
            return CASE_COUNT_MAP.get(stepNum);
        }
        int count = this.calCaseCount(stepNum - 1) + this.calCaseCount(stepNum - 2);
        CASE_COUNT_MAP.put(stepNum, count);
        return count;
    }
}
