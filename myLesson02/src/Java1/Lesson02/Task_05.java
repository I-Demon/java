package Java1.Lesson02;

import java.util.Arrays;

public class Task_05
{
    public static void main(String[] args) {
        // Task 5 (найти в массиве минимальный и максимальный элементы)
        int[] arr5 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив -   " + Arrays.toString(arr5));
        int min = arr5[0];
        int max = arr5[0];
        for (int i = 0; i < arr5.length; i++)
        {
            if (arr5[i]<min) min= arr5[i];
            if (arr5[i]>max) max= arr5[i];
        }
        //System.out.println("");
        System.out.println("Минимальное значение массива - " + min);
        System.out.println("Максимальное значение массива - " + max);
    }

}
