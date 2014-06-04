package br.edu.utfpr.baggins.server.controle;

import java.util.List;

import org.hibernate.Query;

import br.edu.utfpr.baggins.util.CSessao;

public class CControlePU
{

	public static List<?> buscaList(Class classe, String where)
	{

		CSessao sessao = new CSessao();
		StringBuilder stringQuery = new StringBuilder();
		List<Object> list = null;
		try
		{
			sessao.abrirSessao();

			stringQuery.append("SELECT obj FROM ");
			stringQuery.append(classe.getName());
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

	public static Object buscaUnique(Class classe, String where)
	{
		
		CSessao sessao = new CSessao();
		StringBuilder stringQuery = new StringBuilder();
		Object result = null;
		try
		{
			sessao.abrirSessao();
			
			stringQuery.append("SELECT obj FROM ");
			stringQuery.append(classe.getName());
			stringQuery.append(" obj");
			
			if (!where.isEmpty())
			{
				stringQuery.append(" WHERE ");
				stringQuery.append(where);
			}
			
			Query query = sessao.createQuery(stringQuery.toString());
			
			result = query.uniqueResult();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
		
	}

}
