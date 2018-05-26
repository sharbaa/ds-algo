package com.threads;

public class EvenThread extends Thread{
	
	
	NumberGenerator generator;
	
	public EvenThread(NumberGenerator numbergenerator){
	this.generator = numbergenerator;
		
		
	}
	
	
	public void run(){
		generator.printEven();
	}

}