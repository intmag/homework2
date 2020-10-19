package ru.geekbrains.homework2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1 задание
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        arr = invertArray(arr);
        System.out.println(Arrays.toString(arr));

        //2 задание
        int[] secondArray = new int[8];
        secondArray = fillableArray(secondArray);
        System.out.println(Arrays.toString(secondArray));

        //3 задание
        int[] multipliedArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(multipliedArray));
        multipliedArray = multiplicationArray(multipliedArray);
        System.out.println(Arrays.toString(multipliedArray));

        //4 задание
        int[][] twoDimensionalArray = new int[8][8];
        twoDimensionalArray = diagonalFilling(twoDimensionalArray);
        twoDimensionalArrayDisplay(twoDimensionalArray);

        //5 задание
        minAndMaxArrayVal(multipliedArray);

        //6 задание
        int[] getLuckArray = {11, 10};
        System.out.println(luckyArray(getLuckArray));

        //7 задание
        int[] shiftArray = {1, 2, 3, 4, 5};
        shiftArrayFunction(shiftArray, -2);
    }

    public static int[] invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        return arr;
    }

    public static int[] fillableArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 3;
        }
        return arr;
    }

    public static int[] multiplicationArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    public static int[][] diagonalFilling(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }
        return arr;
    }

    public static void twoDimensionalArrayDisplay(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void minAndMaxArrayVal(int[] arr) {
        int maxVal = arr[0];
        int minVal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            } else if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        System.out.printf("Максимальное значение массива: %d, минимальное значение массива: %d%n", maxVal, minVal);
    }

    public static boolean luckyArray(int[] arr) {
        int arraySumFirstPart = 0;
        boolean chek = false;
        for (int i = 0; i < arr.length; i++) {
            int arraySumSecondPart = 0;
            arraySumFirstPart += arr[i];
            for (int j = (i + 1); j < arr.length; j++) {
                arraySumSecondPart += arr[j];
            }
            if (arraySumFirstPart == arraySumSecondPart) {
                chek = true;
                break;
            }
        }
        return chek;
    }

    public static void shiftArrayFunction(int[] arr, int shiftVal) {
        //и тут Остапа понесло...
        int arrValue;
        System.out.println(Arrays.toString(arr));
        for (int i = shiftVal; i != 0; i += shiftVal < 0 ? 1 : -1) {
            arrValue = shiftVal < 0 ? arr[0] : arr[arr.length - 1];
            for (int j = arr.length; j > 1; j--) {
                if (shiftVal > 0) {
                    arr[j - 1] = arr[j - 2];
                } else if (shiftVal < 0) {
                    arr[arr.length - j] = arr[arr.length - j + 1];
                }
            }
            if (shiftVal > 0) {
                arr[0] = arrValue;
            } else if (shiftVal < 0) {
                arr[arr.length - 1] = arrValue;
            }
            arrValue = shiftVal < 0 ? arr[0] : arr[arr.length - 1];
        }
        System.out.println(Arrays.toString(arr) + " сдвиг: " + shiftVal);
    }
}
