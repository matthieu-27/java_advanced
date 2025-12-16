package fr.fms.exo3;

public class TestRunnable implements Runnable {
	@Override
	public void run() {
		String[] str = {"!*!","\"**\"","#***#","$****$","%*****%","&******&","'*******'","(********(",")**********)","************"};
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
	
	public static void main(String[] args) {
		Thread th = new Thread(new TestRunnable());
		th.start();
	}
}
