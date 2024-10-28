package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Employee;
import org.example.entity.Product;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MPU");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Employee employee3 = new Employee("Maciek", "Stryszawa 45g");
            Product product = new Product("aaa", "bbb", 1222);
            entityManager.persist(employee3);
            entityManager.persist(product);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
