package HibernateTest;

import Utils.HibernateUtils;
import entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class HibernateQBC {
    @Test
    public void testSelect1(){
        Transaction tx = null;
        try{
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //1.创建Criteria对象
            Criteria criteria= session.createCriteria(Customer.class);
            //2.调用方法得到结果
            List<Customer> customers=criteria.list();
            for(Customer customer :customers){
                System.out.println(customer.getCid()+":"+customer.getCustName());
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
        try{
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //1 创建对象
            Criteria criteria= session.createCriteria(Customer.class);
            //2 使用Criteria对象里面的方法设置条件值
             //首先使用add方法，表示设置条件值
             //在add方法里面使用类的方法实现条件设置
             //类似于cid=1
            criteria.add(Restrictions.eq("cid",1));
            criteria.add(Restrictions.eq("custName","欧亚学院"));
            List<Customer> list = criteria.list();
            for(Customer customer :list){
                System.out.println(customer.getCid()+":"+customer.getCustName());
            }
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }
    @Test
    public void testSelect3(){
        Transaction tx = null;
        try{
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            Criteria criteria= session.createCriteria(Customer.class);
            criteria.add(Restrictions.like("custName","%百%"));
            List<Customer> list = criteria.list();
            for(Customer customer :list){
                System.out.println(customer.getCid()+":"+customer.getCustName());
            }
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }
    @Test
    public void testSelect4(){
        Transaction tx = null;
        try{
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            Criteria criteria= session.createCriteria(Customer.class);
            criteria.addOrder(Order.desc("cid"));
            List<Customer> list = criteria.list();
            for(Customer customer :list){
                System.out.println(customer.getCid()+":"+customer.getCustName());
            }
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }
    @Test
    public void testSelect5(){
        Transaction tx = null;
        try{
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            Criteria criteria= session.createCriteria(Customer.class);
            // 设置分页数据
             //设置开始位置
            criteria.setFirstResult(0);
             //每页显示记录数
            criteria.setMaxResults(1);
            List<Customer> list = criteria.list();
            for(Customer customer :list){
                System.out.println(customer.getCid()+":"+customer.getCustName());
            }
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }
    @Test
    public void testSelect6(){
        Transaction tx = null;
        try{
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            Criteria criteria= session.createCriteria(Customer.class);

            //设置操作
            criteria.setProjection(Projections.rowCount());
            //调用方法得到结果
            Object object= criteria.uniqueResult();
            System.out.println(object);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }

    }
    @Test
    public void testSelect7(){
        Transaction tx = null;
        try{
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //Criteria criteria= session.createCriteria(Customer.class);
            //1 创建对象
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
            // 最终在执行的时候才需要session
            Criteria criteria= detachedCriteria.getExecutableCriteria(session);
            List<Customer> list = criteria.list();
            for (Customer customer : list){
                System.out.println(customer.getCid()+":"+customer.getCustName());
            }
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}
