package lambdas.comparotor;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 23, "USA", 15));
        persons.add(new Person("Carl", 23, "Australia", 20));
        persons.add(new Person("Amit", 23, "India", 5));
        persons.add(new Person("Vikram", 23, "Bhutan", 22));

        PersonService personService = new PersonService();
        List<Person> sortedPersons = personService.sortPersonsLambda(persons);

        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }
}
