package algorithm.example;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
 * @company  : http://jakduk.com
 * @date     : 2015. 6. 26.
 * @desc     :
 */
public class AnagramsTest {
	
	@Test
	public void anagramsTest() {
		Anagrams anagrams = new Anagrams(Arrays.asList("football", "echo"));
		System.out.println(anagrams.getAnagrams("echo"));
	}	
}
