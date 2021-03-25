package com.nt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.nt.sdp.Printer;

public class SingletonTest_ReflectionApi {


	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Printer p1=Printer.Getinstance();
		Class c=p1.getClass();
	Constructor cons[]=	c.getDeclaredConstructors();
	cons[0].setAccessible(true);
	Printer p2=(Printer) cons[0].newInstance();
	System.out.println("p1  "+p1.hashCode()+"\tp2  "+p2.hashCode());
	
		
	}
	
}
