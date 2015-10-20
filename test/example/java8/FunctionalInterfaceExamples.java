package example.java8;

import java.util.function.Function;

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
		final Function<String, Integer> toInt = value -> Integer.parseInt(value);
		
		final Integer number = toInt.apply("100");
		System.out.println(number);
		
	}
}
