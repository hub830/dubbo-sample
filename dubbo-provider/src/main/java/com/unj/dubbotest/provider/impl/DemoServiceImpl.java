package com.unj.dubbotest.provider.impl;

import com.unj.dubbotest.provider.DemoService;

public class DemoServiceImpl implements DemoService {
	public String build(String name) throws Exception {
		System.out.println("name is === " + name);
		return "ÄãºÃ Ãû³ÆÊÇ ------------- >>>> " + name;
	}
}