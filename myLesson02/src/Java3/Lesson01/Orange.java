package Java3.Lesson01;

public class Orange extends Fruit {
    private float weight = 1.5f;

    public Orange() {

    }

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange - " + this.getClass().getName();
    }
}
