package Lesson03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadTextFile {
    private String fileName;
    private final int pageSize = 1800;

    public ReadTextFile(String fileName) {
        this.fileName = fileName;
    }

    public float getFilePageCount() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            return raf.length() / pageSize;
        }
    }

    public void ReadPage(int pageNum) throws IOException {

        byte[] buf = new byte[pageSize];
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {

            raf.seek((pageNum-1) * pageSize);
            raf.read(buf);
            //String stringValue = new String(buf);

            System.out.println("Страница файла №" + pageNum);
            System.out.println(new String(buf));
        }
    }
}
