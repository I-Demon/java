package Java1.Lesson02;

import java.util.Arrays;

public class Task_03
{
    public static void main(String[] args) {
        // Task 3 (пройти по массиву циклом, и числа меньшие 6 умножить на 2)
        int[] arr3 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив -   " + Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++)
        {
            if (arr3[i]<6) arr3[i]= arr3[i] * 2;
        }
        System.out.println("Измененный массив - " + Arrays.toString(arr3));
    }
}
