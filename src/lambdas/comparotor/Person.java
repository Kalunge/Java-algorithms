package lambdas.comparotor;

public class Person {

    private String name;
    private int age;
    private String country;
    private int yearOfService;

    Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYearOfService(int yearOfService) {
        this.yearOfService = yearOfService;
    }
}
