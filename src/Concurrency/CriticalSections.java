package Concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;


class Pairs {
	private int x, y;
	public Pairs(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public Pairs() { this(0,0); }
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	public void incrementX() { x++; }
	public void incrementY() { y++; }
	public String toString() {
		return "x: "+this.x+"   y: "+this.y;
	}
	public class PairValuesNotEqualException extends RuntimeException{
		public PairValuesNotEqualException() {
			super("Pairs values not equal: " + Pairs.this);
		}
	}
	public void checkState() {
		if (x != y) {
			throw new PairValuesNotEqualException();
		}
	}
}

abstract class PairManagers {
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pairs p = new Pairs();
	private List<Pairs> storage= Collections.synchronizedList(new ArrayList<Pairs>());
	public synchronized Pairs getPair() {
		return new Pairs(p.getX(),p.getY());
	}
	protected void store(Pairs p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException ignore) {}
	}
	public abstract void increment();
}



class PairManagers1 extends PairManagers {
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}

class PairManagers2 extends PairManagers {
	public void increment() {
		Pairs temp;
		synchronized(this) {
			p.incrementX();
			p.incrementY();
			temp=getPair();
		}
		store(temp);
	}
}

class PairManipulators implements Runnable{
	private PairManagers pm;
	public PairManipulators(PairManagers pm) {
		this.pm=pm;
	}
	public void run() {
		while (true) {
			pm.increment();
		}
	}
	public String toString() {
		return "Pairs: " + pm.getPair() + "checkCounter= " + pm.checkCounter.get();
	}
}

class PairCheckers implements Runnable{
	private PairManagers pm;
	public PairCheckers(PairManagers pm) {
		this.pm=pm;
	}
	public void run() {
		while (true) {
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}
}

public class CriticalSections {
	static void testApproaches(PairManagers pmn1, PairManagers pmn2) {
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulators pm1 = new PairManipulators(pmn1);
		PairManipulators pm2 = new PairManipulators(pmn2);
		PairCheckers pc1 = new PairCheckers(pmn1),
					pc2 = new PairCheckers(pmn2);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pc1);
		exec.execute(pc2);
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException ig) {
			System.out.println("Sleep Interrupted!");
		}
		System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
	    System.exit(0);
	}
	public static void main(String[] args) {
		PairManagers pmn1 = new PairManagers1();
		PairManagers pmn2 = new PairManagers2();
		testApproaches(pmn1,pmn2);
		}
}
