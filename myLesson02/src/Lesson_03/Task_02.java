package Lesson_03;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_02
{
    public static Scanner sc = new Scanner(System.in); // создание объекта класса Scanner

    public static void main(String[] args)
    {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();

        int index  = random.nextInt(words.length-1);
        String gWord = words[index];
        guessWord(gWord);

        sc.close();
        System.out.println("Спасибо за игру!");
    }


    private static void guessWord(String gessedWord)
    {   int atry = 1;           // Счетчик попыток
        int wordLen = gessedWord.length();
        String gessedAnswer = "###############";
        String secret = gessedAnswer.substring(wordLen);
        gessedAnswer = gessedAnswer.substring(0, wordLen);

        char[] chArray = gessedAnswer.toCharArray();
        String answer ;

        do {
            System.out.println("Угадайте слово на английском языке. Попытка - " + atry);
            answer = sc.nextLine();               // чтение целого числа в переменную a

            for (int i = 0; i < wordLen; i++)
            {
              if  (chArray[i] != '#') continue;
              if (i>=answer.length()) break;            // Если длина введеного пользователем слова больше длины загадонного, то выходим из цикла
              if (gessedWord.charAt(i) == answer.charAt(i))
              {
                  chArray[i] = gessedWord.charAt(i);
              }
            }
            gessedAnswer = String.valueOf(chArray);
            if (!gessedAnswer.equals(gessedWord))
            {
                System.out.println("Вы не отгадали. Осталось отгадать - " + gessedAnswer + secret);
            }
            atry++;
        }while (!gessedAnswer.equals(gessedWord));

        System.out.println("Поздравляю. Вы угадали! Было загадано слово - " + gessedWord);

    }
}
