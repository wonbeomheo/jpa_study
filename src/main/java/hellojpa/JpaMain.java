package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    try {
      // 영속
      Member findMember1 = em.find(Member.class, 101L);
      Member findMember2 = em.find(Member.class, 101L);
  
      System.out.println("findMember.id = " + findMember1.getId());
      System.out.println("findMember.name = " + findMember1.getName());
  
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
