package Lesson03;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // Пункт 1.
        /*
        byte[] buf = new byte[50];

        try (FileInputStream in = new FileInputStream("C:/GitProjects/JavaProjects/test.txt")) {
            int count;
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print((char) buf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        // Пункт 2.
/*
        ArrayList<InputStream> ali = new ArrayList<>();
        ali.add(new FileInputStream("C:/GitProjects/JavaProjects/A.txt"));
        ali.add(new FileInputStream("C:/GitProjects/JavaProjects/B.txt"));
        ali.add(new FileInputStream("C:/GitProjects/JavaProjects/C.txt"));
        ali.add(new FileInputStream("C:/GitProjects/JavaProjects/D.txt"));
        ali.add(new FileInputStream("C:/GitProjects/JavaProjects/E.txt"));

        try (SequenceInputStream seq = new SequenceInputStream(Collections.enumeration(ali));
             FileOutputStream out = new FileOutputStream("C:/GitProjects/JavaProjects/out.txt")) {
            int x;
            while ((x = seq.read()) != -1) {
                out.write(x);
            }
            System.out.println("Выходной файл записан");
        } catch (IOException e) {
            e.printStackTrace();
        }


 */

        ReadTextFile myFile = new ReadTextFile("C:/GitProjects/JavaProjects/out.txt");
        System.out.println("Кол-во страниц в файле = " + myFile.getFilePageCount());


        long t = System.currentTimeMillis();

        myFile.ReadPage(2);

        System.out.println();
        System.out.println("Страница прочитана за " + (System.currentTimeMillis() - t) +  " мс");
        System.out.println();

        myFile.ReadPage(6150);

        System.out.println();
        System.out.println("Страница прочитана за " + (System.currentTimeMillis() - t) +  " мс");
        System.out.println();

        myFile.ReadPage(30);

        System.out.println();
        System.out.println("Страница прочитана за " + (System.currentTimeMillis() - t) +  " мс");
        System.out.println();

        }
}
