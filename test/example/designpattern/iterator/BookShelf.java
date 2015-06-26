package example.designpattern.iterator;

import java.util.Iterator;

/**
 * @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
 * @company  : http://jakduk.com
 * @date     : 2015. 6. 26.
 * @desc     :
 */
public class BookShelf implements Aggregate {
	private Book[] books;
	private int last = 0;
	
	public BookShelf(int maxsize) {
		this.books = new Book[maxsize];
	}
	
	public Book getBookAt(int index) {
		return books[index];
	}
	
	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}
	
	public int getLength() {
		return last;
	}

	@Override
	public Iterator iterator() {
		return new BookShelfIterator(this);
	}

}
