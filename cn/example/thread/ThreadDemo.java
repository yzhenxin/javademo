package cn.example.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ThreadDemo {
	public static void main(String[] args) {
		/*
		 * new Thread(new Runnable() { int i = 0;
		 * 
		 * @Override public void run() { while (i <= 10) { System.out.println("Hello " +
		 * i++); } } }).start();
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(sdf.format(new Date()));
		Calendar c = GregorianCalendar.getInstance();
		System.out.println(sdf.format(c.getTime()));
		c.add(Calendar.DATE, 3);
		System.out.println(sdf.format(c.getTime()));
		c.add(Calendar.HOUR, 5);
		System.out.println(sdf.format(c.getTime()));
		c.add(Calendar.MINUTE, -30);
		System.out.println(sdf.format(c.getTime()));
		
		
	}
}
