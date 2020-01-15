package GeekBrains.java.Lesson01;

public class Lesson01_task01 {

    public static void main(String[] args)
    {
        // Результат работы метода из пункта 3 Урока 1
        int res = GeekBrains.java.Lesson01.Lesson01_task03.myFormula(10, 20, 3, 5);
        System.out.println("Результат вычисления формулы = " + res);

        // Результат работы метода из пункта 4 Урока 1
        int intA = 8;
        int intB = 2;
        System.out.println("Сумма значений " +  intA + " и " + intB + " находится в диапазоне между 10 и 20 = " + GeekBrains.java.Lesson01.Lesson01_task04.sumBetween10and20(intA, intB));

        // Результат работы метода из пункта 5 Урока 1
        GeekBrains.java.Lesson01.Lesson01_task05.printTrueForPositivValue(0);

        // Результат работы метода из пункта 6 Урока 1
        int intC = -5;
        if (GeekBrains.java.Lesson01.Lesson01_task06.isValueNegativ(intC))
            System.out.println("Значение переменной intC отрицательное");
        else
            System.out.println("Значение переменной intC положительное");


        // Результат работы метода из пункта 7 Урока 1
        GeekBrains.java.Lesson01.Lesson01_task07.printUserName("Дмитрий");
    }
}
