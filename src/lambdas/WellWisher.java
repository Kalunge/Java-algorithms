package lambdas;

public class WellWisher {
    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String[] args) {
//        Greeting hindiGreeting = new HindiGreeting();
//        wish(hindiGreeting);

        // Anonymous class
        wish(new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello there");
            }
        });

//        Greeting englishGreeting = new EnglishGreeting();
//        wish(englishGreeting);

        // Anonymous class
        wish(new Greeting() {
            @Override
            public void greet() {
                System.out.println("Good Morning");
            }
        });

        wish(() -> System.out.println("Namastes"));
    }
}
