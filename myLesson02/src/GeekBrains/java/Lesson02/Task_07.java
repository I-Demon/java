package GeekBrains.java.Lesson02;

import java.util.Arrays;

public class Task_07
{
    public static void main(String[] args)
    {
        // Task 7 (Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.)
        int[] arr = new int[] {7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив -   " + Arrays.toString(arr));
        moveElements(arr, 3);
        moveElements(arr, -3);
        moveElements(arr, 0);
    }

    private static void moveElements(int[] arr, int shift)
    {
        if (shift == 0) return;
        int myShift = shift % arr.length;       // если сдвиг больше длины массива, оставляем только величину сдвига, кратную длине массива
        int index;

        int[] arrTemp = new int[arr.length];
        if (shift < 0)
        {
            for (int i = arr.length -1; i >= 0 ; i--)
            {
                index = i + myShift;
                if (index < 0) index += arr.length;
                arrTemp[index] = arr[i];
            }
        }
        else
            {
                for (int i = 0; i < arr.length; i++)
                {
                    index = i + myShift;
                    if (index >= arr.length) index -= arr.length;
                    arrTemp[index] = arr[i];
                }
            }
        System.out.println("Массив сдвинутый на " + myShift + " - " + Arrays.toString(arrTemp));
    }
}
