package inClass.lzw;

import java.io.IOException;

public class Test {
    private static String filePath = "./src/inClass/lzw/ya.txt";// 要压缩的文件
    private static String zipPath = "./src/inClass/lzw/zip.txt";// 压缩后的文件
    private static String unzipPath = "./src/inClass/lzw/unzip.txt";// 解压后的文件
    public static void main(String[] args) throws IOException {

        //压缩
        LzwZip lzwZip = new LzwZip();
        lzwZip.zip(filePath,zipPath);
        //解压
        LzwUnzip jie = new LzwUnzip();
        jie.unzip(zipPath, unzipPath);
    }
}
