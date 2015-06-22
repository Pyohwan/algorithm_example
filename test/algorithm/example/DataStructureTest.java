package algorithm.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;

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
	
	/**
	 * Queue 이용하기
	 */
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
	
	/**
	 * 맵에서 키를 덮어쓰는 예
	 */
	@Test
	public void overwirteKey() {
		final Map<String, String> preferences = new HashMap<>();
		preferences.put("like", "jacuzzi");
		preferences.put("dislike", "steam room");
		
		assertEquals("jacuzzi", preferences.get("like"));
		
		preferences.put("like", "sauna");
		
		assertEquals("sauna", preferences.get("like"));
	}
	
	/**
	 * TreeMap 클래스를 이용한 순서가 보존되는 순회
	 */
	@Test
	public void treeMapTraversal() {
		final Map<Integer, String> counts = new TreeMap<Integer, String>();
		counts.put(4, "four");
		counts.put(1, "one");
		counts.put(3, "three");
		counts.put(2, "two");
		
		final Iterator<Integer> keys = counts.keySet().iterator();
		assertEquals(Integer.valueOf(1), keys.next());
		assertEquals(Integer.valueOf(2), keys.next());
		assertEquals(Integer.valueOf(3), keys.next());
		assertEquals(Integer.valueOf(4), keys.next());
		assertFalse(keys.hasNext());
	}

}
