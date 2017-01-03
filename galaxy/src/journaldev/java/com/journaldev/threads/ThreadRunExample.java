package com.journaldev.threads;

public class ThreadRunExample {

	public static void main(String[] args) {

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("My Runnable - START " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("My Runnable - END " + Thread.currentThread().getName());
			}
		};

		Runnable r2 = () -> System.out.println("My Runnable r2");

		Thread tr1 = new Thread(r1, "tr1");
		Thread tr2 = new Thread(r2, "tr2");
		tr1.start();
		tr2.start();

		Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
		Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
		System.out.println("Starting Runnable threads");
		t1.start();
		t2.start();
		System.out.println("Runnable Threads has been started");

		Thread t3 = new MyThread("t3");
		Thread t4 = new MyThread("t4");
		System.out.println("Starting MyThreads");
		t3.start();
		t4.start();
		System.out.println("MyThreads has been started");
	}
}