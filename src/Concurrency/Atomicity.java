package Concurrency;

public class Atomicity {
	int i;
	/*synchronized*/ void  f1() {i++;}
	void f2() {i+=3;}
}