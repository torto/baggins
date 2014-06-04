package br.com.guilherme.componentes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlPanelGroup;

public class CTabelaDinamica
{
	private Class<?> objetoClass;
	private Object objeto;

	private HtmlInputText campoNovo;

	private HtmlPanelGrid grid;
	
	private HtmlPanelGroup principal;

	public CTabelaDinamica(Object objeto)
	{
		this.objetoClass = objeto.getClass();
		this.objeto = objeto;

		instaciarObjetos();
		obterInformacoesEntidade();
		setarInformacoes();
	}

	private void instaciarObjetos()
	{
		principal = new HtmlPanelGroup();
		grid = new HtmlPanelGrid();
	}
	
	private void setarInformacoes(){
		setColunasForms(2);
	}

	public CTabelaDinamica()
	{
		principal = new HtmlPanelGroup();
	}

	public void adicionarCampo(String descricao, UIComponent widget)
	{
		principal.getChildren().add(gerarFormCampo(descricao, widget));
	}

	private HtmlPanelGrid gerarFormCampo(String descricao, UIComponent widget)
	{
		grid.setRowClasses("textoDireita");
		HtmlOutputText campoDescricao = new HtmlOutputText();
		campoDescricao.setValue(descricao + ":");
		

		if (widget instanceof HtmlInputText)
		{
			((HtmlInputText) widget).setStyleClass("edtBusca");
		}

		grid.getChildren().add(campoDescricao);
		grid.getChildren().add(widget);

		return grid;

	}

	private void obterInformacoesEntidade()
	{
		try
		{
			for (Field field : getFieldObjeto())
			{
				String nome = field.getName();
				
				campoNovo = new HtmlInputText();
				adicionarCampo(nome, campoNovo);

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	private Method[] getMetodosObjeto()
	{
		return objetoClass.getDeclaredMethods();
	}

	private Field[] getFieldObjeto()
	{
		return objetoClass.getDeclaredFields();
	}

	public Class<?> getObjetoClass()
	{
		return objetoClass;
	}

	public void setObjetoClass(Class<?> objeto)
	{
		this.objetoClass = objeto;
	}

	public HtmlPanelGroup getPrincipal()
	{
		return principal;
	}

	public void setPrincipal(HtmlPanelGroup principal)
	{
		this.principal = principal;
	}
	
	public void setColunasForms(int colunas){
		grid.setColumns(colunas);
	}
	
	public void setStyleClassForms(String style){
		grid.setStyleClass(style);
	}
}
