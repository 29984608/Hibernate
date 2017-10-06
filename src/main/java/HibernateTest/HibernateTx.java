package HibernateTest;

import Utils.HibernateUtils;
        import entity.User;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.Transaction;
        import org.junit.Test;

public class HibernateTx {
    @Test
    public void Tx(){
        Session session = null;
        Transaction tx = null;
        try{
            //与本地线程绑定的session
            session = HibernateUtils.getSessionObject();
            tx= session.beginTransaction();
            User user = new User();
            user.setName("小伟");
            user.setPassword("789456");
            session.save(user);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            session.close();
            //sessionFactory.close();
        }

    }
}
