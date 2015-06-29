package example.java.basic;

import java.lang.reflect.Field;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookRecordTest {

	/**
	 * 리플렉션 API를 이용해 private 필드 변경하기
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	@Test
	public void mutateBookRecordState() throws IllegalAccessException, NoSuchFieldException, SecurityException {
		final BookRecord record = new BookRecord("Suzanne Collins", "The Hunger Games");
		final Field author = record.getClass().getDeclaredField("author");
		author.setAccessible(true);
		author.set(record, "Catching Fire");
		
		assertEquals("Catching Fire", record.getAuthor());
	}
}
