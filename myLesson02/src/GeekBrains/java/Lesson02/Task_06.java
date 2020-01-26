package GeekBrains.java.Lesson02;

public class Task_06
{
    public static void main(String[] args)
    {
        //Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место,
        // в котором сумма левой и правой части массива равны.
        int[] myArray = {2, 2, 2, 1, 2, 2, 10, 1};
        if (checkSum(myArray)) System.out.println("Баланс найден");
        else System.out.println("Баланс не найден");
    }

    private static boolean checkSum(int[] arr)
    {
        boolean res = false;
        int sumArray = 0;
        for (int i : arr)
        {
            sumArray += i;              // Вычисляем сумму элементов массива
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if (sum >= sumArray - sum)          // Если дошли до индекса массива, в котором сумма первых элементов >= сумме оставшихся
            {
                res = (sum == sumArray - sum) ; // проверяем что сумма левой и правой части массива равны
                if (res) System.out.println("Позиция равновесия баланса - " + i);
                break;
            }
        }
        return res;
    }
}
