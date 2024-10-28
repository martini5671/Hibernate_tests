package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Passport;
import org.example.entity.Person;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MPU");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Person person = new Person();
            person.setName("Marcin");
            person.setSurname("Koczot");

            Passport passport = new Passport();
            passport.setNumber("aaa1");

            // add passports to the people
            person.setPassport(passport);

            // add to context you have to persist both
            // but the order doesnt matter (because its not insert to db yet)
            entityManager.persist(person);

            // it is also possible to do this without explicitly persisting both
            // with cascading

            entityManager.getTransaction().commit(); // thats where queries happen
            // or also in flush()
        } finally {
            entityManager.close();
        }
    }
}
