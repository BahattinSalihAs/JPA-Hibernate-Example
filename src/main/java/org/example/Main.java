package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entities.Employee;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String puName = "pu-name";
        Map<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","update");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            /*
            Employee e = new Employee(3,"Chinlui", "Xyang","abxyang@gmial.com");
            em.merge(e); //add this to the context
             */
            /*
            Employee e1 = em.find(Employee.class,1);
            e1.setFirst_name("AhmediNejad"); // bu 1.yol güncellemenin
            System.out.println(e1);

            Employee e2 = new Employee();
            e2.setId(6);
            e2.setFirst_name("Mathew");
            e2.setLast_name("Tracking");
            em.merge(e2); // Bu da 2.yolu güncellemenin

            Employee e3 = new Employee();
            e3.setId(5);
            em.merge(e3);

             */

            Employee e1 = em.getReference(Employee.class,1);
            //em.persist(e1);

            /*
            Employee e2 = new Employee();
            e2.setId(2);
            e2.setFirst_name("Ahmedi");
            e2.setLast_name("Nejad");
            e2.setEmail("an.com");
            //em.persist(e2);

            System.out.println(e1);
            e1.setLast_name("Poison");
            System.out.println(e1);
            em.refresh(e1);
            System.out.println(e1);

             */

            Employee e3 = new Employee();
            e3.setFirst_name("Nazım");
            e3.setLast_name("Karabekir");
            e3.setEmail("krb@.com");
            em.persist(e3);

            Employee e4 = new Employee();
            e4.setFirst_name("Kreteus");
            e4.setLast_name("Nikılsın");

            em.persist(e4);


            em.getTransaction().commit();
        }finally {
            em.close();
        }



    }
}