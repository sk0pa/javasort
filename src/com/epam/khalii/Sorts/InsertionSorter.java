package com.epam.khalii.Sorts;

/**
 * Created by Skopa on 19.04.2015.
 */
public class InsertionSorter {

    public static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }
    }

    static int lineBinarySearch(int[] arg, int lst, int temp) {
        int frst = 0;
        int mid;

        while (frst<lst){
            mid =(frst+lst)/2;
            if (arg[mid] < temp && arg[mid+1]> temp) {
                return mid+1;
            }
            else {
                if (temp < arg[mid])
                    lst = mid;
                else
                    frst = mid+1;
            }
        }
        if (arg[frst]>temp)
            return frst;
        else
            return frst+1;
    }

    static void insertionSortWithLineBinarySearch(int[] arg) {
        int temp, n, loc;
        for (int i = 1; i<arg.length; i++) {
            n = i;
            loc = lineBinarySearch(arg, n - 1, arg[n]);
            temp = arg[n];
            System.arraycopy(arg, loc, arg, loc+1, n-loc);
            arg[loc] = temp;
        }
    }

    public static void main(String[] args) {
        int n=100000;
        int[] array = new int[n];
        long start, end, average;
        Sort.initArray(array);
        start = System.currentTimeMillis();
        sort(array);
        end = System.currentTimeMillis();
        Sort.initArray(array);
        average=end-start;
        System.out.println("Average time for insertion sort for "
                + n + " elements: " + average);
        Sort.initArray(array);
        start = System.currentTimeMillis();
        insertionSortWithLineBinarySearch(array);
        end = System.currentTimeMillis();
        average=end-start;
        System.out.println("Average time for insertion sort with binary search" +
                " for " + n + " elements: " + average);
    }

}

