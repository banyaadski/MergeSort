package Tasks;

import java.util.Arrays;

public class mergeTask {
    public static void main(String[] args) {
        int[] a = { 2, 24, 9, 12, 8, 13 };
        int[] b = { 25, 4, 15, 3, 14 };
        int[] arr = new int[a.length + b.length];
        MergeSort(a);
        MergeSort(b);
        System.out.println(Arrays.toString(Merge(arr, a, b)));

    }

    public static void MergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] rigth = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < array.length; i++) {
            rigth[i - mid] = array[i];
        }

        MergeSort(left);
        MergeSort(rigth);
        Merge(array, left, rigth);

    }

    public static int[] Merge(int[] arrTarget, int[] ar1, int[] ar2) {
        int ar1MinIndex = 0;
        int ar2MinIndex = 0;
        int arTargIndex = 0;

        while (ar1MinIndex < ar1.length && ar2MinIndex < ar2.length) {
            if (ar1[ar1MinIndex] < ar2[ar2MinIndex]) {
                arrTarget[arTargIndex] = ar1[ar1MinIndex];
                ar1MinIndex++;
            } else {
                arrTarget[arTargIndex] = ar2[ar2MinIndex];
                ar2MinIndex++;
            }
            arTargIndex++;
        }
        while (ar1MinIndex < ar1.length) {
            arrTarget[arTargIndex] = ar1[ar1MinIndex];
            ar1MinIndex++;
            arTargIndex++;
        }
        while (ar2MinIndex < ar2.length) {
            arrTarget[arTargIndex] = ar2[ar2MinIndex];
            ar2MinIndex++;
            arTargIndex++;
        }

        return arrTarget;
    }

}