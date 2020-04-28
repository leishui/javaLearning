package inClass.onlineLibrary;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket client;
    private boolean bStop;
    private boolean isLogin = false;
    private Option option = null;
    private String account;

    public void setOption(Option option){
        this.option = option;
    }

    public ServerThread(Socket client) {
        this.client = client;
    }


    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public boolean isbStop() {
        return bStop;
    }

    public void setbStop(boolean bStop) {
        this.bStop = bStop;
    }

    public void run() {
        String returnInfo = "-1:error";
        String strInfo;
        byte[] bytes = new byte[1024];
        int len;
        try {
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            while (!bStop) {
                if (client.isClosed()) {
                    bStop = true;
                    continue;
                }
                while ((len=inputStream.read(bytes)) != -1) {
                    strInfo = new String(bytes,0,len);
                    System.out.println(strInfo);
                    String[] strArray = strInfo.split(":");
                    if (strArray.length < 2) {
                        outputStream.write("指令有误".getBytes());
                        continue;
                    }
                    switch (strArray[0]) {
                        case "2":
                            if (isLogin){
                                StringBuilder builder = new StringBuilder();
                                for (Book book : option.queryCan()) {
                                    builder.append(book).append("\n");
                                }
                                returnInfo = builder.toString();
                            }else
                                returnInfo = "请先进行登录";
                            break;
                        case "1":
                            if (strArray.length>2){
                                String username = strArray[1];
                                String password = strArray[2];
                                account = username;
                                if (username.equals("hhh") && password.equals("666")) {
                                    returnInfo = "login success";
                                    isLogin = true;
                                } else if (username.equals("aaa") && password.equals("666")){
                                    returnInfo = "login success";
                                    isLogin = true;
                                }else
                                    returnInfo = "login failure";
                            }else
                                returnInfo = "参数有误";
                            break;
                        case "3":
                            if (isLogin){
                                StringBuilder builder = new StringBuilder();
                                for (Book book : option.queryAll()) {
                                    builder.append(book.toString()).append("\n");
                                }
                                returnInfo = builder.toString();
                            }else
                                returnInfo = "请先进行登录";
                            break;
                        case "4":
                            if (isLogin){
                                if (strArray.length==2){
                                    Book book = option.query(strArray[1]);
                                    StringBuilder builder = new StringBuilder();
                                    for (Reader reader : book.getReaders()) {
                                        builder.append("借阅者：\t").append(reader.getName()).append("\t数量：").append(reader.getKeepBooks().size()).append("本\n");
                                    }
                                    returnInfo = book.toString() +"\n"+ builder.toString();
                                }else
                                    returnInfo = "格式错误";
                            }else
                                returnInfo = "请先进行登录";
                            break;
                        case "5":
                            if (isLogin){
                                if (strArray.length == 3){
                                    String no = strArray[2];
                                    String name = strArray[1];
                                    if (option.borrow(new Reader(account,account),name,no)!=-1){
                                        returnInfo = "借取成功";
                                    }else
                                        returnInfo = "借取失败";
                                }else
                                    returnInfo = "格式错误";
                            }else
                                returnInfo = "请先进行登录";
                            break;
                        case "6":
                            if (isLogin){
                                if (strArray.length == 3){
                                    String name = strArray[1];
                                    String no = strArray[2];
                                    if (option.reserve(new Reader(account,account),name,no)!=-1){
                                        returnInfo = "归还成功";
                                    }else
                                        returnInfo = "归还失败";
                                }else
                                    returnInfo = "格式错误";
                            }else
                                returnInfo = "请先进行登录";
                            break;
                        case "7":
                            if (isLogin){
                                bStop=true;
                                returnInfo = "登出成功";
                            }else
                                returnInfo = "未登录";
                            break;
                        default:
                            break;
                    }
                    outputStream.write(returnInfo.getBytes());
                    if (bStop){
                        break;
                    }
                }
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
