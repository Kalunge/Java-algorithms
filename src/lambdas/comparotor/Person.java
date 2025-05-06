package lambdas.comparotor;

public class Person {

    private String name;
    private int age;
    private String country;
    private int yearOfService;

    public Person(String name, int age, String country, int yearOfService) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.yearOfService = yearOfService;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public int getYearOfService() {
        return yearOfService;
    }
}
