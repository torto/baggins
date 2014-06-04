package br.edu.utfpr.baggins.client.componentes.ctabeladinamica;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.edu.utfpr.baggins.entidades.AbstraticEnty;

public class DataModel<T extends Object> extends ListDataModel<T> implements
		SelectableDataModel<T>, Serializable
{

	public DataModel(List<T> list)
	{
		super(list);
	}

	@Override
	public T getRowData(String arg0)
	{
		List<Object> list = (List<Object>) getWrappedData();
		
		for (Object ejb : list)
		{
			{
				if (((AbstraticEnty)ejb).getIdEntidade() == (new Long(arg0)))
				{
					return (T) ejb;
				}
			}
		}
		return null;

	}

	@Override
	public Object getRowKey(T arg0)
	{
		return ((AbstraticEnty)arg0).getIdEntidade();
	}
}