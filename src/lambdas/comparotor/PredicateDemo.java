package lambdas.comparotor;

import java.util.function.*;

public class PredicateDemo {

    static boolean isPersonEligibleForVoting(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    static boolean isPersonEligibleForMembership(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    static boolean isPersonEligibleForRetirement(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    static boolean isNumberGreaterThanTen(int number, Predicate<Integer> predicate) {
        return predicate.negate().test(number);
    }

    static boolean isPersonEligibleForVoting(Person person, int minAge, BiPredicate<Person, Integer> predicate) {
        return predicate.test(person, minAge);
    }

    public static void main(String[] args) {
        Person person = new Person("Titoh", 61, "Kenya", 32);

        Predicate<Person> predicate = p -> p.getAge() >= 18;

        System.out.println("is eligile for voting " + isPersonEligibleForVoting(person, predicate));

        // eligible for membership greater than 18 but les than sixty

        Predicate<Person> greaterThanEighteen = p -> p.getAge() > 18;
        Predicate<Person> lessThanSixty = p -> p.getAge() < 60;

        Predicate<Person> membershipPredicate = greaterThanEighteen.and(lessThanSixty);

        boolean eligible = isPersonEligibleForMembership(person, membershipPredicate);
        System.out.println("Eligible for club membership: " + eligible);

        // retirement test

        Predicate<Person> aboveRetirementAge = p -> p.getAge() > 60;
        Predicate<Person> attainedYearsOfService = p -> p.getYearOfService() >= 30;
        Predicate<Person> retirementPredicate = aboveRetirementAge.or(attainedYearsOfService);

        boolean retirementEligible = isPersonEligibleForRetirement(person, retirementPredicate);
        System.out.println("Is eligible for retirement: " + retirementEligible);

        Predicate<Integer> intPredicateNegate = num -> num > 10;

        boolean isLessThanTen = isNumberGreaterThanTen(5, intPredicateNegate);

        System.out.println("Is Number Less Than ten: " + isLessThanTen);

        Predicate predicate1 = Predicate.isEqual("Welcome");

        boolean isEqual = predicate1.test("Welcome");
        boolean isNotEqual = predicate1.test("Hello");
        System.out.println("Welcome is equal to WELCOME: " + isEqual);
        System.out.println("Welcome is not equal to Hello: " + isNotEqual);


        boolean biPredicat = isPersonEligibleForVoting(person, 70, (p, age) -> p.getAge() > age);
        System.out.println("Bipredicate: "  + biPredicat);
    }
}
