package br.edu.utfpr.baggins.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="fornecedor")
public class EFornecedores extends AbstraticEnty {

	@Id
	@Column
	private Long id;
	
	@Column(name="nome_fantasia")
	private String nomeFantasia;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	@Column(name="nome_contato")
	private String nomeContato;
	
	@Column
	private String email;
	
	@Column
	private String telefone;
	
	@Column
	private String fax;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNomeFantasia()
	{
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia)
	{
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial()
	{
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	public String getNomeContato()
	{
		return nomeContato;
	}

	public void setNomeContato(String nomeContato)
	{
		this.nomeContato = nomeContato;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}

	public String getFax()
	{
		return fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}

	@Override
	public Object getIdEntidade()
	{
		return this.id;
	}

	@Override
	public Object getNome()
	{
		return this.nomeContato;
	}

	@Override
	public void setIdEntidade(Long id)
	{
		this.id= id;
	}
	
	
	
}
