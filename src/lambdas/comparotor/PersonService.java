package lambdas.comparotor;

import java.util.*;

public class PersonService {

    static List<Person> sortPersons(List<Person> persons) {
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        return persons;
    }

    static List<Person> sortPersonsLambda(List<Person> persons) {
//        Collections.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        Collections.sort(persons, Comparator.comparing(Person::getName));
        return persons;
    }


}
