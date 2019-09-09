package algorithm.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 1에서 n까지의 숫자를 출력하되 3의 배수는 Fizz라는 문자열을 출력하고, 5의 배수는 Buzz 라는 문자열을 출력하고, 
 * 15의 배수는 FizzBuzz 라는 문자열을 출력하는 알고리즘을 작성하라.
 * @author pyohwan
 *
 */
public class FizzBuzz {
	public static List<String> alternativeFizzBuzz(final int n) {
		final List<String> toReturn = new ArrayList<String>();
		for (int i = 1 ; i <= n ; i++) {
			final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");
			
			if (StringUtils.isEmpty(word)) {
				toReturn.add(Integer.toString(i));
			} else {
				toReturn.add(word);
			}
		}
		return toReturn;
	}
	
	private static String toWord(final int divisor, final int value, final String word) {
		return value % divisor == 0 ? word : "";
	}
	
	@Test
	public void fizzBuzzTest() {
		System.out.println(alternativeFizzBuzz(20));
	}

}
