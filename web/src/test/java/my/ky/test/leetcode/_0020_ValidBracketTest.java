package my.ky.test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <ul>
 * <li>有效的括号</li>
 * <li>User:ky Date:2019/4/17 Time:16:45</li>
 * </ul>
 */
public class _0020_ValidBracketTest {

    @Test
    public void solution() {
        Assert.assertTrue(this.isValid("()"));
        Assert.assertTrue(this.isValid("()[]{}"));
        Assert.assertFalse(this.isValid("(]"));
        Assert.assertFalse(this.isValid("([)]"));
        Assert.assertTrue(this.isValid("{[]}"));
        Assert.assertFalse(this.isValid("[])"));
        Assert.assertFalse(this.isValid("["));
        Assert.assertFalse(this.isValid("(("));
    }

    private static final Map<Character, Character> BRACKET_MAP = new HashMap<>();

    static {
        BRACKET_MAP.put(')', '(');
        BRACKET_MAP.put(']', '[');
        BRACKET_MAP.put('}', '{');
    }

    private boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!BRACKET_MAP.containsKey(c)) {
                stack.push(c);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            if (!BRACKET_MAP.get(c).equals(stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }
}
