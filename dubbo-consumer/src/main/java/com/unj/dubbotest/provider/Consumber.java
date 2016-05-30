package com.unj.dubbotest.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.unj.dubbotest.provider.DemoService;

public class Consumber {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationConsumer.xml" });
		context.start();
		DemoService demoService = (DemoService) context.getBean("demoService"); // get
		String hello = "";
		try {
			hello = demoService.build("ÐÂÀËÎ¢²©£º·è¿ñµÄÑîÖÐÈÊ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " " + hello);
	}

}