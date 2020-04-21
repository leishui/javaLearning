package inClass.urlConnection;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://jwc.cqupt.edu.cn");
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            //StringBuilder response = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                //response.append(line);
                System.out.println(line);
            }
            inputStream.close();
            //System.out.println(response);
            //System.out.println(getStringFromInputStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getStringFromInputStream(InputStream is)
        throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        is.close();
        String state = os.toString();// 把流中的数据转换成字符串,采用的编码是utf-8(模拟器默认编码)
        os.close();
        return state;
    }
}
