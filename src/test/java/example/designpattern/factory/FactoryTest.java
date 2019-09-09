package example.designpattern.factory;

import org.junit.Test;

/**
 * @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
 * @company  : http://jakduk.com
 * @date     : 2015. 6. 26.
 * @desc     :
 */
public class FactoryTest {
	
	@Test
	public void factoryTest() {
		Animal a1 = AnimalFactory.create("cow");
		a1.printDescription();
		Animal a2 = AnimalFactory.create("cat");
		a2.printDescription();
		Animal a3 = AnimalFactory.create("dog");
		a3.printDescription();
	}

}
