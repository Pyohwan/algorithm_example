package example.java.basic;

/**
 * 거의 변하지 않는 클래스
 * @author pyohwan
 *
 */
public final class BookRecord {
	private String author;
	private String bookTitle;
	
	public BookRecord(String author, String bookTitle) {
		this.author = author;
		this.bookTitle = bookTitle;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

}
