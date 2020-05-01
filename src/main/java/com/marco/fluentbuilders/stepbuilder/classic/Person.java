package com.marco.fluentbuilders.stepbuilder.classic;

import lombok.ToString;

@ToString
public class Person {

    private String name;
    private String lastName;
    private Integer age;
    private Boolean hasPet;

    private Person(String name, String lastName, Integer age, Boolean hasPet) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.hasPet = hasPet;
    }

    public static StepName create() {
        return new PersonBuilder();
    }

    public static class PersonBuilder implements StepName, StepLastName, StepAge, StepHasPet, StepBuild {

        private String name;
        private String lastName;
        private Integer age;
        private Boolean hasPet;

        private PersonBuilder() { }

        @Override
        public StepLastName withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public StepAge withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public StepHasPet withAge(Integer age) {
            this.age = age;
            return this;
        }

        @Override
        public StepBuild hasPet(Boolean hasPet) {
            this.hasPet = hasPet;
            return this;
        }

        @Override
        public Person build() {
            return new Person(name, lastName, age, hasPet);
        }
    }

    public interface StepName {
        StepLastName withName(String name);
    }
    public interface StepLastName {
        StepAge withLastName(String lastName);
    }
    public interface StepAge {
        StepHasPet withAge(Integer age);
    }
    public interface StepHasPet {
        StepBuild hasPet(Boolean hasPet);
    }
    public interface StepBuild {
        Person build();
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
