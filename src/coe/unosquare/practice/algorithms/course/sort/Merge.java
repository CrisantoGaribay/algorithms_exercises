package coe.unosquare.practice.algorithms.course.sort;

public class Merge {



    public static void mergeSort(int[] input , int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);

    }

    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        /*
        * //[32, --36--], [33, 34]
        * //[32, 33, 34, --36--]
        * When we merge two arrays and the biggest number is in the left array
        * the line 43 move hte number to de end
         */

        System.arraycopy(input, i, input, start + tempIndex, mid - i);

        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
