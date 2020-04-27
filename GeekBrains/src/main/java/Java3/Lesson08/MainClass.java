package Java3.Lesson08;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        final int size = 5;
        int[][] matrix = new int[size][size];
        int index = 1;
        System.out.println("Заплненая матрица");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i%2 == 0) matrix[i][j] = index;
                else matrix[i][size - j - 1] = index;
                index++;
            }
            System.out.println(Arrays.toString(matrix[i]));
        }


    }

}
