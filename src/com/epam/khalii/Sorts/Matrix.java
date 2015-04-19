package com.epam.khalii.Sorts;

import java.util.Random;

/**
 * Created by Skopa on 19.04.2015.
 */
public class Matrix {

    public static int[][] mul(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat2 == null || mat1.length != mat2[0].length) {
            throw new IllegalArgumentException(
                    "Matrix has wrong format by multiplication");
        }
        int fmatx = mat1.length, fmaty = mat1[0].length;
        int smatx = mat2.length, smaty = mat2[0].length;
        for (int i = 0; i < mat1.length; i++) {
            if(mat1[i]==null)
                throw new IllegalArgumentException("First matrix has a null line!");
            if (mat1[i].length != fmaty)
                throw new IllegalArgumentException("First matrix not a rectangular!");
        }
        for (int i = 0; i < mat2.length; i++) {
            if(mat2[i]==null)
                throw new IllegalArgumentException("Second matrix has a null line!");
            if (mat2[i].length != smaty)
                throw new IllegalArgumentException("Second matrix not a rectangular!");
        }

        int[][] result = new int[fmatx][smaty];
        for (int i = 0; i < fmatx; i++)
            for (int j = 0; j < smaty; j++) {
                result[i][j] = 0;
                for (int k = 0; k < fmaty; k++)
                    result[i][j] += mat1[i][k] * mat2[k][j];
            }
    return result;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
              System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void initializeMatrix(int [][] matrix){
        Random r = new Random();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=r.nextInt(20);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[10][10];
        int[][] matrix2 = new int[10][10];

        initializeMatrix(matrix1);
        printMatrix(matrix1);
        System.out.println();
        initializeMatrix(matrix2);
        printMatrix(matrix2);
        System.out.println();
        int[][] matrix3 = mul(matrix1, matrix2);
        printMatrix(matrix3);
    }

}
/**
 * 1. Если один из аргументов равен null
 * - throw new IllegalArgumentException().
 * 2. Если один из аргументов НЕ
 * прямоугольная/квадратная матрица - throw new IllegalArgumentException().
 * 3. Если одна из матриц содержит null
 * в качестве строки - throw new IllegalArgumentException().
 * 4. Если ширина первой матрицы не равна высоте второй матрицы
 * - throw new IllegalArgumentException().

 */
