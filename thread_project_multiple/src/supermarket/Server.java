package supermarket;

public class Server {
	
	public Boolean empty = false;
	
	public void produce() throws InterruptedException{
		synchronized(this){
			empty = true;
			System.out.println("in produce " + empty);
			Thread.sleep(3000);
		}
	}
	
	public void consume() throws InterruptedException{
		synchronized(this){
			while(!empty){
				wait();
			}
			notify();
			System.out.println("in consume " + empty);
			Thread.sleep(1000);
		}
	}

}
