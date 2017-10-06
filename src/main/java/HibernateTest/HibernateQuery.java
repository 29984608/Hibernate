package HibernateTest;

import Utils.HibernateUtils;
import entity.User;
import org.hibernate.*;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class HibernateQuery {

    public void QueryText(){
        Transaction tx =null;
        try {
           Session session= HibernateUtils.getSessionObject();
            tx = session.beginTransaction();
            //1 创建Query对象
            Query query= session.createQuery("from entity.User");
            //2 调用query对象里面的方法得到结果
            List<User> list = query.list();
            for (User user :list){
                System.out.println(user);
            }

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    @Test
    public void CriteriaText() {
        Transaction tx = null;
        try {
           Session session= HibernateUtils.getSessionObject();
           tx= session.beginTransaction();
            //1 创建Criteria
             Criteria criteria= session.createCriteria(User.class);
            //2 调用对象里面的方法得到结果
            List<User> list= criteria.list();
            for (User user:list){
                System.out.println(user);
            }
           tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    @Test
    public  void SQLQueryText(){
        Transaction tx =null;
        try {
           Session session = HibernateUtils.getSessionObject();
           tx = session.beginTransaction();
            //1.创建对象
          SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM t_user ");
          //返回的list中每部分是对象形式
            //设置数据返回到哪个实体类
           // sqlQuery.addEntity(User.class);
          //2.调用方法得到结果
/*           List<User> list= sqlQuery.list();
           for (User user:list){
               System.out.println(user);
           }*/

           //2.调用方法得到结果
             List<Object[]> list= sqlQuery.list();
             for (Object[] objects:list){
                 System.out.println(Arrays.toString(objects));
             }
           tx.rollback();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
}
