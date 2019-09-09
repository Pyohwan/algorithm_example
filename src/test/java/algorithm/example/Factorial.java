package algorithm.example;

/**
 * 재귀적 방법을 사용하지 않는 팩토리얼 구현을 작성하라.
 * @author pyohwan
 *
 */
public class Factorial {
	
	public static long factorial(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n must be greater than zero");
		}
		
		long toReturn = 1;
		for (int i = 1 ; i <= n ; i++) {
			toReturn *= i;
		}
		
		return toReturn;
	}

}
