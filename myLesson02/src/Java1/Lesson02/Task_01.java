package Java1.Lesson02;

import java.util.Arrays;

public class Task_01 
{

    public static void main(String[] args)
    {
        // Task 1 (С помощью цикла и условия заменить 0 на 1, 1 на 0)
        int[] arr = new int[] {1,0,1,0,1,0,0,1,0,0,1,1};
        System.out.println("Урок 2. Пункт 1.");
        System.out.print("Начальный массив - " + Arrays.toString(arr));
        System.out.println("");
        for (int i = 0; i < arr.length; i++)
        {
         if (arr[i] == 0) arr[i]=1;
         else if (arr[i] == 1) arr[i] = 0;
        }
        System.out.print("Измененный массив- " + Arrays.toString(arr));

    }


}
