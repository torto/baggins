package br.edu.utfpr.baggins.util;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class CSessao
{
	private Session sessao;
	
	public CSessao()
	{
		
	}
	
	public Session abrirSessao()
	{
		sessao = HibernateUtil.currentSession().getSessionFactory()
				.openSession();
		sessao.beginTransaction();

		return sessao;
	}

	public int inserir(Object objt, boolean commit)
	{
		int i = 0;
		try
		{

			if (!sessao.isOpen())
			{
				i = -1;
			}

			sessao.save(objt);

			if (commit)
			{
				sessao.flush();
				sessao.getTransaction().commit();
			}

			i = 1;
		}
		catch (Exception e)
		{
			if (commit)
			{
				sessao.getTransaction().rollback();
				sessao.disconnect();
				e.printStackTrace();
			}
			i = -1;
		}
		
		return i;
	}
	
	public int inserirOuAlterar(Object objt, boolean commit)
	{
		int i = 0;
		try
		{
			if (!sessao.isOpen())
			{
				i = -1;
			}

			sessao.saveOrUpdate(objt);

			if (commit)
			{
				sessao.flush();
				sessao.getTransaction().commit();
			}

			i = 1;
		}
		catch (Exception e)
		{
			if (commit)
			{
				sessao.getTransaction().rollback();
				sessao.disconnect();
				e.printStackTrace();
			}
			i = -1;
		}
		
		return i;
	}
	
	public int alterar(Object objt, boolean commit)
	{
		int i = 0;
		try
		{
			

			if (!sessao.isOpen())
			{
				i = -1;
			}

			sessao.update(objt);

			if (commit)
			{
				sessao.flush();
				sessao.getTransaction().commit();
			}

			i = 1;
		}
		catch (Exception e)
		{
			if (commit)
			{
				sessao.getTransaction().rollback();
				sessao.disconnect();
				e.printStackTrace();
			}
			i = -1;
		}
		
		return i;
	}
	
	public int excluir(Object objt, boolean commit)
	{
		int i = 0;
		try
		{
			

			if (!sessao.isOpen())
			{
				i = -1;
			}

			sessao.delete(objt);

			if (commit)
			{
				sessao.flush();
				sessao.getTransaction().commit();
			}

			i = 1;
		}
		catch (Exception e)
		{
			if (commit)
			{
				sessao.getTransaction().rollback();
				sessao.disconnect();
				e.printStackTrace();
			}
			i = -1;
		}
		
		return i;
	}
	
	public Criteria createCriteria(Class type)
	{
		return sessao.createCriteria(type);
	}

	public Criteria createCriteria(Class type, String alias)
	{
		return sessao.createCriteria(type, alias);
	}

	public SQLQuery createSQLQuery(String string)
	{
		return sessao.createSQLQuery(string);
	}

	public Query createQuery(String string)
	{
		return sessao.createQuery(string);
	}

	public void lock(Object object)
	{
		sessao.lock(object, LockMode.NONE);
	}

	public void commit()
	{
		sessao.getTransaction().commit();
	}

	public void rollback()
	{
		sessao.getTransaction().rollback();
	}

	public void beginTransaction()
	{
		sessao.beginTransaction();
	}

}
