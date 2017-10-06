package HibernateTest;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by pc on 2017/9/22.
 */
public class HibernateDemo {
    @Test
    public void testAdd(){
        /*1 加载hibernate核心配置文件
        * 在src下面找到hibernate.cfg.xml
        * 到hibernate里面封装对象*/
        Configuration cfg = new Configuration();
        cfg.configure();
        /*2 创建SessionFactory对象
        读取hibernate核心配置内容，创建sessionFactory
        在过程中，根据映射关系，在配置数据库里面把表创建*/
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        /*3 使用SessionFactory创建session对象
        * 类似与链接
        * */
       // Session session = sessionFactory.openSession();
        /*4 开启事务*/
        //Transaction tx = session.beginTransaction();
        /*5 写具体逻辑crud操作
        * 5.1添加功能
        *
       User user = new User();
        user.setName("小明");
        user.setPassword("555555");
        session.saveOrUpdate(user);*/
        //调用session的方法实现添加
       // session.save(user);
        /*5.2根据id查询
        * 第一个参数：实体类的class
        * 第二个参数：id值
         User user=session.get(User.class,3);
        //user.setId(3);
       // user.setName("小小");
       // user.setPassword("456655");
     //   session.saveOrUpdate(user);

        System.out.println(user);*/
        /*5.3修改
        * - 先根据id查在改
        * - 向返回的user对象里面设置修改之后的值
         User user= session.get(User.class,1);
         user.setName("小王");
         user.setPassword("123456");
         session.update(user);*/
        /*5.4删除
        * - 方法一
        User user=session.get(User.class,1);
        session.delete(user);
        - 方法二
        User user = new User();
        user.setId(3);
        //user.setName("小红");
        //user.setPassword("789456");
        //session.saveOrUpdate(user);
        session.delete(user);*/

        /*6 提交事务*/
       // tx.commit();
 //       tx.rollback();
        /*7 关闭资源*/
       // session.close();
        sessionFactory.close();
    }
}
