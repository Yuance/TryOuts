package interfaces;


interface Service {
	void method1();
	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implementation1 implements Service {
	Implementation1() {}
	public void method1() {System.out.println("Implememtation1 Method1");}
	public void method2() {System.out.println("Implementation1 Mtthod2");}
}

class Implementation1Factory implements ServiceFactory {
	Implementation1Factory() {}
	public Service getService() {
		return new Implementation1();
	}
}

class Implementation2 implements Service {
	Implementation2() {}
	public void method1() {System.out.println("Implementation2 Method1");};
	public void method2() {System.out.println("Implementation2 Method2");};
}

class Implementation2Factory implements ServiceFactory {
	Implementation2Factory() {}
	public Service getService() {
		return new Implementation2();
	}
}

public class Factories {
	public static void main (String[] args) {
		serviceConsumer(new Implementation1Factory());
		serviceConsumer(new Implementation2Factory());
	}
	public static void serviceConsumer(ServiceFactory fact) {
		fact.getService().method1();
		fact.getService().method2();
	}
}