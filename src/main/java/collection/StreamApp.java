package collection;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamApp {
    public static void main(String[] args) {
        List<Employee> people = Arrays.asList(
                new Employee("3", 3, 3, new Department("C")),
                new Employee("1", 1, 1, new Department("A")),
                new Employee("6", 6, 6, new Department("A")),
                new Employee("5", 5, 5, new Department("A")),
                new Employee("4", 4, 4, new Department("A")),
                new Employee("2", 2, 2, new Department("B")));

        Stream<String> stringStream = people.stream().map(Employee::getName);
        List<String> stringList = people.stream().map(Employee::getName).collect(toList());
        Set<String> stringSet = people.stream().map(Employee::getName).collect(toSet());
        ConcurrentSkipListSet<String> stringConcurrentSkipListSet = people.stream().map(Employee::getName).collect(toCollection(ConcurrentSkipListSet::new));
        String s = people.stream().map(Employee::getName).collect(joining());
        Integer integer = people.stream().collect(summingInt(Employee::getSalary));
        //Group employees by department
        Map<Department, List<Employee>> departmentListMap = people.stream().collect(groupingBy(Employee::getDepartment));
        // Compute sum of salaries by department
        Map<Department, Integer> departmentIntegerMap = people.stream().collect(groupingBy(Employee::getDepartment, summingInt(Employee::getSalary)));
        // Partition students into passing and failing
        Map<Boolean, List<Employee>> booleanListMap = people.stream().collect(partitioningBy(e -> e.getSalary() > 2));
        Map<Department, Set<String>> departmentSetMap = people.stream().collect(groupingBy(Employee::getDepartment, mapping(Employee::getName, toSet())));
        List<Employee> employeeList = people.stream().collect(collectingAndThen(toList(), Collections::unmodifiableList));
        Long collect = people.stream().collect(counting());
        Optional<Employee> optionalEmployee = people.stream().collect(minBy((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary())));
        Optional<Employee> min = people.stream().min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary()));
        Optional<Employee> optionalEmployee1 = people.stream().collect(minBy(Comparator.comparingInt(Employee::getSalary)));
        Optional<Employee> optionalEmployee2 = people.stream().collect(maxBy(Comparator.comparingInt(Employee::getSalary)));
        Integer reduce = people.stream().reduce(0, (e1, e2) -> e1 + e2.getSalary(), Integer::sum);
        Optional<Integer> reduce1 = people.stream().map(Employee::getSalary).reduce(Integer::sum);

        //to calculate the longest last name of employee in each department:
        Comparator<String> byLength = Comparator.comparing(String::length);
        /*people.stream().collect(
        groupingBy(Employee::getDepartment,
                reducing(
                        Employee::getName,
                        BinaryOperator.maxBy(byLength)
                )));*/
        ConcurrentMap<Department, List<Employee>> collect1 = people.stream().collect(groupingByConcurrent(Employee::getDepartment));
        ConcurrentMap<Department, Set<String>> departmentSetConcurrentMap = people.stream().collect(groupingByConcurrent(Employee::getDepartment, mapping(Employee::getName, toSet())));
        ConcurrentMap<Department, Set<Employee>> departmentSetConcurrentMap1 = people.stream().collect(groupingByConcurrent(Employee::getDepartment, toSet()));
        ConcurrentMap<Department, ConcurrentSkipListSet<String>> collect2 = people.stream().collect(
                groupingByConcurrent(Employee::getDepartment,
                        mapping(Employee::getName, toCollection(ConcurrentSkipListSet::new)
                        )));
        ConcurrentMap<Department, ConcurrentSkipListSet<Employee>> collect3 = people.stream().collect(groupingByConcurrent(
                Employee::getDepartment,
                toCollection(() -> new ConcurrentSkipListSet<>(Comparator.comparing(Employee::getId)))
        ));

        Map<Department, Employee> collect4 = people.stream().collect(toMap(
                Employee::getDepartment,
                Function.identity(),
                (e1, e2) -> e1
        ));


        ConcurrentMap<Department, String> departmentStringConcurrentMap = people.stream().collect(toConcurrentMap(Employee::getDepartment,
                Employee::getName,
                (s1, a) -> s1 + ", " + a));

        System.out.println(departmentStringConcurrentMap);
    }

    private static class Employee {

        public String getName() {
            return name;
        }

        private String name;
        private int salary;
        private int id;

        public Department getDepartment() {
            return department;
        }

        private Department department;

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", id=" + id +
                    ", department=" + department +
                    '}';
        }

        public Employee(String name, int id, int salary, Department department) {
            this.name = name;
            this.id = id;
            this.salary = salary;
            this.department = department;
        }

        public int getId() {
            return id;
        }
    }

    private static class Department {
        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Department that = (Department) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    '}';
        }

        String name;

        public Department(String name) {
            this.name = name;
        }
    }
}
