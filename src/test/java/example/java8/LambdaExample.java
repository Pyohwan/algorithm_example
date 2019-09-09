package example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
* @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
* @company  : http://jakduk.com
* @date     : 2015. 10. 20.
* @desc     :
*/
public class LambdaExample {
	public static void main(String[] args) {
		final List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		final List<Integer> result01 = new ArrayList<>();
		
		for (Integer number : list) {
			if (number > 2) {
				result01.add(number);
			}
		}
		
		final List<Integer> result02 = new ArrayList<>();
		for (Integer number : list) {
			if (number < 7) {
				result02.add(number);
			}
		}
		
		List<Integer> result03 = filter(list, (integer) -> {
			return integer > 2;
		});
		
		final Predicate<Integer> greaterThan2 = n -> n > 2;
		
		List<Integer> result04 = filter(list, greaterThan2);
		
		final Predicate<Integer> lessThan7 = n -> n < 7;
		
		List<Integer> result05 = filter(list, lessThan7);
		
		List<Integer> result06 = filter(list, greaterThan2.and(lessThan7));
		
		System.out.println("result01=" + result01);
		System.out.println("result02=" + result02);
		System.out.println("result03=" + result03);
		System.out.println("result04=" + result04);
		System.out.println("result05=" + result05);
		System.out.println("result06=" + result06);
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		final List<T> result = new ArrayList<>();
		for (T value : list) {
			if (predicate.test(value)) {
				result.add(value);
			}
		}
		return result;
	}
	

}
