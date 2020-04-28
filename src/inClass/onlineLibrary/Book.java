package inClass.onlineLibrary;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String bookName;
	private int bookNo;
	private int nCount;
	private List<Reader> readers;
	
	public Book() {
		readers = new ArrayList<Reader>();
	}
	
	public Book(String bookName, int bookNo, int nCount) {
		this.bookName = bookName;
		this.bookNo = bookNo;
		this.nCount = nCount;
		readers = new ArrayList<Reader>();
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getnCount() {
		return nCount;
	}

	public void setnCount(int nCount) {
		this.nCount = nCount;
	}
	
	
	public List<Reader> getReaders() {
		return readers;
	}

	public void setReaders(List<Reader> readers) {
		this.readers = readers;
	}

	public boolean log(Reader reader, int n) {
		if(n > this.nCount) {
			System.out.println("�ݲ�ʣ����������");
			return false;
		}
		
		readers.add(reader);
		this.nCount -= n;
		return true;
	}

    @Override
    public String toString() {
        return "《"+bookName+"》\t"+"编号："+bookNo+"\t数量："+nCount;
    }
}
