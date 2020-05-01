package com.marco.fluentbuilders.simple.functional;

import lombok.ToString;

import java.util.function.Consumer;

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

    public static PersonBuilder create() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private String name;
        private String lastName;
        private Integer age;
        private Boolean hasPet;

        public Person with(Consumer<PersonBuilder> builderFunction) {
            builderFunction.accept(this);
            return new Person(name, lastName, age, hasPet);
        }
    }


    public static void main(String[] args) {
        Person person = Person.create()
                .with($ -> {
                    $.name = "name";
                    $.lastName = "lastName";
                    $.age = 30;
                    $.hasPet = true;
                });

        System.out.println(person);
    }
}
