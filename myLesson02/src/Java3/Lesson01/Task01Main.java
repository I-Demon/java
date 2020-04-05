package Java3.Lesson01;

import java.util.ArrayList;
import java.util.Arrays;

public class Task01Main {
     public static void main(String[] args) {

         String[] arr = {"1", "2", "3", "4"};
         Generik<String> arrString = new Generik<>(arr);
         arrString.info();
         arrString.arrayChangeElements();
         System.out.println("После смены элементов");
         arrString.info();

         SimpleBox[] boxArray = new SimpleBox[2];
         boxArray[0] = new SimpleBox(10, 20);
         boxArray[1] = new SimpleBox(100, 500);
         Generik<SimpleBox> genBoxArray = new Generik<>(boxArray);

         //Пункт задания №1.  Меняем элементы в массиве из коробок и воводим результат на печать
         genBoxArray.info();
         genBoxArray.arrayChangeElements();
         System.out.println("После смены элементов");
         genBoxArray.info();

        //Пункт задания №2. Преобразуем массив в ArrayList и выводим на печать
         ArrayList<String> list =arrString.getArrayList();
         System.out.println("Элементы массива");
         System.out.println(Arrays.toString(list.toArray()));

         System.out.println("");



         // Пункт задания №3.
          int boxCapacity1 = 10;
          int boxCapacity2 = 20;

          Box<Apple> appleBox1 = new Box<>();
          Box<Apple> appleBox2 = new Box<>();

          Box<Orange> orangeBox1 = new Box<>();
          Box<Orange> orangeBox2 = new Box<>();

          for (int i = 0; i < boxCapacity2; i++) {
               if (i < boxCapacity1) {
                    appleBox1.addFruit(new Apple());
                    orangeBox1.addFruit(new Orange());
               }
               appleBox2.addFruit(new Apple());
               orangeBox2.addFruit(new Orange());
          }

          System.out.println("Кол-во фруктов в коробке appleBox1 = " + appleBox1.getFruits().size()  + "  Вес коробки appleBox1 = " + appleBox1.getWeight());
          System.out.println("Кол-во фруктов в коробке appleBox2 = " + appleBox2.getFruits().size()  + "  Вес коробки appleBox2 = " + appleBox2.getWeight());
          System.out.println("Кол-во фруктов в коробке orangeBox1 = " + orangeBox1.getFruits().size()  + "  Вес коробки orangeBox1 = " + orangeBox1.getWeight());
          System.out.println("Кол-во фруктов в коробке orangeBox2 = " + orangeBox2.getFruits().size()  + "  Вес коробки orangeBox2 = " + orangeBox2.getWeight());

          appleBox1.getFruitsFromBox(appleBox2);
          System.out.println("");
          System.out.println("Данные после того как пересыпали яблоки из коробки appleBox2 в appleBox1");
          System.out.println("Кол-во фруктов в коробке appleBox1 = " + appleBox1.getFruits().size()  + "  Вес коробки appleBox1 = " + appleBox1.getWeight());
          System.out.println("Кол-во фруктов в коробке appleBox2 = " + appleBox2.getFruits().size()  + "  Вес коробки appleBox2 = " + appleBox2.getWeight());

          //appleBox1.getFruitsFromBox(orangeBox1); Нельзя добавить фрукты другого типа

          orangeBox2.getFruitsFromBox(orangeBox1);
          System.out.println("Данные после того как пересыпали апельсины из коробки orangeBox1 в orangeBox2");
          System.out.println("Кол-во фруктов в коробке orangeBox1 = " + orangeBox1.getFruits().size()  + "  Вес коробки orangeBox1 = " + orangeBox1.getWeight());
          System.out.println("Кол-во фруктов в коробке orangeBox2 = " + orangeBox2.getFruits().size()  + "  Вес коробки orangeBox2 = " + orangeBox2.getWeight());

     }
}
