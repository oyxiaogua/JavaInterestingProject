package com.github.random_beans;

import org.junit.Test;

public class Test_CustomerStringRandomizer {

	@Test
	public void testANewAlphaRandomizer() {
		CustomerStringRandomizer random = CustomerStringRandomizer.aNewAlphaRandomizer(4, 6);
		System.out.println(random.getRandomValue());
	}

	@Test
	public void testANewCustRandomizer() {
		CustomerStringRandomizer random = CustomerStringRandomizer.aNewCustRandomizer("测试随机字符串", 4, 6);
		System.out.println(random.getRandomValue());
	}
}
