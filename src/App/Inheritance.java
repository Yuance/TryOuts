package App;

class Shapey {
	void draw() {
		System.out.println("Shape draw");
	}
	void print() {
		System.out.println("Shape print");
	}
}

class Circley extends Shapey {
	void draw() {
		System.out.println("Circle draw");
	}
	
}

class Square extends Shapey {
	void draw() {
		System.out.println("Square draw");
	}
	
//	void print() {
//		System.out.println("Square print");
//	}
}

public class Inheritance{
	public static void main(String[] args) {
		Shapey s = new Circley();
		s.print();
	}
}