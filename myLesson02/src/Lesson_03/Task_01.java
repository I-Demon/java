package Lesson_03;

import java.util.Random;
import java.util.Scanner;

public class Task_01
{
    public static Scanner sc = new Scanner(System.in); // создание объекта класса Scanner

    public static void main(String[] args)
    {
        int moreTry = 0;
        int maxTry = 3;

        System.out.println("Я загадал число от 0 до 9. Попробуйте отгадать. У вас " + maxTry + " попытки(ок)");
        do
            {
                guessExec(maxTry);
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                moreTry = sc.nextInt();

            } while (moreTry != 0);

        sc.close();
        System.out.println("Спасибо за игру!");
    }

    private static void guessExec(int maxTry)
    {
        Random random = new Random();
        int gessedDigit = random.nextInt(9);
        boolean gessed = false;     // Если пользователь отгадал число, то присвоим true

        int answer ;
        for (int i = 1; i <= maxTry ; i++)
        {
            System.out.println("Попытка - " + i);
            answer = sc.nextInt();               // чтение целого числа в переменную a
            if (answer == gessedDigit)
            {
                gessed = true;
                break;
            }
            if (answer > gessedDigit) System.out.println("Загаданное число меньше");
            else  System.out.println("Загаданное число больше");
        }
        if (gessed) System.out.println("Поздравляю! Вы угадали ");
        else System.out.println("Вы проиграли. Было загадано число " + gessedDigit);
    }

}
