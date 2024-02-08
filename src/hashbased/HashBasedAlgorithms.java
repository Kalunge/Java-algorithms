package hashbased;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class HashBasedAlgorithms {


    public static void main(String[] args) {
        Employee employee = new Employee("Robby", 3827,
                "Technology");
        Employee employee2 = new Employee("Bobby", 9612,
                "Marketing");
        Employee employee3 = new Employee("Sally", 2519,
                "Sales");


        HashMap<Integer, Employee> employeesById = new HashMap<>();

        employeesById.put(employee.id, employee);
        employeesById.put(employee2.id, employee2);
        employeesById.put(employee3.id, employee3);

        Employee retrieved = employeesById.get(9612);

        if (retrieved != null) {
            System.out.println(retrieved.name + " ---> " + retrieved.department);
        }

        HashSet<String> prodCodes = new HashSet<>();

        prodCodes.add("2T26B");

        System.out.println(prodCodes.contains("2T26B"));
        System.out.println(prodCodes.contains("226B"));

    }
}
