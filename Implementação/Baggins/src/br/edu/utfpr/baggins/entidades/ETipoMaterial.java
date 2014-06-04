package br.edu.utfpr.baggins.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tipo_material")
public class ETipoMaterial extends AbstraticEnty {

	@Column
	@Id
	private Long id;

	@Column
	private String nome;

	@Column
	private String descricao;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
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
		return this.id;
	}

	@Override
	public void setIdEntidade(Long id)
	{
		this.id = id;
	}
	
	
	
	
}
