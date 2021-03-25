package com.nt.test;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.nt.sdp.Printer;


public class SingletonTest_Serilization {
	//private static final long serialVersionUID  =456285356485L;
	
	public static void main(String[] args) throws Throwable {
		  
		
		Printer p1=Printer.Getinstance();
		System.out.println(""+p1.hashCode());
		//p1.print();
		FileOutputStream fos=new FileOutputStream("aat.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(p1);
		oos.flush();oos.close();
		System.out.println("serilization done");
		
	}
}
