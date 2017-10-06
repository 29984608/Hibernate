package HibernateTest;

import Utils.HibernateUtils;
import entity.Customer;
import entity.LinkMan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateOnetoMany {
    //演示一对多级联保存
    @Test
    public void testAddDemo1(){
        Transaction tx = null;
        try{
          Session session =  HibernateUtils.getSessionObject();
          tx= session.beginTransaction();
            //添加一个客户，为这个客户添加一个联系人
            //1 创建客户和联系人对象
            Customer customer = new Customer();
            customer.setCustName("欧亚学院");
            customer.setCustLevel("VIP");
            customer.setCustSource("软工");
            customer.setCustPhone("13692127465");
            customer.setCustMobile("029864564");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("杨某人");
            linkMan.setLkm_gender("男");
            linkMan.setLkm_phone("13038483381");
            //2 在客户表示联系人，在联系人表示客户，建立客户对象和联系人对象关系
            //2.1 把联系人对象放到客户对象的set集合里面
            customer.getSetlinkMan().add(linkMan);
            //2.2 把客户对象放到联系人里面去
            linkMan.setCustomer(customer);
            //3 保存到数据库
            session.save(customer);
            session.save(linkMan);
          tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void testAddDemo2(){
        Transaction tx = null;
        try{
           Session session= HibernateUtils.getSessionObject();
           tx = session.beginTransaction();
            //1 创建客户和联系人对象
            Customer customer = new Customer();
            customer.setCustName("百度");
            customer.setCustLevel("普通用户");
            customer.setCustSource("网络");
            customer.setCustPhone("13612227465");
            customer.setCustMobile("021864564");

            LinkMan linkMan = new LinkMan();
            linkMan.setLkm_name("陈某人");
            linkMan.setLkm_gender("女");
            linkMan.setLkm_phone("130315245456");
            //2 把联系人放到客户里面
            customer.getSetlinkMan().add(linkMan);
            //3 保存
            session.save(customer);
           tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void testDelDemo3(){
        Transaction tx = null;
        try{
             Session session= HibernateUtils.getSessionObject();
             tx = session.beginTransaction();
            Customer customer= session.get(Customer.class,1);
            session.delete(customer);
             tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void testUpdateDemo4(){
        Transaction tx = null;
        try {
           Session session = HibernateUtils.getSessionObject();
           tx = session.beginTransaction();
            //1 根据id查询陈某人，根据id查百度的客户
            Customer eurasia= session.get(Customer.class,1);
           LinkMan chen = session.get(LinkMan.class,2);
           //2 设置持久态对象
            //把联系人放到客户里面
            eurasia.getSetlinkMan().add(chen);
            //把客户放到联系人里面
            chen.setCustomer(eurasia);

           tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}
