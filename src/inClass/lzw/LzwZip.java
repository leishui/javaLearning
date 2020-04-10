package inClass.lzw;

import java.io.*;
import java.util.HashMap;

public class LzwZip {
    private int code = 256;// 编码
    private int range = 256;
    private String prefix = "";// 前缀
    private String suffix = "";// 后缀
    private String temp = "";// 中间变量
    HashMap<String, Integer> codeMap = new HashMap<String, Integer>();// 编码表


    public void zip(String filePath,String zipPath) throws IOException {
        // 创建文件输入流
        InputStream is = new FileInputStream(filePath);
        byte[] buffer = new byte[is.available()];// 创建缓存区域
        is.read(buffer);// 读入所有的文件字节
        String str = new String(buffer);// 对字节进行处理
        is.close(); // 关闭流
        // 创建文件输出流
        OutputStream os = new FileOutputStream(zipPath);
        DataOutputStream dos = new DataOutputStream(os);
        // 把最基本的256个Ascll码放编码表中
        for (int i = 0; i < range; i++) {
            char ch = (char) i;
            String st = ch + "";
            codeMap.put(st, i);
        }
        //开始编码
        for (int i = 0; i < str.length(); i++) {
            if(code ==65534){//超出65534（2^16-2）重新进行编码
                System.out.println("重置");
                dos.writeChar(codeMap.get(prefix));
                dos.writeChar(65535);//写出一个-1作为重置的表示与码表的打印
                codeMap.clear();//清空HashMap
                for (int j = 0; j < range; j++) {//重新将基本256个编码写入
                    char ch = (char) j;
                    String st = ch + "";
                    codeMap.put(st, j);
                }
                prefix ="";
                code =range;
            }
            char ch = str.charAt(i);
            suffix = ch + "";
            temp = prefix + suffix;
            if (codeMap.get(temp) == null) {// 如果码表中没有 前缀加后缀的码表
                codeMap.put(temp, code);// 向码表添加 前缀加后缀 和 对应的编码
                dos.writeChar(codeMap.get(prefix)); // 把前缀写入压缩文件
                code++;
                prefix = suffix;
            } else {// 如果有下一个前缀保存 上一个前缀加后缀
                prefix = temp;
            }
            if (i == str.length() - 1) {// 把最后一个写进去
                dos.writeChar(codeMap.get(prefix));
            }
        }
        os.close();// 关闭流
    }
}