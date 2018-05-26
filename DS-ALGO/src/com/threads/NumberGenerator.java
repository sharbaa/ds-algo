package com.threads;

/**
 * print sequence from 1 - 20 using two threads
 * @author badsharma
 *
 */
public class NumberGenerator {

	 boolean isEven =false;
	 int i=1;
	 int max=20;
	
	
	public NumberGenerator(boolean flag,int i, int max){
		this.isEven=flag;
		this.i =i;
		this.max = max;
	}
	
	
	public void printEven(){
		
		synchronized (this) {
			while(i<max){
				while(!isEven){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("even thread t2 "+i);
				i=i+1;
				isEven=false;
				notify();
				
			}}
		
	}
	
	
	public void printOdd(){
		
		synchronized (this) {
			while(i<max){
				
				while(isEven){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("odd thread t1 "+i);
				i=i+1;
				isEven=true;
				notify();
				
			}
			
			
		}
		
	}



	
}
