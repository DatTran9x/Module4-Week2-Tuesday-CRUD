package main.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp = "^[A-Z]\\w{4,19}",message = "Name must be from 5 to 20 characters long. First letter must be upper case.")
    private String name;
    @Min(value = 18,message = "Age must be from 18 to 60")
    @Max(value = 60,message = "Age must be from 18 to 60")
    private int age;
    private double salary;

    @ManyToOne
    private Branch branch;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary, Branch branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
