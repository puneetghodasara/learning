package me.puneetghodasara.learning;

class Broker {

	private String name;

	public Broker(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Broker [name=" + name + "]";
	}

	public void sendMessage(Broker to, String msg) throws InterruptedException {

		System.out.println("Before Acquiring lock sendMessage for " + this.toString());
		// Thread.sleep(1000);

		synchronized (this) {
			System.out.println("Lock acquired sendMessage for" + this.toString());
			Thread.sleep(1000);
			to.recMessage(this, msg);

		}

	}

	public void recMessage(Broker from, String msg) throws InterruptedException {

		System.out.println("Before Acquiring lock recMessage for " + this.toString());
		// Thread.sleep(1000);

		synchronized (this) {
			System.out.println("Lock acquired recMessage for" + this.toString());

			printMessage(msg);

		}

	}

	public void printMessage(String msg) throws InterruptedException {

		System.out.println("Before Acquiring lock ackMessage for " + this.toString());

		synchronized (this) {
			System.out.println("Lock acquired ackMessage for" + this.toString());

			System.out.println("Message : " + msg);
			Thread.sleep(4000);

		}

	}

}
