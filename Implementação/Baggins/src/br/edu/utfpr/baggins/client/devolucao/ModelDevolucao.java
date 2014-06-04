package br.edu.utfpr.baggins.client.devolucao;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.edu.utfpr.baggins.entidades.EMaterial;

public class ModelDevolucao extends ListDataModel<EMaterial> implements
		SelectableDataModel<EMaterial>, Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3871993688956247863L;

	public ModelDevolucao(List<EMaterial> list)
	{
		super(list);
	}

	@Override
	public EMaterial getRowData(String arg0)
	{
		List<EMaterial> list = (List<EMaterial>) getWrappedData();

		for (EMaterial eMaterial : list)
		{
			if (eMaterial.getId() == (new Long(arg0)))
			{
				return eMaterial;
			}
		}

		return null;
	}

	@Override
	public Object getRowKey(EMaterial arg0)
	{
		return arg0.getIdEntidade();
	}

}
