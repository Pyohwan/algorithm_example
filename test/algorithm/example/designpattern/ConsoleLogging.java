package algorithm.example.designpattern;

public class ConsoleLogging implements Logging {

	@Override
	public void write(String message) {
		System.out.println(message);
		
	}
}
