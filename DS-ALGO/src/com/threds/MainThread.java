package com.threds;

public class MainThread {

	
	public static void main(String[] args) {
		
		NumberGenerator numbergenerator = new NumberGenerator(false,1,20);
		OddThread t1 = new OddThread(numbergenerator);
		EvenThread t2 = new EvenThread(numbergenerator);
		
	/*	Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				numbergenerator.printOdd();
				
			}
		});*/
		
		
		t1.start();
		t2.start();
				
		
		
	}
	
}
