package inClass.onlineLibrary;

import java.io.*;
import java.util.HashMap;

public class LibServer {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        try {
            //根据具体路径进行修改
            InputStream inputStream = new FileInputStream("./src/inClass/onlineLibrary/users.txt");
            initUsers(inputStream,map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initUsers(InputStream inputStream, HashMap<String, String> map) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        map.clear();
        while ((line = bufferedReader.readLine())!=null){
            map.put(line,bufferedReader.readLine());
        }
    }
}
