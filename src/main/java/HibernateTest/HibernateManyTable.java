package HibernateTest;

import Utils.HibernateUtils;
import entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

public class HibernateManyTable {
    @Test
    public void testSelect1(){
        Transaction tx = null;
        try {
            Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            Query query = session.createQuery("from entity.Customer c inner join c.setlinkMan");
            List list= query.list();
            for (Object object:list){
                System.out.println(object.toString());
            }
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void testSelect2(){
        Transaction tx = null;
        try {
            Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            Query query = session.createQuery("from entity.Customer c inner join fetch c.setlinkMan");
            List list = query.list();

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}
