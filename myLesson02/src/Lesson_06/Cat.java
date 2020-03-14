package Lesson_06;

public class Cat extends Animal {
    private int weight;

    public Cat(String name, String color, int age, int maxRunValue, int maxSwimValue, int maxJumpValue, int weight) {
        super(name, color, age, maxRunValue,maxSwimValue, maxJumpValue);
        this.weight = weight;
    }

    public Cat(String name, String color, int age) {
        this(name, color, age, 0, 0, 0, 0);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void swim(int value) {
        System.out.println("К сожалению кот не умеет плавать");
        System.out.println("swim: false");
    }

    @Override
    public void run(int value) {
        if (value > getMaxRunValue()) System.out.printf("Вы задали слишком большое значение. Кот %s не может пробежать больше %d метров %n " , name, getMaxRunValue());
        else  System.out.printf("Кот %s пробежал %d метров %n", name, value);
        System.out.println("run: " + (value <= getMaxRunValue()));
    }

    @Override
    public void jump(float value) {
        if (value > getMaxJumpValue()) System.out.printf("Вы задали слишком большое значение. Кот %s не может подпрыгнуть больше  %f метров%n", name, getMaxJumpValue());
        else  System.out.printf(" Кот %s  подпрыгнул на %f метров %n", name, value);
        System.out.println("jump: " + (value <= getMaxJumpValue()));
    }

    @Override
    public void printInfo() {
        System.out.printf("Кличка = %s; Цвет = %s; Возраст = %d; Вес = %d%n",
                getName(),
                getColor(),
                getAge(),
                getWeight());
    }


    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                '}';
    }

}
