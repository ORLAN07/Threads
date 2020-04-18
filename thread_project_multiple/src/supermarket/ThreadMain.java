package supermarket;

public class ThreadMain {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		final Server server = new Server();
		
		Thread produce = new Thread(new Runnable(){
			@Override
			public void run(){
				try {
					server.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread consume = new Thread(new Runnable(){
			@Override
			public void run(){
				try {
					server.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		produce.start();
		consume.start();
		
		
		produce.join();
		consume.join();
	}
}
