package thread.ch05;

import java.util.concurrent.Exchanger;

public class ExchangerMain {

	public static void main(String[] args) {
		Exchanger<char[]> exchanger = new Exchanger<char[]>();
		char[] buffer1 = new char[10];
		char[] buffer2 = new char[10];
		new ExchangerProducerThread(exchanger, buffer1, 314159).start();
		new ExchangerConsumerThread(exchanger, buffer2, 314159).start();
	}

}
