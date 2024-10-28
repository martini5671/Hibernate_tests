package org.example.entity;

import jakarta.persistence.*;
import org.example.generators.CustomGenerator;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee") // this name will be used in queries
public class Employee {

    // id is mandatory
    // it has to exist
    // wither pk from one column or composed PK from many columns

    // 4 types of generation strategies:
    // identity = AUTO_INCREMENT we dont need to specify id, its going to be taken from db
    // TABLE = this will create table if ids in the db for hiberante
    // this strat is not optimal in terms of performance but will work
    // with every database which doesnt support IDENTITY
    // UUID = could be string which is uniqe identifier / not the best performance
    // numbers have limited spectrum meanwhile UUID has almost infinite id spectrum
    // good if some frontend uses this e.g as an endpoint

    @Id
    @GeneratedValue(generator = "custom-uuid-generator")
    @GenericGenerator(name = "custom-uuid-generator", type = CustomGenerator.class)
    @Column(name = "id", nullable = false) //thats how you specify name of column and other props
    private int id;

    @Column
    private String name;

    @Column
    private String address;

    public Employee() {
    }

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
