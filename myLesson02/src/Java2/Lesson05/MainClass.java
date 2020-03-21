package Java2.Lesson05;

public class MainClass {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    static float[] arr1 = new float[h];;
    static float[] arr2 = new float[h];;


    public static void main(String[] args) {
        initArray();
        oneThreadCalc();

        long aSplit = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        System.out.println("Время разделения массива =  " + ((System.currentTimeMillis() - aSplit)/1000f) + " сек.");

        MyThread t1 = new MyThread("MyThread-1", arr1);
        MyThread t2 = new MyThread("MyThread-2", arr2);

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long aConcat = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Время склеивания массива =  " + ((System.currentTimeMillis() - aConcat)/1000f) + " сек.");

    }

    private static void oneThreadCalc() {
        long a = System.currentTimeMillis();
        calcArray();
        System.out.println("Время последовательного вычисления без потоков =  " + ((System.currentTimeMillis() - a)/1000f) + " сек.");
    }

    private static void initArray(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    private static void calcArray(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
