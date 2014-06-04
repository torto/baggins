package br.edu.utfpr.baggins.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ManagedBean
@SessionScoped
@Entity(name="modelo")
public class EModelo extends AbstraticEnty
{
	@Id
	@Column(name="id")
	private Long id;

	@Column
	private String descricao;

	@Column
	private String nome;

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
	public Object getNome()
	{
		return this.nome;
	}

	@Override
	public void setIdEntidade(Long id)
	{
		this.id = id;
	}

}
