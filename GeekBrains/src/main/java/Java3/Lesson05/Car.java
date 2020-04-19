package Java3.Lesson05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Car extends Thread {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;


    public CyclicBarrier cbr;
    public CountDownLatch cdl;
    public ReentrantLock rl;


    public String getCarName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Race getRace() { return race;  }

    public Car(Race race, int speed, CountDownLatch cdl, CyclicBarrier cbr ) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdl = cdl;
        this.cbr = cbr;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            cbr.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
    }

}
