package br.edu.utfpr.baggins.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "acessos")
public class EAcessos extends AbstraticEnty
{
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private Integer valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "perfil_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private EPerfil perfil;
	
	public EAcessos()
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

	public Integer getValor()
	{
		return valor;
	}

	public void setValor(Integer valor)
	{
		this.valor = valor;
	}

	public EPerfil getPerfil()
	{
		return perfil;
	}

	public void setPerfil(EPerfil perfil)
	{
		this.perfil = perfil;
	}

	@Override
	public Object getIdEntidade()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getNome()
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
