package br.edu.utfpr.baggins.util;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class Dao<T>
{
	protected static Logger logger = Logger.getLogger(HibernateUtil.class);
	protected Class<T> persistentClass;
	protected Session session;

	public Dao(Session session, Class<T> persistentClass)
	{
		this.session = session;
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T load(Integer id)
	{
		logger.info("lendo " + persistentClass + " com id " + id);
		return (T) session.load(persistentClass, id);
	}

	public void save(T t)
	{
		logger.info("Salvando: " + t);
		session.save(t);
	}

	public void delete(T t)
	{
		logger.info("Deletando: " + t);
		session.delete(t);
	}

	public void merge(T t)
	{
		logger.info("Salvando ou atualizando: " + t);
		session.merge(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> list()
	{
		logger.info("Listando Todos ");
		return session.createCriteria(persistentClass).list();
	}
}
