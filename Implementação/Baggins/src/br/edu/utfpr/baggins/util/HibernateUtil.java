package br.edu.utfpr.baggins.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil
{
	private static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();

    static{
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static Session openSession(){
        if (sessions.get()!= null){
            logger.error("Sessao já aberta");
        }
        sessions.set(sessionFactory.openSession());
        return sessions.get();
    }
    public static void closeCurrentSession(){
        sessions.get().close();
        sessions.set(null);
    }
    public static Session currentSession(){
        return sessions.get();
    }
}
