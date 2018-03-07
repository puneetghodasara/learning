package me.puneetghodasara.learning;

public class NonDeadlockCreator {

	public static void main(String[] args) throws InterruptedException {
		NonDeadlockedBroker b1 = new NonDeadlockedBroker("Krishna");
		NonDeadlockedBroker b2 = new NonDeadlockedBroker("Rama");

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
