package Java1.Lesson_06;

public class Animal {
    protected String name;
    private String color;
    private int age;

    private int maxRunValue;
    private int maxSwimValue;
    private float maxJumpValue;

    public Animal(String name, String color, int age, int maxRunValue, int maxSwimValue, float maxJumpValue) {

        this.name = name;
        this.color = color;
        this.age = age;
        setMaxJumpValue(maxJumpValue);
        setMaxRunValue(maxRunValue);
        setMaxSwimValue(maxSwimValue);
    }

    public int getMaxRunValue() {
        return maxRunValue;
    }

    public void setMaxRunValue(int maxRunValue) {
        if (maxRunValue < 1) {
            System.out.println("Вы задали не верное значение для бега. Оно должно быть больше нуля");
        }
        this.maxRunValue = maxRunValue;
    }

    public int getMaxSwimValue() {
        return maxSwimValue;
    }

    public void setMaxSwimValue(int maxSwimValue) {
        if (maxSwimValue < 1){
            System.out.println("Вы задали не верное значение для плавания. Оно должно быть больше нуля");
        }
        this.maxSwimValue = maxSwimValue;
    }

    public float getMaxJumpValue() {
        return maxJumpValue;
    }

    public void setMaxJumpValue(float maxJumpValue) {
        if (maxJumpValue <= 0){
            System.out.println("Вы задали не верное значение для прыжка. Оно должно быть больше нуля");
        }
        this.maxJumpValue = maxJumpValue;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printInfo() {
//        System.out.println(this);
        System.out.printf("Имя = %s; Цвет‚ = %s; Возраст‚ = %d%n",
                getName(),
                getColor(),
                getAge());
    }

    public  void run(int value){
       System.out.printf("Животное пробежало %d метров ", value);
    };

    public  void swim(int value){
        System.out.printf("Животное проплыло %d метров ", value);
    };

    public  void jump(float value){
        System.out.printf("Животное подпрыгнуло на %f метров ", value);
    };

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

}
