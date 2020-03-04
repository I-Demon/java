package Java1.Lesson_07;

public class Cat {
    private final String name;
    private int appetite;
    private boolean full;   // Если равно true - значит кот сытый

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.full = false;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        full = false;
        if (plate.getFood() >= this.getAppetite()) {
            plate.decreaseFood(appetite);
            setFull(true);     // Если коту удалось поесть и количество еды в тарелки уменьшилось, устанавливаем признак сытости
        }
        else {
            System.out.printf("Кот по кличке %s не может поесть из данной тарелки. В ней мало еды", this.getName());
            System.out.println("");
        }
    }

}
