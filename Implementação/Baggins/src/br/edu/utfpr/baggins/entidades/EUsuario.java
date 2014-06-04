package br.edu.utfpr.baggins.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "usuario")
public class EUsuario extends AbstraticEnty
{
	@Id
	@Column
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String login;
	
	@Column
	private String senha;
	
	@Column(name= "ra")
	private Integer numeroRa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "perfil_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private EPerfil perfil;
	
	public EUsuario()
	{
		// TODO Auto-generated constructor stub
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public Integer getNumeroRa()
	{
		return this.numeroRa;
	}

	public void setNumeroRa(Integer numeroRa)
	{
		this.numeroRa = numeroRa;
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
	public void setIdEntidade(Long id)
	{
		// TODO Auto-generated method stub
		
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	
}
