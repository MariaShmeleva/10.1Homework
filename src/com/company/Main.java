package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        int[] arr1 = getFilledArray(10, input, Integer::sum);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = getFilledArray(10, input, (x, y) -> x * y);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = getFilledArray(10, input, (x, y) -> {
            if (x % 2 == 0) {
                return x / 2 + y;
            } else {
                return x * x - y;
            }

        });
        System.out.println(Arrays.toString(arr3));
        //Вычитание модификатора из индекса)
        int[] arr4 = getFilledArray(10, input, (x, y) -> x - y);
        System.out.println(Arrays.toString(arr4));
        //Если квадрат индекса больше модификатора*2, возвращаем индекс*2+квадрат модификатора, иначе возвращаем результат умножения индекса, модификатора и 2.
        int[] arr5 = getFilledArray(10, input, (x, y) -> {
            if (x * x > 2 * y) {
                return 2 * x + y * y;
            } else {
                return x * y * 2;
            }

        });
        //Умножаем индекс на модификатор, но меняем знак модификатора на полжительный, если он отрицательный
        System.out.println(Arrays.toString(arr5));
        int[] arr6 = getFilledArray(10, input, (x, y) -> {
            if (y < 0) {
                return -y * x;
            } else {
                return y * x;
            }

        });
        System.out.println(Arrays.toString(arr6));
        in.close();

    }

    @FunctionalInterface
    public interface Processing {
        int process(int size, int input);

    }

    public static int[] getFilledArray(final int size, int input, Processing processing) {
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = processing.process(i, input);
        }
        return arr;
    }


}

