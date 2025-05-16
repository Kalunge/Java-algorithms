package lambdas.comparotor;

import java.util.function.*;

public class FunctionalInterfaceDemo {

    static int j = 0;

    public static void main(String[] args) {
        Function<String, Integer> strLength = str -> str.length();
        System.out.println("Length of string is " + strLength.apply("Hello there"));


        Function<Integer, Integer> increment = x -> x + 10;
        Function<Integer, Integer> multiply = x -> x * 5;

        System.out.println("Compose result: " + multiply.compose(increment).apply(5)); // 75
        System.out.println("and then result: " + increment.andThen(multiply).apply(5)); // 75

        //BiFunction<Integer, Integer, Integer> add = (a, b) -> Integer.sum(a, b);
        BiFunction<Integer, Integer, Integer> add = Integer::sum;

        System.out.println("Bi function reult: " + add.apply(5, 6)); // 11

        Person person = new Person();
        UnaryOperator<Person> unaryOperator = (p) -> {
            p.setAge(15);
            p.setName("Muthomi");
            return p;
        };

        unaryOperator.apply(person);
        System.out.println(person.getAge());


        IntUnaryOperator intUnaryOperator = num -> num * num;
        System.out.println(intUnaryOperator.applyAsInt(25));

        Person person1 = new Person("Mwikali", 30);
        Person person2 = new Person("Nduta", 7);

        BinaryOperator<Person> binaryOperator = (p1, p2) -> {
            p1.setName(p2.getName());
            p1.setAge(p2.getAge());

            return p1;
        };

        binaryOperator.apply(person1, person2);
        System.out.println("Person 1 name: " + person1.getName()); // Nduta

        int i = 5;

        // i = 7; //  Variable used in lambda expression should be final or effectively final

        j = 7;


        UnaryOperator<Integer> unaryOperator1 = num -> num * i;
        UnaryOperator<Integer> unaryOperator2 = num -> num * j;

        System.out.println(unaryOperator1.apply(i));
        System.out.println(unaryOperator2.apply(j));

        Function<Integer, Integer> multiplier = getMultilier();
        System.out.println(multiplier.apply(10));;

    }

    public static Function<Integer, Integer> getMultilier() {
        int i = 11;

        Function<Integer, Integer> multiplier = t -> t * i;

        //i = 15; // Variable used in lambda expression should be final or effectively final
        // were it to be changed lambda would have a copy of an old variable 11 and not the value 15 as desired

        return multiplier;
    }

}
