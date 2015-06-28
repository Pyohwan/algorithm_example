package algorithm.example;

import org.junit.Test;

public class ReverstString {
	
	/**
	 * StringBuilder 클래스 이용해 String 객체 뒤집기
	 * @param s
	 * @return
	 */
	public static String reverse(final String s) {
		final StringBuilder builder = new StringBuilder(s.length());
		for (int i = s.length() - 1 ; i >= 0 ; i--) {
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}
	
	/**
	 * 원래 위치에 있는 String 객체의 문자열 뒤집기
	 * @param s
	 * @return
	 */
	public static String inPlaceReverse(final String s) {
		final StringBuilder builder = new StringBuilder(s);
		for (int i = 0 ; i < builder.length() / 2 ; i++) {
			final char tmp = builder.charAt(i);
			final int otherEnd = builder.length() - i - 1;
			builder.setCharAt(i, builder.charAt(otherEnd));
			builder.setCharAt(otherEnd, tmp);
		}
		
		return builder.toString();
	}
	
	@Test
	public void reverseTest() {
		System.out.println(reverse("Seongnam FC"));
		System.out.println(inPlaceReverse("Seongnam FC"));
	}

}
