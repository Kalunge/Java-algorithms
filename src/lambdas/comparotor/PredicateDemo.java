package lambdas.comparotor;

import java.util.function.*;

public class PredicateDemo {

    static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    public static void main(String[] args) {
        Person person = new Person("Titoh", 11, "Kenya");

        Predicate<Person> predicate = p -> p.getAge() >= 18;

        System.out.println(isPersonEligibleForVoting(person, predicate));
    }
}
