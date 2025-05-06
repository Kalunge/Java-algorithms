package lambdas.comparotor;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 23, "USA"));
        persons.add(new Person("Carl", 23, "Australia"));
        persons.add(new Person("Amit", 23, "India"));
        persons.add(new Person("Vikram", 23, "Bhutan"));
        persons.add(new Person("Kane", 23, "Brazil"));

        PersonService personService = new PersonService();
        List<Person> sortedPersons = personService.sortPersonsLambda(persons);

        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }
}
