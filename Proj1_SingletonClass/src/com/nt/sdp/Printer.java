package com.nt.sdp;

import com.nt.utils.Commonutils;

public class Printer extends Commonutils
{

	//private static Printer instance=new Printer();//eager instantiation
	//private static Printer instance;
	//private static volatile Printer instance;
	
	private  Printer() {
		if(InnerPrinter.instance==null)
		throw new RuntimeException("object create only one time");	
			
System.out.println("Printer() 0 param cons.");

	}
	
	
	/*public  static Printer Getinstance(){
	instance=new Printer();
	return instance;
	}
	
	*/	
		
	/*	public  static   Printer Getinstance() //enabling synchronized method or block
		{
			//synchronized  block class level locking
			//long start=System.currentTimeMillis();
			if(instance==null)
				synchronized (Printer.class) {
		    	if(instance==null)
		          instance=new Printer();	
		    }
		//	long end=System.currentTimeMillis();
		
			//System.out.println("time taken"+(end-start));
			
		return instance;
		
		}
	*/
		
	//best soln nested inner class
	
	public static class InnerPrinter{
		 
	private static  volatile Printer instance =new Printer();
		
	}
	
	
	public  static Printer Getinstance(){
		
	   return  InnerPrinter.instance;
		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("clonning not support");
	}
	//for deserilization stop override read resolve()
	private static final long serialVersionUID =456285356485L;
	public Object readResolve() {
      return  InnerPrinter.instance;
		
	}
	  
	
	public void print() {
		System.out.println("b.logic execute");
		
	}
}
