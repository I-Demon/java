package Lesson_04;

import java.util.Random;
import java.util.Scanner;

public class Task_01
{
    private static final int SIZE = 5;
    private static final int winLength = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    public static final String EMPTY_COLUMN_TITLE = "  ";

    private static char[][] map;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args)
    {
        initMap();
        printMap();
        playGame();
        System.out.println("Игра окончена!");
    }

    private static void playGame()
    {
        while (true)
        {
            humanTurn();
            printMap();

            if (checkEnd(DOT_X, "Пользователь победил!"))  break;

            ComputerTurn();
            printMap();
            if (checkEnd(DOT_O, "Компьютер победил!"))      break;
        }
    }

    private static boolean checkEnd(char symbol, String winMessage) {
        if (checkWin(symbol)) {
            System.out.println(winMessage);
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean isMapFull()
    {
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                if (map[i][j] == DOT_EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol)
    {
        if (findRowWin(symbol)) return true;
        if (findColWin(symbol)) return true;
        if (findDiagonalWin_1(symbol)) return true;
        if (findDiagonalWin_2(symbol)) return true;

        return false;
    }

    private static boolean findRowWin(char symbol)      // Поиск выигрышной позиции в строках
    {
        int countDot = 0;
        for (int i = 0; i < SIZE ; i++)
        {
            for (int j = 0; j < SIZE ; j++)
            {
                if (map[i][j] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }
        return false;
    }

    private static boolean findColWin(char symbol)      // Поиск выигрышной позиции в колонках
    {
        int countDot;
        for (int i = 0; i < SIZE ; i++)
        {
            countDot = 0;
            for (int j = 0; j < SIZE ; j++)
            {
                if (map[j][i] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }
        return false;
    }

    private static boolean findDiagonalWin_1(char symbol)       // Поиск выигрышной позиции по прямой диагонали
    {
        int countDot = 0;
        for (int i = 0; i <= (SIZE - winLength) ; i++)
        {
            for (int j = 0; j < SIZE ; j++)
            {
                if ((j+i) >= SIZE) break;
                if (map[j][j+i] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }

        for (int i = 1; i <= (SIZE - winLength); i++)
        {
            for (int j = 0; j < SIZE - i; j++)
            {
                if ((j+i) >= SIZE) break;
                if (map[j+i][j] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }
        return false;
    }

    private static boolean findDiagonalWin_2(char symbol)   // Поиск выигрышной позиции по обратной диагонали
    {
        int countDot = 0;
        for (int i = 0; i <= (SIZE - winLength) ; i++)
        {
            for (int j = 0; j < SIZE ; j++)
            {
                if ((SIZE -1 - j - i) < 0 ) break;
                if (map[j][SIZE -1 - j - i] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }

        for (int i = 1; i <= (SIZE - winLength); i++)
        {
            for (int j = 0; j < SIZE - i; j++)
            {
                if (((j+i) >= SIZE) || ((SIZE -1 - j) < 0)) break;
                if (map[j+i][SIZE -1 - j ] == symbol) countDot++;
                else countDot = 0;
                if (countDot >= winLength) return true;
            }
        }
        return false;
    }


    private static void humanTurn()
    {
        int rowNumber, colNumber;

        do {
            System.out.println("Ход пользователя. Введите номер строки и столбца");
            System.out.print("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.print("Колонка = ");
            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_X;
    }

    private static void ComputerTurn()
    {
        System.out.println("Ход компьютера");
        int rowNumber, colNumber;
        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_O;
    }

    private static boolean isCellValid(int rowNumber, int colNumber)
    {
        if (rowNumber < 1 || rowNumber > SIZE)  return false;
        if (colNumber < 1 || colNumber > SIZE)  return false;

        return map[rowNumber - 1][colNumber - 1] == DOT_EMPTY;
    }

    private static void printMap()
    {
        printMapHeader();
        printMapRows();
    }

    private static void printMapRows()
    {
        for (int i = 0; i < SIZE; i++)
        {
            printColumnNumber(i);
            for (int j = 0; j < SIZE; j++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printColumnNumber(int i)
    {
        int columnNumber = i + 1;
        System.out.print(columnNumber + " ");
    }

    private static void printMapHeader()
    {
        printEmptyHeaderForFirstColumn();
        for (int i = 0; i < SIZE; i++)
        {
            printColumnNumber(i);
        }
        System.out.println();
    }

    private static void printEmptyHeaderForFirstColumn()
    {
        System.out.print(EMPTY_COLUMN_TITLE);
    }

    private static void initMap()
    {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
            {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}
