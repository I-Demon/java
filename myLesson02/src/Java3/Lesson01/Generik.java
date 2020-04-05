package Java3.Lesson01;

import java.util.ArrayList;
import java.util.Arrays;

public class Generik<T> {
    private T[] obj;

    public Generik(T[] obj) {
        this.obj = obj;
    }

    public T[] getObj() {
        return obj;
    }

    public void arrayChangeElements(){
        if (obj.length < 2) {
            System.out.println("В массиве должно быть как миниму 2 элемента");
            return;
        }
        T element = obj[0];
        obj[0] = obj[1];
        obj[1] = element;
    }

    public void info(){
        System.out.println(Arrays.toString(obj));
    }

    public ArrayList<T> getArrayList(){
        ArrayList<T> arr = new ArrayList<>();
        for (int i = 0; i < obj.length; i++) {
            arr.add(obj[i]);
        }
        return  arr;
    }

}
