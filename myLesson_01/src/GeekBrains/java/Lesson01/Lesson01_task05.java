package GeekBrains.java.Lesson01;

public class Lesson01_task05
{
    public static void printTrueForPositivValue(int a)           // метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    {
        if (a>=0) System.out.println("Вы указали положительное число");
        else System.out.println("Вы указали отрицательное число");
    }
}
