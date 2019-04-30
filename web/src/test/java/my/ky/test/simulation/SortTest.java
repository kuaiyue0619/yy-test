package my.ky.test.simulation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * <ul>
 * <li>排序测试</li>
 * <li>User:ky Date:2018/8/16 Time:10:29</li>
 * </ul>
 */
public class SortTest {

    private int[] data = new int[10];
    private int[][] bigData = new int[10000][200];

    @Before
    public void init() {
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
            this.data[i] = r.nextInt(10);
        }
        System.out.println(Arrays.toString(this.data));

        SortTest[][] arr = new SortTest[1][1];
    }

    private void initBigData() {
        Random r = new Random();
        for (int i = 0; i < bigData.length; i++) {
            for (int j = 0; j < bigData[i].length; j++) {
                this.bigData[i][j] = r.nextInt(100);
            }
        }
    }

    @Test
    public void testArrayListSort() {
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

    @Test
    public void testBatchSort() {
        this.initBigData();
        long start = System.currentTimeMillis();
        for (int[] data : this.bigData) {
            this.bubbleSort(data);
        }
        System.out.println(String.format("冒泡排序,执行%s毫秒...", System.currentTimeMillis() - start));
        this.initBigData();
        start = System.currentTimeMillis();
        for (int[] data : this.bigData) {
            this.insertSort(data);
        }
        System.out.println(String.format("插入排序,执行%s毫秒...", System.currentTimeMillis() - start));
    }

    @Test
    public void testBubbleSort() {
        long startNano = System.nanoTime();
        this.bubbleSort(this.data);
        System.out.println(String.format("冒泡排序,执行%s纳秒...", System.nanoTime() - startNano));
        System.out.println(Arrays.toString(this.data));

    }

    private void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            boolean isSorted = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    isSorted = true;
                }
            }
            if (!isSorted) {
                break;
            }
        }
    }

    @Test
    public void testInsertSort() {
        long startNano = System.nanoTime();
        this.insertSort(this.data);
        System.out.println(String.format("插入排序,执行%s纳秒...", System.nanoTime() - startNano));
        System.out.println(Arrays.toString(this.data));
    }

    private void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int v = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (v < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = v;
        }
    }

    @Test
    public void testMergeSort() {
        this.mergeSort(this.data);
        System.out.println(Arrays.toString(this.data));
    }

    private void mergeSort(int[] data) {
        this.mergeSortR(data, 0, data.length - 1);
    }

    private void mergeSortR(int[] data, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            // 递归退出条件
            return;
        }
        // 计算中间索引
        int midIndex = (startIndex + endIndex) / 2;
        // 左侧数据归并排序
        this.mergeSortR(data, startIndex, midIndex);
        // 右侧数据归并排序
        this.mergeSortR(data, midIndex + 1, endIndex);
        // 将左右侧数据排序后合并至原数组
        this.mergeData(data, startIndex, midIndex, endIndex);
    }

    private void mergeData(int[] data, int startIndex, int midIndex, int endIndex) {
        // 创建临时空间,用于存放排序后的数据
        int[] temp = new int[endIndex - startIndex + 1];
        int tempI = 0;
        int i = startIndex;
        int j = midIndex + 1;
        // 此处循环完后,若两边数据个数不等,则会有留存数据
        while (i <= midIndex && j <= endIndex) {
            if (data[i] <= data[j]) {
                temp[tempI] = data[i];
                i++;
            } else {
                temp[tempI] = data[j];
                j++;
            }
            tempI++;
        }

        // 将留存数据填充,必定大于等于已填充数据,且已排序
        int leftStartI;
        int leftEndI;
        if (i <= midIndex) {
            // 左侧有留存数据
            leftStartI = i;
            leftEndI = midIndex;
        } else {
            // 右侧有留存数据
            leftStartI = j;
            leftEndI = endIndex;
        }
        for (; leftStartI <= leftEndI; leftStartI++) {
            temp[tempI] = data[leftStartI];
            tempI++;
        }

        // 复制临时数组至原数组
        System.arraycopy(temp, 0, data, startIndex, endIndex - startIndex + 1);
    }
}
