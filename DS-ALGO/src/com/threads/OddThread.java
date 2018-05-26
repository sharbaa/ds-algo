package com.threads;

public class OddThread extends Thread{
NumberGenerator generator;
	
	public OddThread(NumberGenerator numbergenerator){
	this.generator = numbergenerator;
		
		
	}
	
	
	public void run(){
	
		generator.printOdd();
	}
}
