package com.github.random_beans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.github.benas.randombeans.randomizers.AbstractRandomizer;

/**
 * 限定长度的随机字符串
 */
public class CustomerStringRandomizer extends AbstractRandomizer<String> {
	// 最大长度
	private int maxLength = 32;
	// 最小长度
	private int minLength = 1;
	// 是否固定长度
	private boolean isFixedLength = false;
	// 随机数据源
	private List<Character> randomDataSourceList;
	// 纯字母数据源
	private final List<Character> letterRandomList = IntStream.range(65, 123).mapToObj(x -> (char) x)
			.filter(Character::isLetter).collect(Collectors.toList());
	// 纯数字数据源
	private final List<Character> numberRandomList = IntStream.range(48, 58).mapToObj(x -> (char) x)
			.collect(Collectors.toList());
	// 数字字母数据源
	private final List<Character> alphaNumericRandomList = IntStream.range(48, 123)
			.filter(c -> (Character.isLetter(c) || Character.isDigit(c))).mapToObj(x -> (char) x)
			.collect(Collectors.toList());

	// ascii数据源
	private final List<Character> asciiRandomList = IntStream.range(32, 127).mapToObj(x -> (char) x)
			.collect(Collectors.toList());

	public CustomerStringRandomizer() {
		randomDataSourceList = letterRandomList;
	}

	public CustomerStringRandomizer(List<Character> randomList, int minLength, int maxLength) {
		if (randomList == null || randomList.size() == 0) {
			throw new IllegalArgumentException();
		}
		checkValue(minLength, maxLength);
		this.minLength = minLength;
		this.maxLength = maxLength;
		if (this.minLength == this.maxLength) {
			isFixedLength = true;
		}
		randomDataSourceList = new ArrayList<Character>(randomList);
	}

	public static CustomerStringRandomizer aNewAlphaRandomizer(int minLength, int maxLength) {
		return new CustomerStringRandomizer(true, false, false, minLength, maxLength);
	}

	public static CustomerStringRandomizer aNewNumberRandomizer(int minLength, int maxLength) {
		return new CustomerStringRandomizer(false, true, false, minLength, maxLength);
	}

	public static CustomerStringRandomizer aNewAlphaNumericRandomizer(int minLength, int maxLength) {
		return new CustomerStringRandomizer(true, true, false, minLength, maxLength);
	}

	public static CustomerStringRandomizer aNewAsciiRandomizer(int minLength, int maxLength) {
		return new CustomerStringRandomizer(false, false, true, minLength, maxLength);
	}

	public static CustomerStringRandomizer aNewCustRandomizer(List<Character> randomList, int minLength,
			int maxLength) {
		return new CustomerStringRandomizer(randomList, minLength, maxLength);
	}

	public static CustomerStringRandomizer aNewCustRandomizer(String randomValue, int minLength, int maxLength) {
		String[] strList = randomValue.split("");
		List<Character> charList = new ArrayList<Character>(strList.length);
		for (String str : strList) {
			charList.add(str.toCharArray()[0]);
		}
		return new CustomerStringRandomizer(charList, minLength, maxLength);
	}

	public CustomerStringRandomizer(boolean isLetter, boolean isNumber, boolean isAscii, int minLength, int maxLength) {
		checkValue(minLength, maxLength);
		this.minLength = minLength;
		this.maxLength = maxLength;
		if (this.minLength == this.maxLength) {
			isFixedLength = true;
		}
		if (isAscii) {
			randomDataSourceList = asciiRandomList;
			return;
		}
		if (isLetter && isNumber) {
			randomDataSourceList = alphaNumericRandomList;
			return;
		}
		if (isLetter) {
			randomDataSourceList = letterRandomList;
			return;
		}
		if (isNumber) {
			randomDataSourceList = numberRandomList;
			return;
		}
	}

	public String getRandomValue() {
		StringBuffer sb = new StringBuffer();
		int randomLen = this.minLength;
		if (!isFixedLength) {
			randomLen = this.random.nextInt(this.maxLength - this.minLength + 1) + this.minLength;
		}
		for (int i = 0; i < randomLen; i++) {
			sb.append(this.randomDataSourceList.get(this.random.nextInt(this.randomDataSourceList.size())));
		}
		return sb.toString();
	}

	private void checkValue(int minLength, int maxLength) {
		if (minLength <= 0 || maxLength <= 0) {
			throw new IllegalArgumentException("value must great than 0");
		}
		if (minLength > maxLength) {
			throw new IllegalArgumentException("max must be greater than min");
		}
	}

}
