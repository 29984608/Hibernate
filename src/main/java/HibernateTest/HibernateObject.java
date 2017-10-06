package HibernateTest;

import Utils.HibernateUtils;
import entity.Customer;
import entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

public class HibernateObject {
    @Test
    public void testSelect1(){
        Transaction tx = null;
        try{
            Session session = HibernateUtils.getSessionObject();
            tx= session.beginTransaction();
            //根据cid=1客户，再查询这个客户里面所有联系人
             Customer customer= session.get(Customer.class,1);
            //在查询这个客户里面所有联系人
            //直接得到客户里面联系人的set集合
            Set<LinkMan> linkman = customer.getSetlinkMan();
            System.out.println(linkman.size());
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }
}
