package lambdas.comparotor;

import java.util.function.*;

public class ConsumerDemo {


    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("Titus Muthomi");

        Consumer<Integer> consumerInt = num -> System.out.println("Integer value is: " + num);
        consumerInt.accept(55);

        // chaining consumers

        Consumer<String> consumer1 = arg -> System.out.println(arg + " My name is Titus Muthomi");
        Consumer<String> consumer2 = arg -> System.out.println(arg + "  I am from Nairobi Kenya");

        consumer1.andThen(consumer2).accept("Hello");

        // Bi consumer
        BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + s2);
        biConsumer.accept("Hello", "There");
    }
}
