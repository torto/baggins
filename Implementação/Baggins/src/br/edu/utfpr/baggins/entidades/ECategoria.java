package br.edu.utfpr.baggins.entidades;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.utfpr.baggins.client.componentes.ctabeladinamica.TabelaDinamica;

@ManagedBean
@SessionScoped
@Entity(name = "categoria")
public class ECategoria extends AbstraticEnty
{
	@TabelaDinamica(visivel = false)
	@Column
	@Id
	private Long id;

	@TabelaDinamica(grid = true)
	@Column
	private String nome;
	
	@TabelaDinamica(grid = true, nomeCampo = "Descri��o")
	@Column
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "marca", referencedColumnName = "id")
	@TabelaDinamica(nomeCampo = "Marcas", comboBoxVariavel="nome")
	private EMarca marca;
	
	@ManyToOne
	@JoinColumn(name = "modelo", referencedColumnName = "id")
	@TabelaDinamica(nomeCampo = "Modelos", comboBoxVariavel="nome")
	private EModelo modelo;
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	@Override
	public Object getIdEntidade()
	{
		return this.id;
	}

	@Override
	public void setIdEntidade(Long id)
	{
		this.id = id;
	}

	public EMarca getMarca()
	{
		return marca;
	}

	public void setMarca(EMarca marca)
	{
		this.marca = marca;
	}

	public EModelo getModelo()
	{
		return modelo;
	}

	public void setModelo(EModelo modelo)
	{
		this.modelo = modelo;
	}
	
}
