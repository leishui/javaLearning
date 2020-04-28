package inClass.onlineLibrary;

import java.util.ArrayList;
import java.util.List;

public class Reader {
	private String name;
	private String No;
	
	private List<Integer> keepBooks;
	
	public Reader() {
		keepBooks = new ArrayList<Integer>();
	}
	
	public Reader(String name, String No) {
		this.name = name;
		this.No = No;
		keepBooks = new ArrayList<Integer>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
	}

	public void borrow(int bNo) {
		keepBooks.add(bNo);
	}
	
	public void revert(int bNo) {
		for(int i=0; i<keepBooks.size(); i++) {
			if(keepBooks.get(i).equals(bNo)) {
				keepBooks.remove(i);
			}
		}
	}
	
	public List<Integer> getKeepBooks(){
		return this.keepBooks;
	}
	
	public boolean isKeepEmpty() {
		return keepBooks.isEmpty();
	}
	
}
