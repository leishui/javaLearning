package inClass.lzw;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LzwUnzip {
    private ArrayList<Integer> integers = new ArrayList<>();
    HashMap<String, Integer> codeMapS = new HashMap<>();// 编码表
    HashMap<Integer, String> codeMapI = new HashMap<>();// 编码表
    private String cw = "";
    private String pw = "";
    private String p = "";
    private String c = "";
    private int code = 256;

    public void unzip(String path, String path1) throws IOException {
        // 读取压缩文件
        InputStream is = new FileInputStream(path);
        byte[] bytes = new byte[2];
        while (is.read(bytes)>0){
            integers.add(byteArrToInt(bytes));
        }
        is.close();
        /**
         * 把0-255位字符编码
         */
        for (int i = 0; i < 256; i++) {
            char ch = (char) i;
            String st = ch + "";
            codeMapS.put(st, i);
            codeMapI.put(i, st);
        }

        /**
         * 根据integers队列中的元素开始重新编码，输出文件
         */
        // 创建输出流
        OutputStream os = new FileOutputStream(path1);
        // 遍历integers
        for (int n : integers) {
            if (n == 65535) {
                System.out.println("unzip重置");
                codeMapS.clear();
                codeMapI.clear();
                for (int j = 0; j < 256; j++) {
                    char ch = (char) j;
                    String st = ch + "";
                    codeMapS.put(st, j);
                    codeMapI.put(j, st);
                }
                code = 256;
                pw = "";
                continue;
            }
            if (codeMapS.containsValue(n)) {// 如果编码表中存在
                cw = codeMapI.get(n);
                if (!pw.equals("")) {
                    os.write(cw.getBytes("gbk"));
                    p = pw;
                    c = cw.charAt(0) + "";// c=cw的第一个
                    codeMapS.put(p + c, code);
                    codeMapI.put(code, p + c);
                    code++;
                } else {
                    os.write(cw.getBytes("gbk"));// 第一个
                }
            } else {// 编码表中不存在
                p = pw;
                c = pw.charAt(0) + "";// c=pw的第一个
                codeMapS.put(p + c, code);
                codeMapI.put(code, p + c);
                code++;
                os.write((p + c).getBytes("gbk"));
                cw = p + c;
            }
            pw = cw;
        }
        os.close();
    }
    public int byteArrToInt(byte[] arr){
        int x = ((arr[0] & 0xff)<<8)|(arr[1] & 0xff);
        return x;
    }
}