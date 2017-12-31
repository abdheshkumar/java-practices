package java7examples;

import java.math.BigDecimal;

/**
 * Created by abdhesh on 21/07/17.
 */
public class Developer {
    private String name;
    private BigDecimal salary;
    private int age;

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public Developer(String name, BigDecimal salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String toString() {
        return "Developer [name=" + name + ", salary=" + salary + ", age=" + age + "]";
    }
}
