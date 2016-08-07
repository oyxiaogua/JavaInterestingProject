package com.github.hashids;

import java.util.Arrays;

import org.hashids.Hashids;
import org.junit.Assert;
import org.junit.Test;


public class Test_Hashids {
	@Test
	public void testHashids() {
		String encryKeyStr = "My Password";
		Hashids hashids = new Hashids(encryKeyStr);
		long id=12345;
		String hashIdStr = hashids.encode(id);
		System.out.println(hashIdStr);
		long[] numbers = hashids.decode(hashIdStr);
		Assert.assertEquals(id, numbers[0]);

		// minimum hash length to 8
		hashids = new Hashids(encryKeyStr, 8);
		id=1;
		hashIdStr = hashids.encode(id);
		System.out.println(hashIdStr);
		numbers = hashids.decode(hashIdStr);
		Assert.assertEquals(id, numbers[0]);

		id=1234567L;
		hashids = new Hashids(encryKeyStr, 0, "0123456789abcdef");
		hashIdStr = hashids.encode(id);
		System.out.println(hashIdStr);
		numbers = hashids.decode(hashIdStr);
		Assert.assertEquals(id, numbers[0]);

		hashids = new Hashids(encryKeyStr);
		hashIdStr = hashids.encode(5L, 5L, 5L, 5L);
		System.out.println(hashIdStr);
		numbers = hashids.decode(hashIdStr);
		System.out.println(numbers.length + "," + Arrays.toString(numbers));

		hashids = new Hashids(encryKeyStr);
		hashIdStr = hashids.encode(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
		System.out.println(hashIdStr);
		numbers = hashids.decode(hashIdStr);
		System.out.println(numbers.length + "," + Arrays.toString(numbers));
	}
}
