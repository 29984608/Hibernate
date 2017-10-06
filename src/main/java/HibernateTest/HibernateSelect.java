package HibernateTest;

import Utils.HibernateUtils;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateSelect {
    @Test
    public void testCasch(){
        //调用工具类得到sessionFactory
     //  SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
       //获取session
     //   Session session = sessionFactory.openSession();
        //开启事务
  //      Transaction tx = session.beginTransaction();
/*        //根据id=3查询
         User user = session.get(User.class,1);
        System.out.println(user);
        // 在根据id = 3查询
         User user1= session.get(User.class,1);
        System.out.println(user1);*/
        //持久态自动更新
      //    User user= session.get(User.class,1);
      //    user.setName("小王");
      //    user.setPassword("123456");

         // session.update(user);

        //提交事务
       // tx.commit();
        //关闭
      //  session.close();
      //  sessionFactory.close();

    }
}
