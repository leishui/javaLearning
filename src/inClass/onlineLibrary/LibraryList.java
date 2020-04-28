package inClass.onlineLibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryList {
	private List<Book> library;

	public LibraryList() {
		library = new ArrayList<Book>();
	}

	public void addBook(Book book) {
		library.add(book);
	}

	public int borrow(Reader reader, String bookNo, int n) {
		int bRet = 0;
		for(Book e : library) {
			if(e.getBookNo()==Integer.parseInt(bookNo)) {
				if(e.log(reader, n)) {
					bRet = e.getBookNo();
				}
				else
					bRet = -1;
			}
		}

		return bRet;
	}

	public int revert(Reader reader, String bookName, int n) {
		int bRet = 0;
		/*
		 * for(Book e : library) { if(e.getBookName().equals(bookName)) {
		 * if(e.log(reader, n)) { bRet = e.getBookNo(); } else bRet = -1; } }
		 */

		return bRet;
	}

	public Book queryBook(int bookNo) {
		for(Book e : library) {
			if(e.getBookNo() == bookNo) {
				return e;
			}
		}
		
		return null;
	}

	public List<Book> queryAll(){
	    return library;
    }

    public List<Book>  queryCan() {
        List<Book> list = new ArrayList<>();
        for (Book book : library) {
            if (book.getnCount() != 0) {
                list.add(book);
            }
        }
        return list;
    }
}
