package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by pc on 2017/9/22.
 */
public class HibernateUtils {
    private static Configuration cfg = null;
    private static SessionFactory sessionFactory = null;
    static {
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }
    //提供返回与本地线程绑定的session的方法
    public static Session getSessionObject(){
        return sessionFactory.getCurrentSession();
    }
    public  SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void main(String [] args){

    }

}
