package Java1.Lesson_06;

public class Task_06 {
    public static void main(String[] args) {
        Animal animal = new Animal("Имя животного", "Красный", 30, 10, 20, 30);
        Cat cat = new Cat("Барсик", "Белый", 3,  3, 4, 6 ,20);
        Cat cat3 = new Cat("Пушок", "рыжий", 4, 100, 20, 5, 5);
        Dog dog1 = new Dog("Шарик", "черный", 20, 100, 50, 2);
        Dog dog2 = new Dog("барбос", "пятнистый", 10, 200, 100, 2);

        cat.run(20);
        cat.swim(10);
        cat.jump(1);

        cat3.run(200);
        cat3.swim(20);
        cat3.jump(3);

        dog1.run(100);
        dog1.swim(150);
        dog1.jump(20);

        dog2.run(30);
        dog2.swim(250);
        dog2.jump(10);
    }
}
