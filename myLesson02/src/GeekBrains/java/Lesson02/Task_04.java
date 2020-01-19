package GeekBrains.java.Lesson02;

import java.util.Arrays;

public class Task_04
{
    public static void main(String[] args) {
        // Task 4 (заполнить диагональные элементы двумерного массива единицами)
        int[][] arr4 = new int[5][5];
        System.out.println("Двумерный массив");
        for (int i = 0; i < arr4.length; i++)
        {
            for (int j = 0; j < arr4[i].length; j++)
            {
                if ((i==j) || (arr4[i].length - 1 == i + j)) arr4[i][j]= 1;
            }
            System.out.println( Arrays.toString(arr4[i]));
        }
    }
}
