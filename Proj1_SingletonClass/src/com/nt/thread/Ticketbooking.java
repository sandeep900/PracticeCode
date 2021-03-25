package com.nt.thread;

import com.nt.sdp.Printer;

public class Ticketbooking  implements Runnable{

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Printer p=Printer.Getinstance();
		System.out.print(p.hashCode()+"\t");
	}

}
