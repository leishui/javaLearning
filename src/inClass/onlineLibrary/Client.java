package inClass.onlineLibrary;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OutputStream outputStream;
        InputStream inputStream;
        try {
            Socket socket = new Socket("127.0.0.1", 9011);
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            new Thread(() -> {
                try {
                    //outputStream.write(input.getBytes());
                    send(outputStream, scanner);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
            new Thread(() -> {
                byte[] bytes = new byte[1024];
                int len;
                try {
                    System.out.println(
                        "1.用户登录\n" +
                            "2.查询可借图书列表，即当前可借阅数量大于0的所有图书；\n" +
                            "3.查询图书馆中所有图书列表；\n" +
                            "4.查询某本指定图书的借阅信息，包括当前借阅人列表和被借阅次数，可借阅数量；\n" +
                            "5.借阅图书；\n" +
                            "6.归还图书；\n" +
                            "7.用户登出；\n" +
                            "输入其他内容查看菜单");
                    while ((len = inputStream.read(bytes)) != -1) {
                        System.out.println(new String(bytes, 0, len));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void send(OutputStream outputStream, Scanner scanner) throws IOException {
        String input;
        while ((input = scanner.nextLine()) != null) {
            switch (input) {
                case "1" -> {
                    System.out.print("请输入账号：");
                    String account = scanner.nextLine();
                    System.out.print("请输入密码：");
                    String password = scanner.nextLine();
                    outputStream.write(("1:" + account + ":" + password).getBytes());
                }
                case "2" -> outputStream.write("2:0".getBytes());
                case "3" -> outputStream.write("3:0".getBytes());
                case "4" -> {
                    System.out.print("请输入编号：");
                    String no = scanner.nextLine();
                    outputStream.write(("4:"+no).getBytes());
                }
                case "5" -> {
                    System.out.print("请输入编号：");
                    String no = scanner.nextLine();
                    System.out.print("请输入数量：");
                    String count = scanner.nextLine();
                    outputStream.write(("5:"+ no + ":" + count).getBytes());
                }
                case "6" -> {
                    System.out.print("请输入编号：");
                    String no = scanner.nextLine();
                    System.out.print("请输入数量：");
                    String count = scanner.nextLine();
                    outputStream.write(("6:"+ no + ":" + count).getBytes());
                }
                case "7" -> outputStream.write("7:0".getBytes());
                default -> System.out.println(
                    "1.用户登录\n" +
                        "2.查询可借图书列表，即当前可借阅数量大于0的所有图书；\n" +
                        "3.查询图书馆中所有图书列表；\n" +
                        "4.查询某本指定图书的借阅信息，包括当前借阅人列表和被借阅次数，可借阅数量；\n" +
                        "5.借阅图书；\n" +
                        "6.归还图书；\n" +
                        "7.用户登出；\n" +
                        "输入其他内容查看菜单");
            }
        }
    }
}
