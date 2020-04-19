package Java3.Lesson05;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore smp = new Semaphore(2);
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getCarName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getCarName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getCarName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
