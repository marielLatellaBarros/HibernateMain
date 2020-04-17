package be.pxl.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.print.attribute.standard.MediaSize;

public class HibernateMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("course");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(new Message("Hello Virus"));
        tx.commit();

        Message lookup = em.find(Message.class, 1L);
        System.out.println(lookup);

        Message msg = new Message();
        msg.setText("Hello World.");
        em.persist(msg);

        System.out.println(em.find(Message.class, 2L));

        em.close();
        emf.close();


    }
}
