package example.concurrency;

/**
 * 동시에 실행되는 두 개의 코드 블록
 * @author pyohwan
 *
 */
public class Threads {
	public static void main(String[] args) throws InterruptedException {
		final Thread separateThread = new Thread(new ThreadPrinter());
		separateThread.start();
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("From the main Thread: " + Thread.currentThread().getName());
			Thread.sleep(1000);
		}
	}

}
