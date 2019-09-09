package example.designpattern.iterator;

import java.util.Iterator;

import org.junit.Test;

/**
 * @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
 * @company  : http://jakduk.com
 * @date     : 2015. 6. 26.
 * @desc     : http://www.alan.kr/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4-iterator-%ED%8C%A8%ED%84%B4/
 */

public class IteratorTest {

	@Test
	public void iteratorTest() {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("Around the world in 80 days"));
		bookShelf.appendBook(new Book("Bible"));
		bookShelf.appendBook(new Book("Cinderella"));
		bookShelf.appendBook(new Book("Daddy-Long-Legs"));
		
		Iterator it = bookShelf.iterator();
		while (it.hasNext()) {
			Book book = (Book)it.next();
			System.out.println("" + book.getName());
		}
	}
}
