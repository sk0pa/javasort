package com.epam.khalii.Sorts;

import java.util.Random;

public class Main {

    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }

    public static void initArray(int[] array){
        Random rand = new Random();
        for(int i=0;i<array.length;i++)
            array[i] = rand.nextInt(10000);
    }

    public static void bubbleSort(int[] array){
        for(int i=array.length-1; i>0 ;i--){
            for (int j=0; j<i; j++){
                if(array[j]>array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] array){
        for(int i=1; i<array.length;i++) {
            int cur = array[i];
            int j;
            for(j=i-1;j>=0&&array[j]>cur;j--)
               array[j+1]=array[j];
            array[j+1]=cur;
        }
    }

    public static void selectSort(int[] array){
        for(int i=0; i<array.length; i++){
            int minindex=i;
            for(int j=i+1; j<array.length;j++){
                if(array[j]<array[minindex])
                    minindex=j;
            }
            int temp = array[minindex];
            array[minindex] = array[i];
            array[i]= temp;
        }
    }

    public static void shellSort(int[] array){
        for(int k = array.length/2; k>0;k/=2){
            for(int i=k; i<array.length; i++){
                int j;
                int temp = array[i];
                for(j=i;j>=k;j-=k){
                    if(temp<array[j-k])
                        array[j]=array[j-k];
                    else
                        break;
                }
                array[j]=temp;
            }
        }
    }

    public static int partition(int[] array, int start, int end){
        int pointer = start;
        for(int i=start; i<=end;i++){
            if(array[i]<=array[end]) {
                int temp = array[pointer];
                array[pointer]=array[i];
                array[i]=temp;
                pointer++;
            }
        }
        return pointer-1;
    }

    public static void quickSort(int[] array, int start, int end){
        if(start>=end) {
            return;
        }
        int middle = partition(array, start, end);
        quickSort(array, start, middle-1);
        quickSort(array, middle+1, end);
    }

    public static int[] mergeSort(int[] array){
        if (array.length==0||array.length==1)
            return array;
        int middle = array.length/2;
        int[] array1=new int[middle];
        for(int i=0;i<middle;i++) {
            array1[i]=array[i];
        }
        int[] array2=new int[array.length-middle];
        for(int i=0;i<(array.length-middle);i++) {
            array2[i]=array[middle+i];
        }
        return merge(mergeSort(array1), mergeSort(array2));
    }

    public static int[] merge(int[] array1, int[] array2){
        int[] array = new int[array1.length+array2.length];
        int fpointer=0,spointer=0;
        for(int i = 0; i<(array1.length+array2.length);i++){
            if(fpointer<array1.length&&spointer<array2.length){
                if(array1[fpointer]<array2[spointer])
                    array[i]=array1[fpointer++];
                else
                    array[i]=array2[spointer++];
            } else {
                if (fpointer<array1.length)
                    array[i] = array1[fpointer++];
                else
                    array[i]=array2[spointer++];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int n=10000;
        int rep = 10;
        int[] array = new int[n];
        initArray(array);

        long start, end, average=0;

        if(n<20000){
        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            bubbleSort(array);
            end = System.currentTimeMillis();
            initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for bubble sort for " + n + " elements: " + average / rep);
        average=0;
        }

        if(n<20000){
        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            insertSort(array);
            end = System.currentTimeMillis();
            initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for insert sort for "+n+" elements: "+average/rep);
        average=0;
        }

        if(n<20000){
        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            selectSort(array);
            end = System.currentTimeMillis();
            initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for select sort for "+n+" elements: "+average/rep);
        average=0;
        }

        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            shellSort(array);
            end = System.currentTimeMillis();
            initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for shell sort for "+n+" elements: "+average/rep);
        average=0;

        for(int i=0; i<rep; i++) {
            start = System.currentTimeMillis();
            quickSort(array, 0, n - 1);
            end = System.currentTimeMillis();
            initArray(array);
            average+=end-start;
        }
        System.out.println("Average time for quick sort for " + n + " elements: " + average / rep);
        average=0;

        if(n<20000) {
            for (int i = 0; i < rep; i++) {
                start = System.currentTimeMillis();
                array = mergeSort(array);
                end = System.currentTimeMillis();
                initArray(array);
                average += end - start;
            }
            System.out.println("Average time for merge sort for " + n + " elements: " + average / rep);
        }
    }
}
