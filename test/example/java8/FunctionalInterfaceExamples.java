package example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
* @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
* @company  : http://jakduk.com
* @date     : 2015. 10. 20.
* @desc     :
*/
public class FunctionalInterfaceExamples {

	public static void main(String[] args) {

		/*
		Function<String, Integer> toInt = new Function<String, Integer>() {

			@Override
			public Integer apply(String value) {
				return Integer.parseInt(value);
			}
		};
		*/
		
		// Function은 Integer 파라미터를 받아서 String을 반환한다. 작업하고 작업물 반환.
		final Function<String, Integer> toInt = value -> Integer.parseInt(value);
		
		final Integer number = toInt.apply("100");
		System.out.println(number);
		
		// Function의 identity()은 파라미터를 그대로 반환한다. 
		final Function<Integer, Integer> identity = t -> t;
		
		System.out.println(identity.apply(999));
		
		// Consumer은 파라미터만 받고 반환은 없다. 말그대로 소비할때 쓰임.
		final Consumer<String> print = value -> System.out.println(value);
		final Consumer<String> greetings = value -> System.out.println("Hello" + value);
		
		// Predicate는 파라미터를 받아 boolean을 반환한다. 검사할때 쓰임.
		Predicate<Integer> isPostive = i -> i > 0;
		
		System.out.println(isPostive.test(1));
		System.out.println(isPostive.test(0));
		System.out.println(isPostive.test(-1));
		
		List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
		List<Integer> positiveNumbers = new ArrayList<>();
		
		for (Integer num : numbers) {
			if (isPostive.test(num)) {
				positiveNumbers.add(num);
			}
		}
		
		System.out.println("positive integers: " + positiveNumbers);
		
		Predicate<Integer> lessThan3 = i -> i < 3;
		List<Integer> numbersLessThan3 = new ArrayList<>();
		
		for (Integer num : numbers) {
			if (lessThan3.test(num)) {
				numbersLessThan3.add(num);
			}
		}
		
		System.out.println("less than 3: " + numbersLessThan3);
		
		System.out.println("positive integers: " + filter(numbers, isPostive));
		System.out.println("less than 3: " + filter(numbers, lessThan3));
		
		// Supplier는 파라미터는 없지만 리턴만 있다. 언제 쓰이는지 살펴본다.
		// Supplier를 사용하면 사용 시간이 3초로 나온다. 왜냐하면 지능적이기 때문에. Supplier를 안쓰면 9초 나온다.
		long start = System.currentTimeMillis();
		//printIfValidIndex(0, getVeryExpensiveValue());
		//printIfValidIndex(-1, getVeryExpensiveValue());
		//printIfValidIndex(-2, getVeryExpensiveValue());
		printIfValidIndex(0, () -> getVeryExpensiveValue());
		printIfValidIndex(-1, () -> getVeryExpensiveValue()); // Supplier는 얘가 불필요한지 알고 있다.
		printIfValidIndex(-2, () -> getVeryExpensiveValue()); // Supplier는 얘가 불필요한지 알고 있다.
		System.out.println("It took " + ((System.currentTimeMillis() - start) /1000));
		
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
		List<T> result = new ArrayList<>();
		for (T input : list) {
			if (filter.test(input)) {
				result.add(input);
			}
		}
		
		return result;
	}
	
	private static String getVeryExpensiveValue() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "pyohwan";
	}
	
	// 자바 8 이전.
	/*
	private static void printIfValidIndex(int number, String value) {
		if (number >= 0) {
			System.out.println("The value is " + value + ".");
		} else {
			System.out.println("Invalid");
		}
	}
	*/
	
	// 자바 8 Supplier 사용.
	private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
		if (number >= 0) {
			System.out.println("The value is " + valueSupplier.get() + ".");
		} else {
			System.out.println("Invalid");
		}
	}
	
}
