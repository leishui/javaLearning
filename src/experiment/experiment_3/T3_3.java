package experiment.experiment_3;

import java.io.*;

public class T3_3 {

    public static void main(String[] args) {
        String path = "./src/experiment";
        File file = new File(path);
        factFiles(file);
    }

    private static void factFiles(File file) {
        BufferedReader br;
        String s;

        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for(File f : files) {
                    factFiles(f);
                }
            }
        } else if (file.getName().endsWith(".java")){
            try {
                br = new BufferedReader(new FileReader(file));
                boolean comm = false;
                int codeComments = 0;
                int codeBlank = 0;
                int code = 0;
                while((s = br.readLine()) != null) {
                    if(s.startsWith("/*") && s.endsWith("*/")) {
                        codeComments++;
                    } else if(s.trim().startsWith("//")) {
                        codeComments++;
                    } else if(s.startsWith("/*") && !s.endsWith("*/")) {
                        codeComments++;
                        comm = true;
                    } else if(!s.startsWith("/*") && s.endsWith("*/")) {
                        codeComments++;
                        comm = false;
                    } else if(comm) {
                        codeComments++;
                    } else if(s.trim().length() < 1) {
                        codeBlank++;
                    } else {
                        code++;
                    }
                }
                br.close();
                System.out.println(file+"\t有效行数："+code+"\t空白行数："+codeBlank+"\t注释行数："+codeComments);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
