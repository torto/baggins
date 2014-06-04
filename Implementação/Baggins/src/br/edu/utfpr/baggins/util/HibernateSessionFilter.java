package br.edu.utfpr.baggins.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HibernateSessionFilter implements Filter
{
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		HibernateUtil.openSession();
		try
		{
			HibernateUtil.currentSession().beginTransaction();
			chain.doFilter(request, response);
			HibernateUtil.currentSession().getTransaction().commit();
		}
		catch (Exception e)
		{
			throw new ServletException(e);
		}
		finally
		{
			HibernateUtil.closeCurrentSession();
		}
	}

	public void destroy()
	{
	}

}
