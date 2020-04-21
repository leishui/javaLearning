package experiment.experiment_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class T3_2 {
    public static void main(String[] args) {
        String sourcePath = "./src/experiment/experiment_3/source.txt";
        String copyPath = "./src/experiment/experiment_3/copy.txt";
        byte[] bytes = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(sourcePath);
            FileOutputStream fileOutputStream = new FileOutputStream(copyPath);
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
