package com.marco.fluentbuilders.simple.genericbuilder;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class Person {

    private String name;
    private String lastName;
    private Integer age;
    private Boolean hasPet;

    public Person(){

    }

    public static void main(String[] args) {
        Person person = GenericBuilder.of(Person::new)
                .with(Person::setName, "Name")
                .with(Person::setLastName, "LastName")
                .with(Person::setAge, 5)
                .with(Person::setHasPet, true)
                .build();

        //Has this way any benefit over using the new Person() and setters???

        System.out.println(person);
    }
}
