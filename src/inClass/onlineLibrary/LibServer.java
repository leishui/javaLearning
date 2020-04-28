package inClass.onlineLibrary;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class LibServer {

    public static void main(String[] args) {
        LibraryList library = new LibraryList();
        library.addBook(new Book("Java", 1001, 10));
        library.addBook(new Book("C++", 1002, 10));
        library.addBook(new Book("123", 1003, 10));

        ServerSocket server = null;
        try {
            server = new ServerSocket(9011);
            System.out.println("ServerCreated");
            //3.
            while (true) {
                Socket client = server.accept();
                System.out.println("connected");
                ServerThread thread = new ServerThread(client);
                thread.setOption(new Option() {
                    @Override
                    public List<Book> queryCan() {
                        return library.queryCan();
                    }

                    @Override
                    public List<Book> queryAll() {
                        return library.queryAll();
                    }

                    @Override
                    public Book query(String no) {
                        return library.queryBook(Integer.parseInt(no));
                    }

                    @Override
                    public int borrow(Reader reader, String bookNo,String n) {
                        if (library.borrow(reader,bookNo,Integer.parseInt(n))!=-1){
                            for (int i = 0; i < Integer.parseInt(n); i++) {
                                reader.borrow(Integer.parseInt(bookNo));
                            }
                            return 0;
                        }else
                            return -1;
                    }

                    @Override
                    public int reserve(Reader reader, String bookName,String n) {
                        return library.revert(reader,bookName,Integer.parseInt(n));
                    }
                });
                thread.setbStop(false);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
