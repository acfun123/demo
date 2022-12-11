package cn.cc.demo.day01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author nc
 * 2022/12/9
 */
public class Test1 {
    long start;
    long end;

    @BeforeEach
    public void before() {
        start = System.currentTimeMillis();
    }

    @Test
    public void process1() {
        int N = 1000000000;
        int a = 0;
        for (int i = 0; i < N; i++) {
            a = 2 + 5;
            a = 4 * 7;
            a = 6 * 8;
        }
    }

    @Test
    public void process2() {
        int N = 1000000000;
        int a = 0;
        for (int i = 0; i < N; i++) {
            a = 2 | 5;
            a = 4 & 7;
            a = 6 ^ 785;
        }
    }

    @Test
    public void process3() {
        int a = 10;

        a = a ^ a;
        a = a ^ a;
        a = a ^ a;

        System.out.println(a);
    }

    @AfterEach
    public void after() {
        end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0 + "秒");
    }

    @Test
    public void process4() {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 2, 2};
        int err = 0;
        for (int i : arr) {
            err = err ^ i;
        }
        System.out.println(err);
    }

    @Test
    public void process5() {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 2, 2};
        int err = 0;
        for (int i : arr) {
            err = err ^ i;
        }

        int rightOne = err & (~err + 1);
        int onlyOne = 0;
        for (int i : arr) {
            if ((i & rightOne) == 1) {
                onlyOne = onlyOne ^ i;
            }
        }
        System.out.println(onlyOne);
        System.out.println(onlyOne ^ err);
    }

    @Test
    public void process6() {
        int a = 2000000000;
        int b = 2000000000;
        System.out.println(a + b);
    }

    /**
     * 插入排序
     * 时间复杂度在O(N)和O(N2)
     */
    @Test
    public void sortNum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                arr[j] ^= arr[j - 1];
                arr[j - 1] ^= arr[j];
                arr[j] ^= arr[j - 1];
            }
        }
    }

    /**
     * 二分查找
     */
    @Test
    public void findNum() {
        int[] arr = {123, 122, 1234, 2, 3, 4, 4, 4, 2, 5, 3, 3, 234234, 234};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                arr[j] ^= arr[j - 1];
                arr[j - 1] ^= arr[j];
                arr[j] ^= arr[j - 1];
            }
        }
        Arrays.stream(arr).forEach(System.out::println);

        int start = 0, end = arr.length - 1;
        int left = Integer.MAX_VALUE;
        while (start <= end) {
            int index = (start + end) / 2;
            if (arr[index] >= 4) {
                if (index < left) {
                    left = index;
                }
                end = index - 1;
            }
            if (arr[index] < 4) {
                start = index + 1;
            }
        }
        System.out.println(left);
    }

    public int[] copyArr(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int[] generateArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    @Test
    public void test() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int[] array = generateArray(maxSize, maxValue);
            int[] copyArr = copyArr(array);
            Arrays.sort(array);
            sortNum(copyArr);
            boolean res = comparator(array, copyArr);
            if(!res){
                System.out.println("error!");
                break;
            }
        }
        System.out.println("success!");
        int[] arr = generateArray(maxSize, maxValue);
        Arrays.stream(arr).forEach(System.out::println);
        sortNum(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public boolean comparator(int[] arr, int[] copyArr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != copyArr[i]) {
                return false;
            }
        }
        return true;
    }
}
