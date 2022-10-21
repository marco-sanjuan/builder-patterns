package com.marco.fluentbuilders.simple.classic;

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

        private String name;
        private String lastName;
        private Integer age;
        private Boolean hasPet;

        private PersonBuilder() { }

        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public PersonBuilder hasPet(Boolean hasPet) {
            this.hasPet = hasPet;
            return this;
        }

        public Person build() {
            return new Person(name, lastName, age, hasPet);
        }
    }


    public static void main(String[] args) {
        Person person = Person.create()
                .withName("Markus")
                .withLastName("Smith")
                .withAge(20)
                .hasPet(true)
                .build();
        System.out.println(person);
    }
}
