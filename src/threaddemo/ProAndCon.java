package threaddemo;

public class ProAndCon {
	static String pro = "lock";
	static String consume = "lock";
	static int count = 0;

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				while (true) {
					synchronized (pro) {
						System.out.println(this.currentThread().getName() + ":" + (++count));
						if (count > 0) {
							consume.notify();
						}
						try {
							if (count >= 10) {
								pro.wait();
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}.start();
		new Thread() {
			public void run() {
				while (true) {
					synchronized (consume) {
						System.out.println(this.currentThread().getName() + ":" + (--count));
						if (count < 10) {
							pro.notify();
						}
						try {
							if (count < 0) {
								consume.wait();
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}.start();
	}

}