package com.github.random_beans;

import java.nio.charset.Charset;
import java.time.LocalDate;

import org.junit.Test;

import com.github.bean.Bean_Person;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinition;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;

public class Test_RandomBeans {

	@Test
	public void testRandomBeans_EnhancedRandom_Def() {
		EnhancedRandom enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build();
		Bean_Person person = enhancedRandom.nextObject(Bean_Person.class);
		System.out.println(person);
	}

	@Test
	public void testRandomBeans_EnhancedRandom_Config() {
		FieldDefinition<?, ?> fieldDefinition = FieldDefinitionBuilder.field().named("strArr").ofType(String[].class)
				.get();
		EnhancedRandom enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().maxCollectionSize(3)
				.maxStringLength(5).charset(Charset.forName("UTF-8"))
				.dateRange(LocalDate.now(), LocalDate.now().plusMonths(1)).exclude(fieldDefinition).build();
		Bean_Person person = enhancedRandom.nextObject(Bean_Person.class);
		System.out.println(person);
	}

	@Test
	public void testRandomBeans_EnhancedRandom_Config2() {
		FieldDefinition<?, ?> strArrFieldDefinition = FieldDefinitionBuilder.field().named("strArr")
				.ofType(String[].class).get();
		EnhancedRandom enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
				.randomize(String.class, CustomerStringRandomizer.aNewAlphaNumericRandomizer(4, 6)).maxCollectionSize(3)
				.dateRange(LocalDate.now(), LocalDate.now().plusMonths(1)).exclude(strArrFieldDefinition).build();
		Bean_Person person = enhancedRandom.nextObject(Bean_Person.class);
		System.out.println(person);
	}
}
