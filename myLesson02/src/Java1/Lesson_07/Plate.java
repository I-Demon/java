package Java1.Lesson_07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(this);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        if (this.food - n < 0) System.out.println("Невозможно съесть еды больше, чем есть в тарелке. \nТекущее значение еды в тарелке -  " + this.food);
        else this.food -= n;
    }

    public void addFood(int n) {
        this.food += n;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
