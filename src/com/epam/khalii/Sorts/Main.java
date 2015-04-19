package com.epam.khalii.Sorts;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n=10;
        int rep = 10;
        int[] array = new int[n];
        Sort.initArray(array);


        long start, end, average=0;

        if(n<20000){
        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            Sort.bubbleSort(array);
            end = System.currentTimeMillis();
            Sort.initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for bubble sort for " + n + " elements: " + average / rep);
        average=0;
        }

        if(n<20000){
        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            Sort.insertSort(array);
            end = System.currentTimeMillis();
            Sort.initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for insert sort for "+n+" elements: "+average/rep);
        average=0;
        }

        if(n<20000){
        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            Sort.selectSort(array);
            end = System.currentTimeMillis();
            Sort.initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for select sort for "+n+" elements: "+average/rep);
        average=0;
        }

        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            Sort.shellSort(array);
            end = System.currentTimeMillis();
            Sort.initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for shell sort for "+n+" elements: "+average/rep);
        average=0;

        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            Sort.quickSort(array, 0, n - 1);
            end = System.currentTimeMillis();
            Sort.initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for quick sort for " + n + " elements: " + average / rep);
        average=0;

        if(n<20000) {
            for (int i = 0; i < rep; i++) {
                start = System.currentTimeMillis();
                array = Sort.mergeSort(array);
                end = System.currentTimeMillis();
                Sort.initArray(array);
                average += end - start;
            }
            System.out.println("Average time for merge sort for " + n + " elements: " + average / rep);
        }
    }
}
