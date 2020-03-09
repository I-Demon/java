package Java2.Lesson02;

import java.util.Arrays;

public class Task02 {

    private static int SIZE = 4;        // Размер матрицы

    public static void main(String[] args) {
        String[][] strMatrix;
        final String st = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 y 0";
        try {
            strMatrix = getArray(st);
            System.out.println("Матрица 4х4");

            for (int i = 0; i < SIZE; i++) {
                System.out.println( Arrays.toString(strMatrix[i]));
            }
            System.out.println("");
            System.out.println("Резултат половины суммы элементов массива = " + getSumFuncResult(strMatrix));


        } catch (MyArraySizeException  e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static String[][] getArray(String str) throws  MyArraySizeException  {

        String[] strArray = str.split("\\s+");
        if (strArray.length > SIZE * SIZE) throw new MyArraySizeException("В массиве больше 16 элементов");
        String[][] strMatrix = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i*SIZE+j >= strArray.length) throw new MyArraySizeException("В массиве меньше 16 элементов");
                strMatrix[i][j] = strArray[i*SIZE+j];
            }
        }
        return strMatrix;
    }

    public static float getSumFuncResult(String[][] matrix) throws MyArrayDataException {
        float sum = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                }catch (NumberFormatException e) {
                    throw  new MyArrayDataException("Элемент в строке №" + ++i + " и колонке №" + ++j + " не является числом") ;
                }

            }
        }
        return sum/2;
    }

}
