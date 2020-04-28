package inClass.onlineLibrary;

import java.util.List;

public interface Option {
    List<Book> queryCan();
    List<Book> queryAll();
    Book query(String no);
    int borrow(Reader reader, String bookName,String n);
    int reserve(Reader reader, String bookName,String n);
}
