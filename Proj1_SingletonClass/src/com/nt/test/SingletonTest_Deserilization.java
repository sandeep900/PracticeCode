package com.nt.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.nt.sdp.Printer;

public class SingletonTest_Deserilization {
	
	private static final long serialVersionUID=456285356485L;
	

	public static void main(String[] args) throws Throwable {
		
		Printer p1=Printer.Getinstance();
		System.out.println("p1 hashcode "+p1.hashCode());
		//p1.print();
		FileInputStream fis=new FileInputStream("aat.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Printer p2=(Printer) ois.readObject();
		System.out.println("p2 hashcode  "+p2.hashCode());
		p2.print();
		ois.close();
		System.out.println("Deserilization done");
		
	}
}
