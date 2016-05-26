/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.alfonsodomenici.lezionejpacrud;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        List<Customer> result = em.createQuery("select e from Customer e order by e.lastName", Customer.class).getResultList();
        result.stream().forEach((customer) -> {
            System.out.println(customer);
        });

        /*
        em.getTransaction().begin();
        Customer c = new Customer(null, "mario", "rossi", "123456789", "mario@hotmail.com", "ivrea", "it", new Date());
        em.persist(c);
        em.getTransaction().commit();
         
        Customer finded = em.find(Customer.class, 12);
        em.getTransaction().begin();
        em.remove(finded);
        em.getTransaction().commit();
         */
        
        em.createQuery("select e from Customer e order by e.lastName", Customer.class).getResultList()
                .stream().forEach((customer) -> {
                    System.out.println(customer);
                });

    }
}
