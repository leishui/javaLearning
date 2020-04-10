package inClass.lzw;

import java.io.*;
import java.util.Random;

public class DataMaker {
    public static void main(String[] args) {
        Random random = new Random();
        try {
            FileOutputStream dataOutputStream = new FileOutputStream("./src/inClass/lzw/ya.txt");
            StringBuilder s = new StringBuilder();
            int a;
            for (int i = 0; i < 900000; i++) {
                a = Math.abs(random.nextInt()%2)==0?97:98;
                s.append((char) a);
                if (i%1000==0){
                    dataOutputStream.write(s.toString().getBytes());
                    s = new StringBuilder();
                }
            }
            dataOutputStream.write(s.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
