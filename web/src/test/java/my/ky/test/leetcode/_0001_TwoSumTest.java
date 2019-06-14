package my.ky.test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>两数之和</li>
 * <li>User:ky Date:2019/6/4 Time:16:09</li>
 * </ul>
 */
public class _0001_TwoSumTest {

    @Test
    public void solution() {
        Assert.assertArrayEquals(new int[]{0, 1}, this.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
