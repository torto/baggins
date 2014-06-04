package br.edu.utfpr.baggins.client.emprestimo;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.edu.utfpr.baggins.entidades.EMaterial;

public class ModelEmprestimo extends ListDataModel<EMaterial> implements
SelectableDataModel<EMaterial>, Serializable
{

	public ModelEmprestimo(List<EMaterial> list)
	{
		super(list);
	}
	
	@Override
	public EMaterial getRowData(String arg0)
	{
		List<EMaterial> list = (List<EMaterial>) getWrappedData();
		
		for (EMaterial eMaterial : list)
		{
			if(eMaterial.getId() == (new Long(arg0))){
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
