package HeapSort;

import java.io.*;
import java.util.Random;

public class FileCreator {

    static Random r = new Random();

    public static void main(String[] args) throws IOException {
        createFile();
    }
    public static void createFile() throws IOException {
        int a = 100;
        int b = 10_000;
        int countFields = 50;
        for (int i = 0; i <= countFields ; i++) {
            File file = new File("C:\\Users\\danis\\Desktop\\work\\repo\\src\\HeapSort\\Files\\Fiel" + i + ".txt");
            if (file.createNewFile()) {
                System.out.println("File is created!");
                // файл размером 100 элементов
                if(i == 0) {
                    write(file, 100);
                    // файл размером 10 000 элементов
                } else if (i == countFields) {
                    write(file, 10_000);
                } else {
                    int rndCount = a + (int) (Math.random() * ((b - a) + 1));
                    write(file, rndCount);
                }
            } else {
                throw new IOException();
            }
        }
    }

    public static void write(File field, int rndCount) throws IOException {
        FileWriter writer = new FileWriter(field);
        for (int i = 0; i < rndCount ; i++) {
                writer.write( r.nextInt() + " ");
        }
        writer.close();
    }
}

