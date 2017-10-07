package HibernateTest;

import Utils.HibernateUtils;
import entity.Customer;
import entity.LinkMan;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.Set;

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
    @Test
    public void testSelect3(){
        Transaction tx = null;
        try {
            Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //根据cid=1客户
            //执行get方法之后，是否发送sql语句
            //调用get方法马上发送sql语句查询数据库
            Customer customer = session.get(Customer.class,1);
            System.out.println(customer.getCid());
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void testSelect4(){
        Transaction tx = null;
        try {
            Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            /*
            * 1 调用load方法之后，不会马上发送sql语句
            *   返回对象里面只有id值
            * 2 得到对象里面不是id的而是其他值时候才会发送语句
            * */
            Customer customer = session.load(Customer.class,1);
            System.out.println(customer.getCid());
            System.out.println(customer.getCustName());
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void testSelect5(){
        Transaction tx = null;
        try {
            Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //根据cid=1客户，再查询这个客户里面所有联系人
            Customer customer = session.load(Customer.class,1);
            //再查询这个客户里面所有联系人
                //直接得到客户里面联系人的set集合
            //得到set集合，没有发送语句
            Set<LinkMan> linkMEN = customer.getSetlinkMan();
            //发送语句
            System.out.println(linkMEN.size());
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }
    @Test
    public void testSelect6(){
        Transaction tx = null;
        try {
            Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //查询客户
            Criteria criteria= session.createCriteria(Customer.class);
            List<Customer> list = criteria.list();
            //得到每个客户里面所有联系人
            for(Customer customer:list){
                System.out.println(customer.getCid()+":"+customer.getCustName());
                //每个客户里面的联系人
                Set<LinkMan> linkMEN= customer.getSetlinkMan();
                for (LinkMan linkMan:linkMEN){
                    System.out.println(linkMan.getLkm_id()+":"+linkMan.getLkm_name());
                }
            }
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }
}
