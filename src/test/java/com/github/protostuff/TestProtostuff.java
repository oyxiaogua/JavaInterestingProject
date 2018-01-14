package com.github.protostuff;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public class TestProtostuff {

	@Test
	public void testProtostuffSerialization() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("msg", "test测试");
		Schema<HashMap> schema = RuntimeSchema.getSchema(HashMap.class);
		LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
		byte[] protostuff = ProtostuffIOUtil.toByteArray(map, schema, buffer);
		HashMap<String, String> resultMap = new HashMap<>();
		Schema<HashMap> schema2 = RuntimeSchema.getSchema(HashMap.class);
		ProtostuffIOUtil.mergeFrom(protostuff, resultMap, schema2);
		Assert.assertNull(resultMap.get("msg"));
	}

}
