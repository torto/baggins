package br.edu.utfpr.baggins.client.devolucao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.utfpr.baggins.entidades.EMaterial;
import br.edu.utfpr.baggins.server.controle.VEstaticaTipoMaterial;
import br.edu.utfpr.baggins.server.controle.emprestimo.CControlePUEmprestimo;

@ManagedBean
@SessionScoped
public class DevolucaoBean
{

	private HashMap<String, Integer> mapaTipoMaterial;
	private String tipoMaterialSelecionado;
	
	private EMaterial materialSelecionado;
	private ModelDevolucao modelDevolucao;
	
	
	private List<EMaterial> listaBuscar;
	
	
	public DevolucaoBean()
	{
		buscarMaterial("");
		mapaTipoMaterial = new HashMap<String, Integer>();
		mapaTipoMaterial.put(VEstaticaTipoMaterial.NomeVariavel.MATERIAL, VEstaticaTipoMaterial.ValorVariavel.MATERIAL);
		mapaTipoMaterial.put(VEstaticaTipoMaterial.NomeVariavel.MATERIAL_CONSUMO, VEstaticaTipoMaterial.ValorVariavel.MATERIAL_CONSUMO);
		mapaTipoMaterial.put(VEstaticaTipoMaterial.NomeVariavel.AMBIENTE, VEstaticaTipoMaterial.ValorVariavel.AMBIENTE);
		
	}
	
	public void buscarMaterial(String filtro)
	{
		setListaBuscar((ArrayList<EMaterial>)CControlePUEmprestimo.buscarListaMaterial(filtro));
	}
	
	// variais instaciadas
	
	
	public EMaterial getMaterialSelecionado()
	{
		return materialSelecionado;
	}

	public String getTipoMaterialSelecionado()
	{
		return tipoMaterialSelecionado;
	}

	public void setTipoMaterialSelecionado(String tipoMaterialSelecionado)
	{
		this.tipoMaterialSelecionado = tipoMaterialSelecionado;
	}

	public void setMaterialSelecionado(EMaterial materialSelecionado)
	{
		this.materialSelecionado = materialSelecionado;
	}

	public HashMap<String, Integer> getMapaTipoMaterial()
	{
		return mapaTipoMaterial;
	}

	public void setMapaTipoMaterial(HashMap<String, Integer> mapaTipoMaterial)
	{
		this.mapaTipoMaterial = mapaTipoMaterial;
	}

	public List<EMaterial> getListaBuscar()
	{
		return listaBuscar;
	}

	public void setListaBuscar(List<EMaterial> listaBuscar)
	{
		this.listaBuscar = listaBuscar;
	}

	public ModelDevolucao getModelDevolucao()
	{
		return modelDevolucao;
	}

	public void setModelDevolucao(ModelDevolucao modelDevolucao)
	{
		this.modelDevolucao = modelDevolucao;
	}
	
}
