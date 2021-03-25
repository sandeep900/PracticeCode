package com.nt.test;



import com.nt.sdp.Printer;

public class SingletonTest {

	public static void main(String[] args) throws Exception {
		
		//Class.forName("Printer");
		Printer p1=Printer.Getinstance();
		Printer p2=Printer.Getinstance();
		Printer p3=Printer.Getinstance();
		System.out.println(p1.hashCode()+"\t"+p2.hashCode()+"\t"+p3.hashCode());
		System.out.println("p1==p2"+(p1==p2));
		p1.print();
		p2.print();
		
		
	}
}
