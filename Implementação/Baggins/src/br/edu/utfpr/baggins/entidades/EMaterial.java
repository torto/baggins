package br.edu.utfpr.baggins.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "material")
public class EMaterial extends AbstraticEnty
{

	@Column
	@Id
	private Long id;

	@Column(name="codigo_barras")
	private Integer codigoBarras;
	
	@Column
	private String nome;

	@Column
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private ECategoria categoria;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_material_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private ETipoMaterial tipoMaterial;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "materiais_consumo_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private EMaterialConsumo materialConsumo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "modelo_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private EModelo modelo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "marca_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private EMarca marca;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipamento_id", referencedColumnName = "id", insertable = true, updatable = true)
	@Fetch(FetchMode.JOIN)
	private EEquipamentos equipamento;
	
	public EMaterial()
	{
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

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public ECategoria getCategoria()
	{
		return categoria;
	}

	public void setCategoria(ECategoria categoria)
	{
		this.categoria = categoria;
	}

	public ETipoMaterial getTipoMaterial()
	{
		return tipoMaterial;
	}

	public void setTipoMaterial(ETipoMaterial tipoMaterial)
	{
		this.tipoMaterial = tipoMaterial;
	}

	public EMaterialConsumo getMaterialConsumo()
	{
		return materialConsumo;
	}

	public void setMaterialConsumo(EMaterialConsumo materialConsumo)
	{
		this.materialConsumo = materialConsumo;
	}

	public EModelo getModelo()
	{
		return modelo;
	}

	public void setModelo(EModelo modelo)
	{
		this.modelo = modelo;
	}

	public EMarca getMarca()
	{
		return marca;
	}

	public void setMarca(EMarca marca)
	{
		this.marca = marca;
	}

	public EEquipamentos getEquipamento()
	{
		return equipamento;
	}

	public void setEquipamento(EEquipamentos equipamento)
	{
		this.equipamento = equipamento;
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

	public Integer getCodigoBarras()
	{
		return codigoBarras;
	}

	public void setCodigoBarras(Integer codigoBarras)
	{
		this.codigoBarras = codigoBarras;
	}
	
	
	
}
