package lambdas.comparotor;

import java.util.function.*;

public class SupplierDemo {

    static boolean isPersonEligibleForVoting(Supplier<Person> supplier, Predicate<Person> predicate) {
        return predicate.test(supplier.get());
    }

    public static void main(String[] args) {
        Supplier<Person> supplier = () -> new Person("Eric", 11, "Kenya", 20);
        Predicate<Person> predicate = p -> p.getAge() >= 18;

        boolean isEligible = isPersonEligibleForVoting(supplier, predicate);
        System.out.println("Person is eligible for voting: " + isEligible);

        // get as int
        IntSupplier intSupplier = () -> (int) (Math.random() * 10);
        System.out.println(intSupplier.getAsInt());

        // get as double
        DoubleSupplier doubleSupplier = () -> (int) (Math.random() * 10);
        System.out.println(doubleSupplier.getAsDouble());
    }
}
