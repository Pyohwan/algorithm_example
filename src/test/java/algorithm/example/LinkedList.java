package algorithm.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LinkedList<T> {
	private T element;
	private LinkedList<T> next;
	
	public LinkedList(T element, LinkedList<T> next) {
		this.element = element;
		this.next = next;
	}
	
	public T getElement() {
		return element;
	}
	
	public LinkedList<T> getNext() {
		return next;
	}
	
	/**
	 * 연결 리스트를 재귀적으로 뒤집기
	 * @param original
	 * @return
	 */
	public static <T> LinkedList<T> reverse(final LinkedList<T> original) {
		if (original == null) {
			throw new NullPointerException("Cannot reverse a null list");
		}
		
		if (original.getClass() == null) {
			return original;
		}
		
		final LinkedList<T> next = original.next;
		original.next = null;
		
		final LinkedList<T> othersReversed = reverse(next);
		
		next.next = original;
		
		return othersReversed;
	}
	
	/**
	 * 연결 리스트 뒤집기 테스트 하기
	 */
	@Test
	public void reverseLinkedList() {
		final LinkedList<String> three = new LinkedList<String>("3", null);
		final LinkedList<String> two = new LinkedList<String>("2", three);
		final LinkedList<String> one = new LinkedList<String>("1", two);
		
		final LinkedList<String> reversed = LinkedList.reverse(one);
		
		assertEquals("3", reversed.getElement());
		assertEquals("2", reversed.getNext().getElement());
		assertEquals("1", reversed.getNext().getNext().getElement());
	}
}
