package datastruct;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] first = Arrays.copyOf(nums1, m);

        int value1;
        int value2;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < n) {

            value1 = first[i];
            value2 = nums2[j];

            if (value1 < value2) {

                nums1[k] = value1;
                i++;
                k++;
            } else {
                nums1[k] = value2;
                j++;
                k++;
            }
        }

        if (i < m) {
            System.arraycopy(first, i, nums1, k, m - i);
        }

        if (j < n) {
            System.arraycopy(nums2, j, nums1, k, n - j);
        }
    }

    public static void main(String[] args) {

        int[] first = new int[]{1, 2, 3, 0, 0, 0};

        int[] second = new int[]{2, 5, 6};

        merge(first, 3, second, 3);
        System.out.println(Arrays.toString(first));

    }
}
