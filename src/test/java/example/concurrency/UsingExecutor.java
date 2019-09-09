package example.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Executor 이용하기
 * @author pyohwan
 *
 */
public class UsingExecutor {
	
	public static void main(String args[]) {
		final Executor executor = Executors.newCachedThreadPool();
		executor.execute(new ThreadPrinter());
		executor.execute(new ThreadPrinter());
		executor.execute(new ThreadPrinter());
	}

}
