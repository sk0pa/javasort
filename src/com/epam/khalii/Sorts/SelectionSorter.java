package com.epam.khalii.Sorts;

/**
 * Created by Skopa on 19.04.2015.
 */
public class SelectionSorter {
    /**
     * 1. Убрать обмен элементами arr[barrier]
     * c arr[index] каждый раз, когда находится
     * очередной меньший элемент. Найти наименьший
     * элемент во всем массиве - и обменять с ним.
     *
     * 2. Убрать обращение во внутреннем цикле к
     * элементу массива arr[barrier]. Вычитать
     * значение ячейки массива в локальную
     * переменную (за пределами внутреннего цикла)
     * и использовать ее (во внутреннем цикле).
     * В  экспериментах пункт #1 ускорил сортировку
     * в 2 раза. Пункт #2 ускорил сортировку еще на 10%-20%.
     *
     */
    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            for (int index = barrier + 1; index < arr.length; index++) {
                if (arr[barrier] > arr[index]) {
                    int tmp = arr[index];
                    arr[index] = arr[barrier];
                    arr[barrier] = tmp;
                }
            }
        }
    }

    public static void sortOptimized(int[] arr) {
        for (int barrier = 0; barrier < arr.length; barrier++) {
            int minindex=barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                if(arr[index]<arr[minindex]){
                    minindex=index;
                }
            }
            int tmp = arr[minindex];
            arr[minindex] = arr[barrier];
            arr[barrier] = tmp;
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
        System.out.println("Average time for selection sort for "
                + n + " elements: " + average);
        Sort.initArray(array);
        start = System.currentTimeMillis();
        sortOptimized(array);
        end = System.currentTimeMillis();
        average=end-start;
        System.out.println("Average time for optimized selection sort with binary search" +
                " for " + n + " elements: " + average);
    }
}
