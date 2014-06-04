package br.edu.utfpr.baggins.client.componentes.ctabeladinamica;

import java.io.Serializable;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

public class CControleTabelaDinamica implements Serializable
{

	public static MethodExpression criasMethodExpression(String methodExpression, Class<?> valueType)
	{
		return FacesContext.getCurrentInstance().getApplication().getExpressionFactory().createMethodExpression(FacesContext.getCurrentInstance().getELContext(), methodExpression, valueType, new Class<?>[0]);
	}

	public static ValueExpression criarValueExpression(String valueExpression, Class object)
	{
		return FacesContext.getCurrentInstance().getApplication().getExpressionFactory().createValueExpression(FacesContext.getCurrentInstance().getELContext(), valueExpression, object);

	}

	public static String limparNomeClasse(String classe, String valorEstatico)
	{

		String retorno = classe.replace("class ", "");

		retorno = retorno.replace(valorEstatico, "");
		return retorno;
	}
}
