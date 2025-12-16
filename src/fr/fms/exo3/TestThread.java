package fr.fms.exo3;

public class TestThread extends Thread {
	public TestThread(String name) {
		super(name);
	}
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.print(this.getName());
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TestThread t1 = new TestThread("1-");
		TestThread t5 = new TestThread("5-----");
		TestThread t4 = new TestThread("4----");
		TestThread t3 = new TestThread("3---");
		TestThread t2 = new TestThread("2--");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
