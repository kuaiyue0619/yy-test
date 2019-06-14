package my.ky.test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * <ul>
 * <li>描述类的作用</li>
 * <li>User:ky Date:2019/6/12 Time:17:04</li>
 * </ul>
 */
public class _0004_FindMedianSortedArraysTest {

    @Test
    public void solution() {
        double result;
        result = this.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        Assert.assertEquals(2.0, result, 0.0);
        result = this.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        Assert.assertEquals(2.5, result, 0.0);
        result = this.findMedianSortedArrays(new int[]{}, new int[]{1});
        Assert.assertEquals(1.0, result, 0.0);
        result = this.findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3});
        Assert.assertEquals(1.5, result, 0.0);
        result = this.findMedianSortedArrays(new int[]{1}, new int[]{2, 3});
        Assert.assertEquals(2.0, result, 0.0);
        result = this.findMedianSortedArrays(new int[]{}, new int[]{2, 3});
        Assert.assertEquals(2.5, result, 0.0);
        result = this.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4});
        Assert.assertEquals(2.5, result, 0.0);
        result = this.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4, 5});
        Assert.assertEquals(3, result, 0.0);
        result = this.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2});
        Assert.assertEquals(1.5, result, 0.0);
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    private double findMedianSortedArraysOld2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int t = len1 + len2;
        int mPos = (t + 1) / 2;
        if (len1 == 0 && len2 == 1) {
            return nums2[0];
        }
        if (len2 == 0 && len1 == 1) {
            return nums1[0];
        }
        if (len1 == 1 && len2 == 1) {
            return (nums1[0] + nums2[0]) / 2.0;
        }
        Integer n1 = null, n2 = null;
        for (int i = 0, j = 0, c = 0; c <= mPos; c++) {
            int now;
            if (i == len1) {
                now = nums2[j];
                j++;
            } else if (j == len2) {
                now = nums1[i];
                i++;
            } else {
                if (nums1[i] < nums2[j]) {
                    now = nums1[i];
                    i++;
                } else {
                    now = nums2[j];
                    j++;
                }
            }
            if (n1 == null) {
                n1 = now;
            } else if (n2 == null) {
                n2 = now;
            } else {
                if (n1 >= n2 && now > n2) {
                    n2 = now;
                } else if (n2 >= n1 && now > n1) {
                    n1 = now;
                }
            }
            if (mPos == c) {
                if (t % 2 == 0) {
                    return (n1 + n2) / 2.0;
                } else {
                    return n1 < n2 ? n1 : n2;
                }
            }
        }
        return 0;
    }

    private double findMedianSortedArraysOld(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] arr = new int[length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        Arrays.sort(arr);
        int i = length / 2;
        if (length % 2 == 0) {
            return (arr[i] + arr[i - 1]) / 2.0;
        } else {
            return arr[i];
        }
    }
}
