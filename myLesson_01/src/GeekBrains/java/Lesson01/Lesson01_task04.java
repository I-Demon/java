package GeekBrains.java.Lesson01;

public class Lesson01_task04
{
    public static boolean sumBetween10and20(int a, int b)           // Если сумма a + b лежит в пределах от 10 до 20(включительно), то вернуть true, в противном случае – false
    {
        int sum = a + b;
        if (sum >= 10 && sum <= 20)
            return true;
        else
            return false;
    }
}
