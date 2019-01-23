package Concurrency;

import java.util.concurrent.*;;

public class simplePriorities implements Runnable {
	private int countdown=5;
	private double d;
	private int priority;
	public simplePriorities(int priority) {
		this.priority=priority;
	}
	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			for (int i=1;i<1000000;i++) {
				d+=(Math.PI + Math.E)/(double)i;
			if (i % 1000==0) 
				Thread.yield();
			}
		System.out.println(this);
		if (--countdown==0)
				return;
	}
	}
	public String toString() {
		return Thread.currentThread()+":"+countdown;
	}

	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool(/*new ThreadDaemonFactory()*/);
		for (int i=0; i<5; i++) 
			exec.execute(new simplePriorities(Thread.MIN_PRIORITY));
		exec.execute(new simplePriorities(Thread.NORM_PRIORITY));
		exec.execute(new simplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}

//public class ThreadDaemonFactory implements ThreadFactory {
//	public Thread newThread(Runnable r) {
//		Thread t=new thread(r);
//		t.setDaemon(true);
//		return t;
//	}
//}