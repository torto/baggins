package br.edu.utfpr.baggins.entidades;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "equipamentos")
public class EEquipamentos extends AbstraticEnty {

	@Id
	@Column
	private Long id;
	
	@Column
	private String nome;
	
	@Column(name="codigo_barras")
	private Long codigoBarras;
	
	@Column
	private String patrimonio;
	
	@Column
	private Long partNumber;
	
	@Column(name="data_aquisicao")
	@Temporal(TemporalType.DATE)
	private Date dataAquisicao;
	
	@Column
	private String observacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fornecedor_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private EFornecedores fornecedor;
	
	public EEquipamentos()
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

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Long getCodigoBarras()
	{
		return codigoBarras;
	}

	public void setCodigoBarras(Long codigoBarras)
	{
		this.codigoBarras = codigoBarras;
	}

	public String getPatrimonio()
	{
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio)
	{
		this.patrimonio = patrimonio;
	}

	public Long getPartNumber()
	{
		return partNumber;
	}

	public void setPartNumber(Long partNumber)
	{
		this.partNumber = partNumber;
	}

	public Date getDataAquisicao()
	{
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao)
	{
		this.dataAquisicao = dataAquisicao;
	}

	public String getObservacao()
	{
		return observacao;
	}

	public void setObservacao(String observacao)
	{
		this.observacao = observacao;
	}

	public EFornecedores getFornecedor()
	{
		return fornecedor;
	}

	public void setFornecedor(EFornecedores fornecedor)
	{
		this.fornecedor = fornecedor;
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
	
	
	
	
	
}
