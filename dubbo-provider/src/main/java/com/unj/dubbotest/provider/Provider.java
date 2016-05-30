package com.unj.dubbotest.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		context.start();

		System.out.println("新浪微博：疯狂的杨中仁.");

		System.in.read(); // 按任意键退出
	}

}