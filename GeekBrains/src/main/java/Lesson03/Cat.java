package Lesson03;

import java.io.Serializable;

public class Cat implements Serializable {
    private String Name;

    public Cat(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Кот {" +
                "Имя = '" + Name + '\'' +
                '}';
    }
}
