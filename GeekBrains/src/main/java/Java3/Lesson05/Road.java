package Java3.Lesson05;

import java.util.concurrent.atomic.AtomicInteger;

public class Road extends Stage {

    public static AtomicInteger atom = new AtomicInteger(0);

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getCarName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getCarName() + " закончил этап: " + description);

            if (c.getRace().getStages().indexOf(this) == (c.getRace().getStages().size()-1)) {
                if (atom.incrementAndGet() == 1) System.out.println(c.getCarName() + " Выиграл!!! ");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
