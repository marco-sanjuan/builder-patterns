package com.marco.fluentbuilders.simple.lombok;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@ToString
@Builder(access = AccessLevel.PACKAGE,
		setterPrefix = "with",
		builderMethodName = "create")
public class Person {

	private String name;
	private String lastName;
	private Integer age;
	@Builder.Default
	private Boolean hasPet = false;
	@Singular
	private List<String> phones;
	private final String excludedFromBuilder = "defaultValue";


	private Person(String name, String lastName, Integer age, Boolean hasPet, List<String> phones) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.hasPet = hasPet;
		this.phones = phones;
	}

	public static void main(String[] args) {

		Person person = Person.create()
				.withName("Name")
				.withLastName("LastName")
				.withAge(30)
				.withPhone("phone1")
				.withPhone("phone2")
				.withHasPet(true)
				.build();

		System.out.println(person);
	}
}
