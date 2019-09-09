package example.java8;
/**
* @author <a href="mailto:phjang1983@daum.net">Jang,Pyohwan</a>
* @company  : http://jakduk.com
* @date     : 2015. 10. 21.
* @desc     :
*/
public class OopAndFpExamples {
	public static void main(String[] args) {
		
		final FpCalculatorService fpCalculatorService = new FpCalculatorService();
		System.out.println(fpCalculatorService.calculate((i1, i2) -> i1 + i2, 11, 4));
	}

}

interface Calculation {
	int calculate(int num1, int num2);
}

class FpCalculatorService {
	public int calculate(Calculation calculation, int num1, int num2) {
		if (num1 > 10 && num2 < num1) {
			return calculation.calculate(num1, num2);
		} else {
			throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
		}
	}
}