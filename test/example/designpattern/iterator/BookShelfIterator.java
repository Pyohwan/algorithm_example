package example.designpattern.iterator;

import java.util.Iterator;

/**
 * @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
 * @company  : http://jakduk.com
 * @date     : 2015. 6. 26.
 * @desc     :
 */
public class BookShelfIterator implements Iterator {

	private BookShelf bookShelf;
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}
	
	@Override
	public boolean hasNext() {
		if (index < bookShelf.getLength()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

}
