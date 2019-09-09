package example.designpattern.iterator;
/**
 * @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
 * @company  : http://jakduk.com
 * @date     : 2015. 6. 26.
 * @desc     :
 */
public class Book {
	private String name = "";

	public Book(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
