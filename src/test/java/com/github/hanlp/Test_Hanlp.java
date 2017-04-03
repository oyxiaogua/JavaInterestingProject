package com.github.hanlp;

import org.junit.Test;

import com.hankcs.hanlp.HanLP;

public class Test_Hanlp {
	@Test
	public void testHanlpConvertTraditionalChinese() {
		System.out.println(HanLP.convertToTraditionalChinese("“以后等你当上皇后，就能买草莓庆祝了”。发现一根白头发"));
		System.out.println(HanLP.convertToSimplifiedChinese("憑藉筆記簿型電腦寫程式HanLP"));
	}
}
