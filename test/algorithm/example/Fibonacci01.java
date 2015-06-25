package algorithm.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * 1에서 n까지의 피보나치 수열을 반환하는 메서드를 작성하라.
 * @author pyohwan
 *
 */
public class Fibonacci01 {
	
	/**
	 * 반복 피보나치 수열
	 * @param n
	 * @return
	 */
	public static List<Integer> fibonacci(int n) {
		
		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}
		
		if (n == 0) {
			return new ArrayList<Integer>();
		}
		
		if (n == 1) {
			return Arrays.asList(0);
		}
		
		if (n == 2) {
			return Arrays.asList(0, 1);
		}
		
		final List<Integer> seq = new ArrayList<Integer>(n);
		seq.add(0);
		n = n - 1;
		seq.add(1);
		n = n - 1;
		
		while (n > 0) {
			int a = seq.get(seq.size() - 1);
			int b = seq.get(seq.size() - 2);
			seq.add(a + b);
			n = n - 1;
		}
		
		return seq;
	}
	
	/**
	 * 피보나치 수열 테스트
	 */
	@Test
	public void fibonacciList() {
		assertEquals(0,  fibonacci(0).size());
		assertEquals(Arrays.asList(0),  fibonacci(1));
		assertEquals(Arrays.asList(0, 1),  fibonacci(2));
		assertEquals(Arrays.asList(0, 1, 1),  fibonacci(3));
		assertEquals(Arrays.asList(0, 1, 1, 2),  fibonacci(4));
		assertEquals(Arrays.asList(0, 1, 1, 2, 3),  fibonacci(5));
		assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5),  fibonacci(6));
		assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8),  fibonacci(7));
		assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13),  fibonacci(8));
	}
}
