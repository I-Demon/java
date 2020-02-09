package Lesson_07;

import java.util.Random;

public class Task_07 {
    public static void main(String[] args) {

        Random random = new Random();

        Cat[] cat = new Cat[10];
        for (int i = 0; i < cat.length; i++) {
            cat[i] = new Cat("Cat_" + (i+1), random.nextInt(20)+10);
        }

        Plate plate = new Plate(100);
        plate.info();
        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            System.out.printf("Аппетит кота по кличке %s = %d", cat[i].getName(), cat[i].getAppetite());
            System.out.println("");
            System.out.printf("Сытость кота по кличке %s = %b", cat[i].getName(), cat[i].isFull());
            System.out.println("");
            plate.info();
            if (!cat[i].isFull()) {             // Если очередному коту не удалось поесть, добавляем в тарелку дополнительную порцию еды
                plate.addFood(20);
                System.out.println("Добавили в тарелку 20 единиц еды");
                plate.info();
            }
            System.out.println("--------------------------");
        }

    }
}
