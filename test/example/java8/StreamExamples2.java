package example.java8;

import java.util.Arrays;
import java.util.List;

/**
* @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
* @company  : http://jakduk.com
* @date     : 2015. 10. 22.
* @desc     :
*/
public class StreamExamples2 {
	public static void main(String[] args) {
		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer result = null;
		for (final Integer number : numbers) {
			if (number > 3 && number < 9) {
				final Integer newNumber = number * 2;
				if (newNumber > 10) {
					result = newNumber;
					break;
				}
			}
		}
		
		System.out.println("Imperative Result: " + result);
		
		System.out.println("Functional Result: " +
				numbers.stream()
						.filter(number -> number > 3)
						.filter(number -> number < 9)
						.map(number -> number * 2)
						.filter(number -> number > 10)
						.findFirst()
		);
		
	}

}
