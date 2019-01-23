package Concurrency;

import java.util.concurrent.locks.*;

public class MutexEvenGenerator extends IntGenerator {
	private int currentEvenValue=0;
	private Lock lock= new ReentrantLock();
	public int next() {
		lock.lock();
		try{
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();
		}
	}
}