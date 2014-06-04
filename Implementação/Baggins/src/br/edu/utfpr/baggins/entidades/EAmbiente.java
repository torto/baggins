package br.edu.utfpr.baggins.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.edu.utfpr.baggins.client.componentes.ctabeladinamica.TabelaDinamica;

@Entity(name="ambiente")
@ManagedBean
@SessionScoped
public class EAmbiente extends AbstraticEnty{

	@Id
	@Column
	@TabelaDinamica(visivel= false)
	private Long id;
	
	@Column(name="identificacao")
	@TabelaDinamica(nomeCampo="Identificação",grid= true)
	private String identificacao;
	
	@Column(name="descricao")
	@TabelaDinamica(grid= true, nomeCampo="Descrição")
	private String descricao;
	
	@Column(name="observacao")
	@TabelaDinamica(grid= true, nomeCampo="Observação")
	private String observacao;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getIdentificacao()
	{
		return identificacao;
	}

	public void setIdentificacao(String identificacao)
	{
		this.identificacao = identificacao;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public String getObservacao()
	{
		return observacao;
	}

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
	}

	@Override
	public Object getIdEntidade()
	{
		return this.id;
	}

	@Override
	public Object getNome()
	{
		return this.descricao;
	}

	@Override
	public void setIdEntidade(Long id)
	{
		this.id = id;
	}
	
}
