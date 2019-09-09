package example.designpattern.flyweight;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;
import org.junit.Test;

public class FlyweightTest {

	@Test
	public void sameIntegerInstances() {
		final Integer a = Integer.valueOf(56);
		final Integer b = Integer.valueOf(56);
		
		assertSame(a, b);
		
		final Integer c = Integer.valueOf(472);
		final Integer d = Integer.valueOf(472);
		
		assertNotSame(c, d);
		
	}
	

}
