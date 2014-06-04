package br.edu.utfpr.baggins.client.emprestimo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

import br.edu.utfpr.baggins.client.CControleGeral;
import br.edu.utfpr.baggins.entidades.EEmprestimoMaterial;
import br.edu.utfpr.baggins.entidades.EMaterial;
import br.edu.utfpr.baggins.entidades.ETipoMaterial;
import br.edu.utfpr.baggins.entidades.EUsuario;
import br.edu.utfpr.baggins.server.controle.emprestimo.CControlePUEmprestimo;

@ManagedBean
@SessionScoped
public class EmprestimoBean implements Serializable
{

	private List<EMaterial> material;
	private EMaterial materialSelecionadoGrid;
	private ModelEmprestimo modelEmprestimo;
	private Long id;

	// INFORMACAOES EMPRESTIMO

	private EUsuario usuarioSelecionado;
	private String quantidade;

	private HashMap<String, Integer> mapaTipoMaterial;
	private Object tipoMaterialSelecionado;

	private EEmprestimoMaterial emprestimoMaterial;

	private List<EEmprestimoMaterial> arrayMaterialEmprestimo;

	public EmprestimoBean()
	{
		material = new ArrayList<EMaterial>();
		mapaTipoMaterial = new HashMap<String, Integer>();

		arrayMaterialEmprestimo = new ArrayList<EEmprestimoMaterial>();

		EEmprestimoMaterial aa = new EEmprestimoMaterial();
		EMaterial ma = new EMaterial();
		ma.setNome("Material");
		aa.setQuantidade(10.0);
		aa.setMaterial(ma);
		arrayMaterialEmprestimo.add(aa);

		List<ETipoMaterial> listaTipoMaterial = CControlePUEmprestimo.buscarListaTipoMaterial("");

		for (ETipoMaterial eTipoMaterial : listaTipoMaterial)
		{
			mapaTipoMaterial.put(eTipoMaterial.getNome(), eTipoMaterial.getId().intValue());
		}

		buscarMaterial("");
	}

	public List<EEmprestimoMaterial> getArrayMaterialEmprestimo()
	{
		return arrayMaterialEmprestimo;
	}

	public void setArrayMaterialEmprestimo(List<EEmprestimoMaterial> arrayMaterialEmprestimo)
	{
		this.arrayMaterialEmprestimo = arrayMaterialEmprestimo;
	}

	public EEmprestimoMaterial getEmprestimoMaterial()
	{
		return emprestimoMaterial;
	}

	public void setEmprestimoMaterial(EEmprestimoMaterial emprestimoMaterial)
	{
		this.emprestimoMaterial = emprestimoMaterial;
	}

	public HashMap<String, Integer> getMapaTipoMaterial()
	{
		return mapaTipoMaterial;
	}

	public void setMapaTipoMaterial(HashMap<String, Integer> mapaTipoMaterial)
	{
		this.mapaTipoMaterial = mapaTipoMaterial;
	}

	public void buscarMaterial(String filtro)
	{
		setMaterial((ArrayList<EMaterial>) CControlePUEmprestimo.buscarListaMaterial(filtro));
	}

	public List<EMaterial> getMaterial()
	{
		return material;
	}
	
	public EUsuario getUsuarioSelecionado()
	{
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(EUsuario usuarioSelecionado)
	{
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public String getQuantidade()
	{
		return quantidade;
	}

	public void setQuantidade(String quantidade)
	{
		this.quantidade = quantidade;
	}

	public Object getTipoMaterialSelecionado()
	{
		return tipoMaterialSelecionado;
	}

	public void setTipoMaterialSelecionado(Object tipoMaterialSelecionado)
	{
		this.tipoMaterialSelecionado = tipoMaterialSelecionado;
	}

	public void setMaterial(List<EMaterial> material)
	{
		this.material = material;
	}

	public EMaterial getMaterialSelecionadoGrid()
	{
		return materialSelecionadoGrid;
	}

	public void setMaterialSelecionadoGrid(EMaterial materialSelecionadoGrid)
	{
		this.materialSelecionadoGrid = materialSelecionadoGrid;
	}

	public ModelEmprestimo getModelEmprestimo()
	{
		return modelEmprestimo;
	}

	public void setModelEmprestimo(ModelEmprestimo modelEmprestimo)
	{
		this.modelEmprestimo = modelEmprestimo;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void listenerCodUsuario(AjaxBehaviorEvent event)
	{
		HtmlInputText input = ((HtmlInputText) event.getComponent());
		
		SelectOneMenu tipoMaterial = (SelectOneMenu)CControleGeral.getUIComponent("campoEmprestimo:tipoMaterial");
		
		tipoMaterial.getValue();
		
		String escrita = input.getValue().toString();
		boolean erro = true;

		if (!escrita.isEmpty())
		{
			usuarioSelecionado = CControlePUEmprestimo.buscarUsuario(escrita);

			if (usuarioSelecionado != null)
			{
				erro = false;
			}
		}

		CControleGeral.campoIcones(erro, "campoEmprestimo:imgCodUsu", escrita);
	}

	public void listenerCodMaterial(AjaxBehaviorEvent event)
	{
		HtmlInputText input = ((HtmlInputText) event.getComponent());
		
		SelectOneMenu a = (SelectOneMenu) CControleGeral.getUIComponent("campoEmprestimo:tipoMaterial");
//		a.getValue();

		String escrita = input.getValue().toString();
		boolean erro = true;

		if (!escrita.isEmpty())
		{
			materialSelecionadoGrid = CControlePUEmprestimo.buscarMaterial(escrita);

			if (materialSelecionadoGrid != null)
			{
				erro = false;
			}
		}

		CControleGeral.campoIcones(erro, "campoEmprestimo:imgCodMat", escrita);
	}

	public void onRowSelect(SelectEvent event)
	{
		HtmlInputText input = (HtmlInputText) CControleGeral.getUIComponent("campoEmprestimo:codMat");
		
		input.setValue(materialSelecionadoGrid.getCodigoBarras());
		
		CControleGeral.campoIcones(false,"campoEmprestimo:imgCodMat" , materialSelecionadoGrid.getCodigoBarras()+"");
	}

}
