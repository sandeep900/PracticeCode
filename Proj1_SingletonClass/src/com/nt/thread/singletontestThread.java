package com.nt.thread;

import com.nt.sdp.Printer;

public class singletontestThread  {
	public static void main(String[] args) throws Throwable {
		
		Ticketbooking ticket=new Ticketbooking();
		Thread t1=new Thread(ticket);
		Thread t2=new Thread(ticket);
		Thread t3=new Thread(ticket);
		Thread s;
		/*for(int i=0;i<10;i++) {
			s=new Thread(ticket);	
			s.start();
		}*/
		
		t1.start();
		//Thread.sleep(1);
		t2.start();
		//Thread.sleep(2);
		t3.start();
		//t1.run();t2.run();t3.run();
		
	}

}

