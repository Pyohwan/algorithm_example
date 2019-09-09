package example.java8;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/**
* @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
* @company  : http://jakduk.com
* @date     : 2015. 10. 22.
* @desc     :
*/
public class StreamExamples3 {
	public static void main(String[] args) {
		
		System.out.println("collect(toList())" + 
				Stream.of(1, 3, 3, 5, 5)
					.filter(i -> i >2)
					.map(i -> i * 2)
					.map(i -> "#" + i)
					.collect(toList())
		);
		
		System.out.println("collect(toSet())" + 
				Stream.of(1, 3, 3, 5, 5)
					.filter(i -> i >2)
					.map(i -> i * 2)
					.map(i -> "#" + i)
					.collect(toSet())
		);
		
		System.out.println("collect(joining())" + 
				Stream.of(1, 3, 3, 5, 5)
					.filter(i -> i >2)
					.map(i -> i * 2)
					.map(i -> "#" + i)
					.collect(joining())
		);
		
		System.out.println("collect(joining(\", \"))" + 
				Stream.of(1, 3, 3, 5, 5)
					.filter(i -> i >2)
					.map(i -> i * 2)
					.map(i -> "#" + i)
					.collect(joining(", "))
		);
		
		System.out.println("collect(joining(\", \", \"[\", \"]\"))" + 
				Stream.of(1, 3, 3, 5, 5)
					.filter(i -> i >2)
					.map(i -> i * 2)
					.map(i -> "#" + i)
					.collect(joining(", ", "[", "]"))
		);
		
		System.out.println("distinct().collect(toList()): " +
				Stream.of(1, 3, 3, 5, 5)
					.filter(i -> i > 2)
					.map(i -> i * 2)
					.map(i -> "#" + i)
					.distinct()
					.collect(toList())
				);
		
		final Integer integer127 = 127;
		// 내부적으로 박싱으로 Integer.valeOf() 메소드를 사용하는데 구현 메소드를 보면 알겠지만 -127 ~ 128 까지만 캐싱이 된다.
		// == 이거는 값을 비교하는게 아니라 메모리 주소를 비교하는거다. 따라서 캐시가 안되면 new 를 하기 때문에 메모리 주소가 달라진다.
		System.out.println(
				Stream.of(1, 2, 3, 4, 5, 127)
					.filter(i -> i == integer127)
					.findFirst()
				);
		
		final Integer integer128 = 128;
		System.out.println(
				Stream.of(1, 2, 3, 4, 5, 128)
					.filter(i -> i == integer128)
					.findFirst()
				);
		
		System.out.println(
				Stream.of(1, 2, 3, 4, 5, 128)
					.filter(i -> i.equals(integer128))
					.findFirst()
				);
		
		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		for (Integer i : numbers) {
			System.out.print("i = " + i + ", ");
		}
		
		System.out.println();
		System.out.print("forEach(i -> System.out.println(i))");
		Stream.of(1, 2, 3, 4, 5)
				.forEach(i -> System.out.print(i + " "));
	}
}
