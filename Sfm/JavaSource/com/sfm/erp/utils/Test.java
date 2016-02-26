package com.sfm.erp.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("root-context.xml");
		System.out.println("hhhhhhhhhhh");
	}

}
