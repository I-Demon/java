package Java1.Lesson_06;

public class Dog extends Animal {

    public Dog(String name, String color, int age, int maxRunValue, int maxSwimValue, int maxJumpValue) {
        super(name, color, age, maxRunValue, maxSwimValue, maxJumpValue);
        //this.heightJump = heightJump;
    }

    public Dog(String name, String color, int age) {
        this(name, color, age, 0, 0 , 0);
    }


    @Override
    public void printInfo() {
        System.out.printf("Кличка = %s; Цвет = %s; Возраст = %d",
                getName(),
                getColor(),
                getAge()
                //getJump()
        );
    }

    @Override
    public void run(int value) {
        if (value > getMaxRunValue()) System.out.printf("Вы задали слишком большое значение. Собака %s не может пробежать больше %d метров %n", name,  getMaxRunValue());
        else  System.out.printf("Собака %s пробежала %d метров %n", name, value);
        System.out.println("run: " + (value <= getMaxRunValue()));
    }

    @Override
    public void swim(int value) {
        if (value > getMaxSwimValue()) System.out.printf("Вы задали слишком большое значение. Собака %s не может проплыть больше %d метров%n", name, getMaxSwimValue());
        else System.out.printf("Собака проплыла %d метров %n", value);
        System.out.println("swim: " + (value <= getMaxSwimValue()));
    }

    @Override
    public void jump(float value) {
        if (value > getMaxJumpValue()) System.out.printf("Вы задали слишком большое значение. Собака %s не может подпрыгнуть больше  %f метров%n", name, getMaxJumpValue());
        else  System.out.printf(" Собака %s  подпрыгнула на %f метров %n", name, value);
        System.out.println("jump: " + (value <= getMaxJumpValue()));
    }

}
