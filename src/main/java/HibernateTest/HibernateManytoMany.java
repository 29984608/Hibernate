package HibernateTest;

import Utils.HibernateUtils;
import entity.Role;
import entity.UserDemo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateManytoMany {
    @Test
    public void testSave(){
        Transaction tx = null;
        try{
           Session session= HibernateUtils.getSessionObject();
           tx = session.beginTransaction();
           //添加两个用户，为每个用户添加两个角色
           //1 创建对象
            UserDemo userDemo =new UserDemo();
            userDemo.setUser_name("lucy");
            userDemo.setUser_password("123");
            UserDemo userDemo1 =new UserDemo();
            userDemo1.setUser_name("mary");
            userDemo1.setUser_password("1234");
            Role role = new Role();
            role.setRole_name("总经理");
            role.setRole_memo("总经理");
            Role role1 = new Role();
            role1.setRole_name("秘书");
            role.setRole_memo("秘书");
            Role role2 = new Role();
            role2.setRole_name("程序员");
            role2.setRole_memo("程序员");
            //2 建立关系，把角色放到用户
            // user - - r1 , r2
            userDemo.getSetRole().add(role);
            userDemo.getSetRole().add(role1);
            // user1 - - r2 , r3
            userDemo1.getSetRole().add(role1);
            userDemo1.getSetRole().add(role2);
            //3 保存用户
            session.save(userDemo);
            session.save(userDemo1);

           tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void testDel(){
        Transaction tx = null;
        try {
            Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            UserDemo userDemo = session.get(UserDemo.class,1);
            session.delete(userDemo);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void test3(){
        Transaction tx = null;
        try{
            Session session = HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //让某个用户拥有某个角色
            //让mary拥有总经理角色
            //1 查询mary和总经理
            UserDemo mary = session.get(UserDemo.class,2);
            Role role= session.get(Role.class,1);
            //2 把角色放到用户的set集合里面
            mary.getSetRole().add(role);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public void test4(){
        Transaction tx = null;
        try {
            Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //让某个用户没有有某个角色
            //让mary没有有总经理角色
            //1 查询mary和总经理
            UserDemo mary = session.get(UserDemo.class,2);
            Role role= session.get(Role.class,1);
            //2 把角色从用户的set集合里面移除
            mary.getSetRole().remove(role);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}
