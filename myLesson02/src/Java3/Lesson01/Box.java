package Java3.Lesson01;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        if (fruits.size() == 0) return 0;
        T fruit = fruits.get(0);
       return fruit.getWeight() * fruits.size();
    }

    public  boolean compare(Box<?> other){
        return (Math.abs(this.getWeight() - other.getWeight()) < 0.0001);
    }

    public void getFruitsFromBox(Box<T> otherBox){
        if (otherBox.fruits.size() == 0) return;
        this.fruits.addAll(otherBox.fruits);
        otherBox.fruits.clear();
        /*
        for (int i = 0; i < otherBox.fruits.size(); i++) {

        }
        */

    }

}
