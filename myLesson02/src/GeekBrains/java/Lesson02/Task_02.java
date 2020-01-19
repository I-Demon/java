package GeekBrains.java.Lesson02;

import java.util.Arrays;

public class Task_02
{
    public static void main(String[] args)
    {
        // Task 2 (С помощью цикла заполнить массив значениями 0 3 6 9 12 15 18 21)
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++)
        {
            arr2[i]= i * 3;
        }
        System.out.print("массив для пункта 2 - " + Arrays.toString(arr2));
    }
}
