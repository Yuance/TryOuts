package Concurrency;

public class SimpleThreads {
	
	static void threadMessage(String Msg) {
		System.out.format("%s: %s%n", Thread.currentThread().getName(), Msg );
	}
	
	private static class MessageLoop implements Runnable {
		public void run() {
			String importantInfo[]= {"Mares eat oats",
	                "Does eat oats",
	                "Little lambs eat ivy",
	                "A kid will eat ivy too"
	            };
			
			try {
				for (int i=0; i<importantInfo.length; i++) {
					Thread.sleep(4000);
					threadMessage(importantInfo[i]);
					
				}
			}
			catch (InterruptedException e) {
				threadMessage("I wasnot done.");
			}
		}
	}
	
	public static void main(String args[]) throws InterruptedException {
		long patience=6000;
		if (args.length>0) {
			try {
				patience=Long.parseLong(args[0])*1000;
				patience=Integer.parseInt(args[0])*1000;
			}
			catch (NumberFormatException e) {
				System.err.println("Argument must be an integer");
				System.exit(1);
			}
		}
		
		threadMessage("Start MessageLoop");
		long startTime = System.currentTimeMillis();
		Thread t=new Thread(new MessageLoop());
		t.start();
		threadMessage("Waiting for messageThread to finish");
		while (t.isAlive()) {
			threadMessage("Still waiting...");
			t.join(1000);
			if (((System.currentTimeMillis() - startTime)>patience) && t.isAlive()) {
			threadMessage("Tired of waiting!");
            t.interrupt();
            // Shouldn't be long now
            // -- wait indefinitely
            t.join();
			}
		}
		threadMessage("Finally");
	}
}