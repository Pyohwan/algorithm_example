package example.designpattern.factory;
/**
 * @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
 * @company  : http://jakduk.com
 * @date     : 2015. 6. 26.
 * @desc     :
 */
public class AnimalFactory {
	public static Animal create(String animalName) {
		if (animalName == null) {
			throw new IllegalAccessError("need to not null.");
		}
		
		if (animalName.equals("cow")) {
			return new Cow();
		} else if (animalName.equals("cat")) {
			return new Cat();
		} else if (animalName.equals("dog")) {
			return new Dog();
		} else {
			return null;
		}
	}
}