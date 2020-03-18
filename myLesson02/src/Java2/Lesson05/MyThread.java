package Java2.Lesson05;

public class MyThread extends Thread {
    private float[] arr;

    public MyThread(String name, float[] arr) {
        super(name);
        this.arr = arr;
        start();
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();
        System.out.println(getName() + " started");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время вычисления потока " + getName() + " = " + ((System.currentTimeMillis() - a)/1000f) + " сек.");
    }

}
