package algorithm.example;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import org.junit.Test;

public class DataStructureTest {
	
	/**
	 * 배열 정의
	 */
	@Test
	public void arrayDefinitions() {
		final int[] integers = new int[3];
		final boolean[] bools = {false, true, true, false};
		final String[] strings = new String[] {"one", "two"};
		
		final Random r = new Random();
		final String[] randomArrayLength = new String[r.nextInt(100)];
	}
	
	/**
	 * 배열 크기 확장하기
	 */
	@Test
	public void arrayCopy() {
		int[] integers = {0, 1, 2, 3, 4};
		
		int[] newIntegersArray = new int[integers.length + 1];
		System.arraycopy(integers, 0, newIntegersArray, 0, integers.length);
		integers = newIntegersArray;
		integers[5] = 5;
		
		assertEquals(5, integers[5]);
	}
	
	@Test
	public void queueInsertion() {
		final Queue<String> queue = new LinkedList<>();
		queue.add("first");
		queue.add("second");
		queue.add("third");
		
		assertEquals("first", queue.remove());
		assertEquals("second", queue.remove());
		assertEquals("third", queue.peek());
		assertEquals("third", queue.remove());
		
	}

}
