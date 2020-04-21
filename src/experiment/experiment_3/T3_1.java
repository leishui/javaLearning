package experiment.experiment_3;

import java.io.File;
import java.io.IOException;

public class T3_1 {
    public static void main(String[] args) {
        //创建两个文件
        File file1 = new File("./src/experiment/experiment_3/1.txt");
        File file2 = new File("./src/experiment/experiment_3/2.txt");
        try {
            if (file1.createNewFile())
                System.out.println("文件1.txt创建成功");
            else
                System.out.println("文件1.txt创建失败");
            if (file2.createNewFile())
                System.out.println("文件2.txt创建成功");
            else
                System.out.println("文件2.txt创建失败");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //删除2.txt
        File file = new File("./src/experiment/experiment_3/2.txt");
        if (file.delete()) {
            System.out.println("删除文件2.txt成功");
        } else {
            System.out.println("删除文件2.txt失败");
        }
    }
}
