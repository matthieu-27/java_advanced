package fr.fms.exo3;

public class TestRunnable implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.toString());
		}
	}
	
	public static void main(String[] args) {
		Thread th = new Thread(new TestRunnable());
		th.start();
	}
}
