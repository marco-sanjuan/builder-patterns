package com.marco.fluentbuilders.stepbuilder.functional;

import lombok.ToString;

@ToString
public class Person {

	private final String name;
	private final String lastName;
	private final Integer age;
	private final Boolean hasPet;

	private Person(String name, String lastName, Integer age, Boolean hasPet) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.hasPet = hasPet;
	}

	public static PersonBuilder create() {
		return new PersonBuilder();
	}

	public static class PersonBuilder {

		private PersonBuilder() { }

		public StepLastName withName(String firstName) {
			return lastName -> age -> hasPet ->
				new Person(firstName, lastName, age, hasPet);
		}

		public interface StepLastName {
			StepAge withLastName(String secretWord);
		}
		public interface StepAge {
			StepHasPet withAge(Integer age);
		}
		public interface StepHasPet {
			Person hasPet(Boolean hasPet);
		}

	}


	public static void main(String[] args) {
		Person person = Person.create()
				.withName("Markus")
				.withLastName("Smith")
				.withAge(20)
				.hasPet(true);

		System.out.println(person);
	}

}
