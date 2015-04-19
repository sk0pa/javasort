package com.epam.khalii.Sorts;

/**
 * Created by Skopa on 19.04.2015.
 */
public class ArrayInverter {
    public static void invertInc(int[] arr) {
        for (int k = 0; k < arr.length / 2; k++) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
    }

  //  ¬ коде инвертировани€ массива
        public static void invertDec(int[] arr) {
            for (int k = arr.length / 2; k >0; k--) {
                int tmp = arr[k];
                arr[k] = arr[arr.length - k - 1];
                arr[arr.length - k - 1] = tmp;
            }
        }

 //   необходимо переписать цикл с инкремента счетчика от 0 до середины
 // массива на цикл от середины массива до 0 (инкремент (k++) заменить на декремент (k--)).

    public static void main(String[] args) {
        int n=10000;
        int[] array = new int[n];
        Sort.initArray(array);
        invertInc(array);
        Sort.initArray(array);
        invertDec(array);
    }

}
