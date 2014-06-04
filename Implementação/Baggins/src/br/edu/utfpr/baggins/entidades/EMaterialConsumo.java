package br.edu.utfpr.baggins.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "materiais_consumo")
public class EMaterialConsumo extends AbstraticEnty
{

	@Column
	@Id
	private Long id;

	@Column
	private String nome;

	@Column
	private String descricao;

	@Column(name="quantidade_atual")
	private Integer quantidadeAtual;

	@Column(name="quantidade_min")
	private Integer quantidadeMin;

	public EMaterialConsumo()
	{
		// TODO Auto-generated constructor stub
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

	public Integer getQuantidadeAtual()
	{
		return quantidadeAtual;
	}

	public void setQuantidadeAtual(Integer quantidadeAtual)
	{
		this.quantidadeAtual = quantidadeAtual;
	}

	public Integer getQuantidadeMin()
	{
		return quantidadeMin;
	}

	public void setQuantidadeMin(Integer quantidadeMin)
	{
		this.quantidadeMin = quantidadeMin;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	@Override
	public Object getIdEntidade()
	{
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public Object getNome()
	{
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public void setIdEntidade(Long id)
	{
		this.id = id;

	}

}
