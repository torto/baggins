package br.edu.utfpr.baggins.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "perfil")
public class EPerfil extends AbstraticEnty
{
	@Id
	@Column
	Integer id;
	
	@Column
	String nome;
	
	@Column
	String descricao;
	
	
	public EPerfil()
	{
		// TODO Auto-generated constructor stub
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getNome()
	{
		return nome;
	}


	public void setNome(String nome)
	{
		this.nome = nome;
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setIdEntidade(Long id)
	{
		// TODO Auto-generated method stub
		
	}
	
	
}
