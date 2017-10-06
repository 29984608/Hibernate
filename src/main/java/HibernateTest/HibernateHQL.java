package HibernateTest;

import Utils.HibernateUtils;
import entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

public class HibernateHQL {
    @Test
    public void testSelect1(){
        Transaction tx =null;
        try{
            Session session= HibernateUtils.getSessionObject();
            tx= session.beginTransaction();
            //1 创建Query对象
            Query query= session.createQuery("from entity.Customer");
            //2 调用方法得到结果
            List<Customer> list= query.list();
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
    public void testSelect2(){
        Transaction tx =null;
        try{
            Session session= HibernateUtils.getSessionObject();
            tx= session.beginTransaction();
            //1创建query对象
            Query query= session.createQuery("from entity.Customer customer where customer.cid = ? and customer.custName=?");
            //2 设置条件值 向？里面设置值
            //setParameter
            // 第一个参数：int类型是？位置，？位置从0开始
            //第二个参数是具体值
            //设置第一个？值
            query.setParameter(0,2);
            //设置第二个？值
            query.setParameter(1,"百度");
            //3 调用方法得到结果
            List<Customer> list = query.list();
            for (Customer customer:list){
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
        Transaction tx =null;
        try{
            Session session= HibernateUtils.getSessionObject();
            tx= session.beginTransaction();

            Query query= session.createQuery("from entity.Customer customer where customer.custName like ?");
            query.setParameter(0,"%百%");
            List<Customer> list = query.list();
            for (Customer customer:list){
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
        Transaction tx =null;
        try{
            Session session= HibernateUtils.getSessionObject();
            tx= session.beginTransaction();
           Query query= session.createQuery("from entity.Customer customer order by customer.cid desc");
            List <Customer> list= query.list();
            for (Customer customer : list){
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
        Transaction tx =null;
        try{
            Session session= HibernateUtils.getSessionObject();
            tx= session.beginTransaction();
            //1 创建对象
           Query query= session.createQuery("from entity.Customer");
           //2 设置分页数据
            //2.1 设置开始位置
            query.setFirstResult(0);
            //2.2 设置每页记录数
            query.setMaxResults(1);

            //3 调用方法得到结果
             List<Customer> list= query.list();

             for (Customer customer :list){
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
        Transaction tx =null;
        try{
            Session session= HibernateUtils.getSessionObject();
            tx= session.beginTransaction();
            //1 创建对象
            Query query= session.createQuery("select custName from entity.Customer ");

            List<Object> list= query.list();

            for (Object object :list){
                System.out.println(object);
            }

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void testSelect7(){
        Transaction tx =null;
        try{
            Session session= HibernateUtils.getSessionObject();
            tx= session.beginTransaction();
            Query query=session.createQuery("select count(*) from entity.Customer");
            Object object=query.uniqueResult();
            

            System.out.println(object);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}
