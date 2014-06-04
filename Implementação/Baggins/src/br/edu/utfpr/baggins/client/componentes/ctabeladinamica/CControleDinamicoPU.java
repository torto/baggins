package br.edu.utfpr.baggins.client.componentes.ctabeladinamica;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.utfpr.baggins.entidades.AbstraticEnty;
import br.edu.utfpr.baggins.entidades.ECategoria;
import br.edu.utfpr.baggins.server.controle.VEstaticasHibernate;
import br.edu.utfpr.baggins.util.CSessao;

public class CControleDinamicoPU implements Serializable
{
	
	public CControleDinamicoPU()
	{
		System.out.println("EXECU");
	}

	public static List<Object> getListDinamic(String classe, String where)
	{

		CSessao sessao = new CSessao();
		StringBuilder stringQuery = new StringBuilder();
		List<Object> list = null;
		try
		{
			sessao.abrirSessao();

			stringQuery.append("SELECT obj FROM ");
			stringQuery.append(classe);
			stringQuery.append("obj");

			if (!where.isEmpty())
			{
				stringQuery.append(" WHERE ");
				stringQuery.append(where);
			}

			Query query = sessao.createQuery(stringQuery.toString());

			list = query.list();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return list;

	}

	public List<Object> getListDinamicHash(String classe, String where)
	{

		CSessao sessao = new CSessao();
		HashMap<Object, Object> mapa = new HashMap<Object, Object>();
		StringBuilder stringQuery = new StringBuilder();
		List<Object> list = null;
		try
		{
			sessao.abrirSessao();

			stringQuery.append("SELECT obj FROM ");
			stringQuery.append(classe);
			stringQuery.append(" obj");

			if (!where.isEmpty())
			{
				stringQuery.append(" WHERE ");
				stringQuery.append(where);
			}

			Query query = sessao.createQuery(stringQuery.toString());

			list = query.list();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return list;

	}

	public static Object getObjectById(String classe, String id)
	{
		Object obj = null;
		CSessao sessao = new CSessao();
		StringBuilder stringQuery = new StringBuilder();
		try
		{
			sessao.abrirSessao();

			stringQuery.append("SELECT obj FROM ");
			stringQuery.append(classe);
			stringQuery.append(" obj ");
			stringQuery.append(" WHERE obj.id = ");
			stringQuery.append(id);

			Query query = sessao.createQuery(stringQuery.toString());

			obj = query.uniqueResult();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return obj;

	}

	public static List<?> getListBuscaGenericaaa(Class classe, String filtro)
	{

		List<Object> obj = null;

		try
		{
			int vezes = 0;

			CSessao sessao = new CSessao();

			sessao.abrirSessao();

			StringBuilder stringQuery = new StringBuilder();

			stringQuery.append("SELECT obj FROM ");
			stringQuery.append(classe.getName());
			stringQuery.append(" obj");

			if (!filtro.isEmpty())
			{
				stringQuery.append(" WHERE ");

				for (Field field : classe.getDeclaredFields())
				{
					for (Annotation ano : field.getDeclaredAnnotations())
					{
						if (ano instanceof TabelaDinamica)
						{

							TabelaDinamica aa = (TabelaDinamica) ano;

							if (aa.grid())
							{
								if (vezes != 0)
								{
									stringQuery.append(" OR ");
								}
								vezes++;

								stringQuery.append("obj.");
								stringQuery.append(field.getName());

								if (field.getType().isPrimitive())
								{
									stringQuery.append(" = ");
								}
								else
								{
									stringQuery.append(" like '%");
								}
								stringQuery.append(filtro);
								if (!field.getType().isPrimitive())
								{
									stringQuery.append("%'");
								}
							}

						}
					}
				}
			}

			Query query = sessao.createQuery(stringQuery.toString());

			obj = query.list();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return obj;

	}

	public static List<Object> buscaGenericaNova(Class classe, String filtro)
	{

		List<Object> retorno = null;

		try
		{
			int vezes = 0;

			CSessao sessao = new CSessao();

			sessao.abrirSessao();

			Criteria criteria = sessao.createCriteria(classe, "obj");

			Disjunction or = Restrictions.disjunction();
			
			for (Field field : classe.getDeclaredFields())
			{
				
				
				for (Annotation ano : field.getDeclaredAnnotations())
				{
					if (ano instanceof TabelaDinamica)
					{

						TabelaDinamica aa = (TabelaDinamica) ano;
						
						if(aa.visivel()){
							
							if(field.getType().isPrimitive() && !field.getType().isAssignableFrom(Date.class) || field.getType().isAssignableFrom(String.class))
							{
								or.add(Restrictions.like("obj." + field.getName(), filtro, MatchMode.ANYWHERE));
							} else {
								criteria.createAlias("obj." + field.getName(), "teste"+field.getName());
								or.add(Restrictions.like("teste"+field.getName()+"."+ aa.comboBoxVariavel(), filtro, MatchMode.ANYWHERE));
							}
						}

					}
				}
			}
			
			criteria.add(or);
			
			retorno = criteria.list();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return retorno;
	}

	public static void inserirObjeto(Object obj)
	{

		CSessao sessao = new CSessao();
		try
		{
			sessao.abrirSessao();

			if (((AbstraticEnty) obj).getIdEntidade() == null)
			{
				((AbstraticEnty) obj).setIdEntidade((pegarUltimoId(obj) + 1l));
			}

			sessao.inserirOuAlterar(obj, true);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Object inserirObjetoRetorno(Object obj)
	{

		CSessao sessao = new CSessao();
		try
		{
			sessao.abrirSessao();

			if (((AbstraticEnty) obj).getIdEntidade() == null)
			{
				((AbstraticEnty) obj).setIdEntidade((pegarUltimoId(obj) + 1l));
			}

			sessao.inserirOuAlterar(obj, true);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return obj;
	}

	public static void excluirObjeto(Object obj)
	{

		CSessao sessao = new CSessao();
		try
		{
			sessao.abrirSessao();

			sessao.excluir(obj, true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static long pegarUltimoId(Object obj)
	{
		Long retorno = null;
		String classe = obj.getClass().getName();

		CTabelaDinamica.limparNomeClasse(classe);

		CSessao sessao = new CSessao();
		try
		{
			sessao.abrirSessao();

			Query q = sessao.createQuery("select max(id) from " + classe
					+ " as obj");

			retorno = (Long) q.uniqueResult();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return retorno;
	}

	public static void main(String[] args)
	{
		System.out.println(pegarUltimoId(new ECategoria()));
	}

}
