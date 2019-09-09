package algorithm.example;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 피보나치 수열의 n번째 값을 변환하는 메서드를 작성하라.
 * @author pyohwan
 *
 */
public class Fibonacci02 {
	
	/**
	 * n번째 피보나치 수를 찾기 위한 재귀 알고리즘
	 * @param n
	 * @return
	 */
	public static int fibN(int n) {
		
		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}
		
		if (n == 1) return 1;
		if (n == 0) return 0;
		
		return (fibN(n - 1) + fibN(n - 2));
	}
	
	private Map<Integer, Integer> fibCache = new HashMap<Integer, Integer>();
	
	public int cachedFibN(int n) {
		
		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}
		
		fibCache.put(0, 0);
		fibCache.put(1, 1);
		
		return recursiveCachedFibN(n);
	}
	
	private int recursiveCachedFibN(int n) {
		if (fibCache.containsKey(n)) {
			return fibCache.get(n);
		}
		
		int value = recursiveCachedFibN(n - 1) + recursiveCachedFibN(n - 2);
		fibCache.put(n, value);
		return value;
	}
	
	/**
	 * 성능 향상 측정하기
	 */
	@Test
	public void largeFib() {
		final long nonCachedStart = System.nanoTime();
		assertEquals(1134903170, fibN(45));
		final long nonCachedFinish = System.nanoTime();
		assertEquals(1134903170, cachedFibN(45));
		final long cachedFinish = System.nanoTime();
		
		System.out.printf("Non cached time: %d nanoseconds%n", nonCachedFinish - nonCachedStart);
		System.out.printf("Cached time: %d nanoseconds%n", cachedFinish - nonCachedFinish);
	}
}
