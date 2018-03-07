package me.puneetghodasara.learning;

class NonDeadlockedBroker {

	private String name;

	public NonDeadlockedBroker(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Broker [name=" + name + "]";
	}

	public void sendMessage(NonDeadlockedBroker to, String msg) throws InterruptedException {

		System.out.println("Before Acquiring lock sendMessage for " + this.toString());
		// Thread.sleep(1000);

		synchronized (Broker.class) {
			System.out.println("Lock acquired sendMessage for" + this.toString());
			Thread.sleep(1000);
			to.recMessage(this, msg);

		}

	}

	public void recMessage(NonDeadlockedBroker from, String msg) throws InterruptedException {

		System.out.println("Before Acquiring lock recMessage for " + this.toString());
		// Thread.sleep(1000);

		synchronized (Broker.class) {
			System.out.println("Lock acquired recMessage for" + this.toString());

			printMessage(msg);

		}

	}

	public void printMessage(String msg) throws InterruptedException {

		System.out.println("Before Acquiring lock ackMessage for " + this.toString());

		synchronized (Broker.class) {
			System.out.println("Lock acquired ackMessage for" + this.toString());

			System.out.println("Message : " + msg);
			Thread.sleep(4000);

		}

	}

}
