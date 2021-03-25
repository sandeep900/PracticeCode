package com.nt.test;

import com.nt.sdp.Printer;

public class SingletonTest1_cloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		Printer p1=Printer.Getinstance();
		Printer p2=(Printer) p1.clone();
		System.out.println(p1.hashCode()+"\t"+p2.hashCode());
		System.out.println("p1==p2"+(p1==p2));
		p1.print();
		p2.print();
		
	}

}
