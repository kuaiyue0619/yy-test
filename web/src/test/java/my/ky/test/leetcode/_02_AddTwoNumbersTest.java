package my.ky.test.leetcode;

import lombok.ToString;
import org.junit.Test;

/**
 * <ul>
 * <li>两数相加</li>
 * <li>User:ky Date:2019/6/4 Time:16:20</li>
 * </ul>
 */
public class _02_AddTwoNumbersTest {

    @ToString
    class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void solution() {
        ListNode listNode = this.addTwoNumbers(new ListNode(5), new ListNode(5));
        System.out.println(listNode);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        int carryV = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carryV;
            carryV = sum / 10;
            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carryV != 0) {
            currentNode.next = new ListNode(carryV);
        }
        return head.next;
    }
}
