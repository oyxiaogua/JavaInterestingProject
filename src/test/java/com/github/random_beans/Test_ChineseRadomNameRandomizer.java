package com.github.random_beans;

import org.junit.Test;

public class Test_ChineseRadomNameRandomizer {
	@Test
	public void testANewSingleNameRandomizer() {
		ChineseRadomNameRandomizer random = ChineseRadomNameRandomizer.aNewSingleNameRandomizer(1, 2, -1);
		String strValue;
		for (int i = 0; i < 10; i++) {
			strValue = random.getRandomValue();
			System.out.println(strValue);
		}
	}

	@Test
	public void testANewCompoundSurNameRandomizer() {
		ChineseRadomNameRandomizer random = ChineseRadomNameRandomizer.aNewCompoundSurNameRandomizer(1, 2, -1);
		String strValue;
		for (int i = 0; i < 10; i++) {
			strValue = random.getRandomValue();
			System.out.println(strValue);
		}
	}

	@Test
	public void testANewMixNameRandomizer() {
		ChineseRadomNameRandomizer random = ChineseRadomNameRandomizer.aNewMixNameRandomizer(1, 2, -1);
		String strValue;
		for (int i = 0; i < 10; i++) {
			strValue = random.getRandomValue();
			System.out.println(strValue);
		}
	}
}
