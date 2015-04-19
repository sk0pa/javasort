package com.epam.khalii.Sorts;

/**
 * Created by Skopa on 19.04.2015.
 */
public class BubbleSorter {

    public static void sortFloat(int[] arr) {
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index] > arr[index + 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                }
            }
        }
    }

    public static void sortSink(int[] arr){
        for(int barrier =0; barrier < arr.length; barrier++) {
            for (int index = barrier; index>0; index--) {
                if (arr[index-1] > arr[index]) {
                    int tmp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n=10000;
        int[] array = new int[n];
        Sort.initArray(array);
        long start, end, average=0;
        start = System.currentTimeMillis();
        sortFloat(array);
        end = System.currentTimeMillis();
        Sort.initArray(array);
        average=end-start;
        System.out.println("Average time for bubble float sort for " + n + " elements: " + average);
        Sort.initArray(array);
        start = System.currentTimeMillis();
        sortSink(array);
        end = System.currentTimeMillis();
        Sort.initArray(array);
        average=end-start;
        System.out.println("Average time for bubble sink sort for " + n + " elements: " + average);
    }
}
