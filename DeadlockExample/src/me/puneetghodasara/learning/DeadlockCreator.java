package me.puneetghodasara.learning;

public class DeadlockCreator {

	public static void main(String[] args) throws InterruptedException {
		Broker b1 = new Broker("Krishna");
		Broker b2 = new Broker("Rama");

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					b1.sendMessage(b2, "Hi Rama");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					b2.sendMessage(b1, "Hi Krishna");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
}
